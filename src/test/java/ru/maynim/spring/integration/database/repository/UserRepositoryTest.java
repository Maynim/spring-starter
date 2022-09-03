package ru.maynim.spring.integration.database.repository;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import ru.maynim.spring.database.entity.Role;
import ru.maynim.spring.database.entity.User;
import ru.maynim.spring.database.repository.UserRepository;
import ru.maynim.spring.dto.PersonalInfo2;
import ru.maynim.spring.dto.UserFilter;
import ru.maynim.spring.integration.annotation.IT;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    @Commit
    void checkAuditing() {
        User ivan = userRepository.findById(1L).get();
        ivan.setBirthDate(ivan.getBirthDate().plusYears(1L));
        userRepository.flush();
        System.out.println();
    }

    @Test
    void checkCustomImplementation() {
        UserFilter filter = new UserFilter(null, "ov", LocalDate.now());
        List<User> users = userRepository.findAllByFilter(filter);
        System.out.println();
    }

    @Test
    void checkProjections() {
        List<PersonalInfo2> users = userRepository.findAllByCompanyId(1);
        assertThat(users).hasSize(2);
        System.out.println();
    }

    @Test
    void checkPageable() {
        PageRequest pageable = PageRequest.of(0, 2, Sort.by("id"));
        Page<User> slice = userRepository.findAllBy(pageable);
        slice.forEach(user -> System.out.println(user.getCompany().getName()));

        while (slice.hasNext()) {
            slice = userRepository.findAllBy(slice.nextPageable());
            slice.forEach(user -> System.out.println(user.getCompany().getName()));
        }
    }

    @Test
    void checkSort() {
        Sort.TypedSort<User> sortBy = Sort.sort(User.class);
        Sort sort = sortBy.by(User::getFirstname)
                .and(sortBy.by(User::getLastname));
        List<User> allUsers = userRepository.findTop3ByBirthDateBefore(LocalDate.now(), sort);
        assertThat(allUsers).hasSize(3);
    }

    @Test
    void checkFirst() {
        List<User> allUsers = userRepository.findTop3ByBirthDateBefore(LocalDate.now(), Sort.by("id").descending());
        assertThat(allUsers).hasSize(3);
        Optional<User> firstUser = userRepository.findFirstByOrderByIdDesc();
        assertEquals(5L, firstUser.get().getId());
    }

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
