package ru.maynim.spring.database.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.maynim.spring.database.entity.Role;
import ru.maynim.spring.database.entity.User;
import ru.maynim.spring.database.querydsl.QPredicates;
import ru.maynim.spring.dto.PersonalInfo;
import ru.maynim.spring.dto.UserFilter;

import javax.persistence.EntityManager;
import java.util.List;

import static ru.maynim.spring.database.entity.QUser.user;

@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository {

    private final EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    private static final String FIND_BY_COMPANY_AND_ROLE =
        "SELECT firstname, lastname, birth_date " +
            "FROM users " +
            "WHERE company_id = ? " +
            "AND role = ?";

    @Override
    public List<User> findAllByFilter(UserFilter filter) {
        Predicate predicate = QPredicates.builder()
            .add(filter.firstname(), user.firstname::containsIgnoreCase)
            .add(filter.lastname(), user.lastname::containsIgnoreCase)
            .add(filter.birthDate(), user.birthDate::before)
            .build();

        return new JPAQuery<User>(entityManager)
            .select(user)
            .from(user)
            .where(predicate)
            .fetch();
    }

    @Override
    public List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role) {
        return jdbcTemplate.query(FIND_BY_COMPANY_AND_ROLE,
            (rs, rowNum) -> new PersonalInfo(
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getDate("birth_date").toLocalDate()
            ), companyId, role.name());
    }


}
