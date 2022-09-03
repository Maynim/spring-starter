package ru.maynim.spring.database.repository;

import ru.maynim.spring.database.entity.Role;
import ru.maynim.spring.database.entity.User;
import ru.maynim.spring.dto.PersonalInfo;
import ru.maynim.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);

    void updateCompanyAndRole(List<User> users);

    void updateCompanyAndRoleNamed(List<User> users);
}
