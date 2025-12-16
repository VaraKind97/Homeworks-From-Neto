package ru.netology;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.HashMap;
import java.net.URISyntaxException;

public class Server {
    private final int port;
    private final List<String> validPaths = List.of("/index.html",
            "/spring.svg",
            "/spring.png",
            "/resources.html",
            "/styles.css",
            "/app.js",
            "/links.html",
            "/forms.html",
            "/classic.html",
            "/events.html",
            "/events.js");
    private final ExecutorService executorService;
    private final ConcurrentHashMap<String, Map<String, Handler>> handlers;
    
    public Server(int serverSocket, int poolSize) {
        port = serverSocket;
        executorService = Executors.newFixedThreadPool(poolSize);
        handlers = new ConcurrentHashMap<>();
    }

    void start() {
        try (final var serverSocket = new ServerSocket(port)) {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                executorService.execute(() -> connection(socket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }

    private void connection(Socket socket) {
        try (final var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             final var out = new BufferedOutputStream(socket.getOutputStream())) {
            final var requestLine = in.readLine();
            final var parts = requestLine.split(" ");
            String method = parts[0];
            final var path = parts[1];
            Request request = new Request(method, path);
            var param = request.getQueryParam("last");
            var params = request.getQueryParams();

            if (!params.isEmpty()) {
                System.out.println(param);
                System.out.println(params);
            }
            System.out.println(path);

            if (!handlers.containsKey(request.getMethod())) {
                responseWithoutContent(out, String.valueOf(404), "Not found");
                return;
            }

            Map<String, Handler> handlerMap = handlers.get(request.getMethod());
            String pathRequest = request.getPath();

            if(handlerMap.containsKey(pathRequest)) {
                Handler handler = handlerMap.get(pathRequest);
                handler.handle(request, out);
            } else {
                if (!validPaths.contains(request.getPath())) {
                    //404
                    responseWithoutContent(out, String.valueOf(404), "Not found");
                } else {
                    defaultHandler(out, path);
                }
            }

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    protected void defaultHandler(BufferedOutputStream out, String path) throws IOException {
        final var filePath = Path.of(".", "public", path);
        final var mimeType = Files.probeContentType(filePath);

        // special case for classic
        if (path.equals("/classic.html")) {
            final var template = Files.readString(filePath);
            final var content = template.replace(
                    "{time}",
                    LocalDateTime.now().toString()
            ).getBytes();
            out.write((
                    "HTTP/1.1 200 OK\r\n" +
                            "Content-Type: " + mimeType + "\r\n" +
                            "Content-Length: " + content.length + "\r\n" +
                            "Connection: close\r\n" +
                            "\r\n"
            ).getBytes());
            out.write(content);
            out.flush();
            return;
        }

        final var length = Files.size(filePath);
        out.write((
                "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: " + mimeType + "\r\n" +
                        "Content-Length: " + length + "\r\n" +
                        "Connection: close\r\n" +
                        "\r\n"
        ).getBytes());
        Files.copy(filePath, out);
        out.flush();
    }

    protected void responseWithoutContent(BufferedOutputStream out, String responseCode, String responseStatus) throws IOException {
        out.write((
                "HTTP/1.1 " + responseCode + " " + responseStatus + "\r\n" +
                        "Content-Length: 0\r\n" +
                        "Connection: close\r\n" +
                        "\r\n"
        ).getBytes());
        out.flush();
    }

    protected void addHandler(String method, String path, Handler handler) {
        if (!handlers.containsKey(method)) {
            handlers.put(method, new HashMap<>());
        }
        handlers.get(method).put(path, handler);
    }
}



