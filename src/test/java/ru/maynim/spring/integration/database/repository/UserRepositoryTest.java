package ru.maynim.spring.integration.database.repository;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import ru.maynim.spring.database.entity.Role;
import ru.maynim.spring.database.entity.User;
import ru.maynim.spring.database.repository.UserRepository;
import ru.maynim.spring.integration.annotation.IT;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void checkQueries() {
        List<User> users = userRepository.findAllBy("a", "ov");
    }

    @Test
    void checkUpdate() {
        int resultCount = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, resultCount);
    }
}
