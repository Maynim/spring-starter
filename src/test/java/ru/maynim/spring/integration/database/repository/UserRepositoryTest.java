package ru.maynim.spring.integration.database.repository;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import ru.maynim.spring.database.entity.User;
import ru.maynim.spring.database.repository.UserRepository;
import ru.maynim.spring.integration.annotation.IT;

import java.util.List;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void checkQueries() {
        List<User> users = userRepository.findAllBy("a", "ov");
    }
}
