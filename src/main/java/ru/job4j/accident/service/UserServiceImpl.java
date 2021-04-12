package ru.job4j.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public boolean existByName(String name) {
        return this.jdbcTemplate.queryForList("SELECT * FROM users u WHERE u.username = ?", name).size() > 0;
    }
}
