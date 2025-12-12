package ru.netology;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final int SERVER_SOCKET = 9999;
    private static final int poolSizeThreads = 64;

    public static void main(String[] args) throws InterruptedException {
        Server server = new Server(SERVER_SOCKET, poolSizeThreads);
        server.start();
    }
}