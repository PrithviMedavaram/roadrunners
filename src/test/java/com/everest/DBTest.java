package com.everest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.junit.jupiter.api.Test;


@SpringBootTest
public class DBTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testConnection() {
        try {
            String result = jdbcTemplate.queryForObject("SELECT 'DB OK' as status", String.class);
            System.out.println(result);
        } catch (Exception e){
            System.out.println("DB NOT OK");
            e.printStackTrace();
        }
    }
}
