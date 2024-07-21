package ru.kata.spring.boot_security.demo.dao;

import com.springboot.PP2_3_1_Boot.model.User;

import java.util.List;

/**
 * Data Access Object описывающий общие методы, которые будут использоваться при взаимодействии с базой данных
 */
public interface UserDao {
    void add(User user);
    void delete(User user);
    void update(User user);
    List<User> listUsers();
    User findById(long id);
}

