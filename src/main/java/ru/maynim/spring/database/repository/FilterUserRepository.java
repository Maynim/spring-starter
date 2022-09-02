package ru.maynim.spring.database.repository;

import ru.maynim.spring.database.entity.User;
import ru.maynim.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);
}
