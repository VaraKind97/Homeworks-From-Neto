package ru.netology.springboot_rest_task1.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springboot_rest_task1.model.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        if (user.equals("Dima") && password.equals("8080")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("Alex") && password.equals("9999")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        } else if (user.equals("Michael") && password.equals("1234")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        }
        return authorities;
    }
}
