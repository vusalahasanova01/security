package com.example.userlogin.repository;

import com.example.demo._2a.tables.records.UsersRecord;


public interface UserRepository {

    UsersRecord findByEmail(String email);

    UsersRecord findById(Long id);
}
