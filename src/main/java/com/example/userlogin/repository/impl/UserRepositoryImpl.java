package com.example.userlogin.repository.impl;

import com.example.demo._2a.tables.Users;
import com.example.demo._2a.tables.records.UsersRecord;
import com.example.userlogin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.demo._2a.tables.Users.USERS;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final DSLContext dslContext;

    @Override
    public UsersRecord findByEmail(String email) {
        return dslContext.selectFrom(USERS)
                .where(USERS.EMAIL.eq(email))
                .fetchInto(UsersRecord.class)
                .stream().findFirst().orElseThrow();
    }

    @Override
    public UsersRecord findById(Long id) {
        return dslContext.selectFrom(USERS)
                .where(USERS.ID.eq(id))
                .fetchInto(UsersRecord.class)
                .stream().findFirst().orElseThrow();
    }
}
