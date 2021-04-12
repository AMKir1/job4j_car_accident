package ru.job4j.accident.service;

import org.springframework.stereotype.Service;


@Service
public interface UserService {
    boolean existByName(String name);
}
