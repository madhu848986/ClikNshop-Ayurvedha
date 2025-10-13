package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public class UserDaoImp implements UserDao  {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {
        String sql = "INSERT INTO users (name, email, city, latitude, longitude) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                user.getName(), user.getEmail(),
                user.getCity(), user.getLatitude(), user.getLongitude());
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User u = new User();
            u.setId(rs.getLong("id"));
            u.setName(rs.getString("name"));
            u.setEmail(rs.getString("email"));
            u.setCity(rs.getString("city"));
            u.setLatitude(rs.getDouble("latitude"));
            u.setLongitude(rs.getDouble("longitude"));
            return u;
        });
}
}
