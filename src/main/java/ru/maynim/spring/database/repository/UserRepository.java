package ru.maynim.spring.database.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.maynim.spring.database.entity.Role;
import ru.maynim.spring.database.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(
            "select u from User u where u.firstname like %:firstname% and u.lastname like"
                    + " %:lastname%")
    List<User> findAllBy(String firstname, String lastname);

    @Query(value = "SELECT u.* FROM users u WHERE u.username = :username", nativeQuery = true)
    List<User> findAllByUsername(String username);

    @Modifying(clearAutomatically = true)
    @Query("update User u " +
            "set u.role = :role " +
            "where u.id in (:ids)")
    int updateRole(Role role, Long... ids);

    Optional<User> findFirstByOrderByIdDesc();

    List<User> findTop3ByBirthDateBefore(LocalDate birthdate, Sort sort);

    List<User> findAllBy(Pageable pageable);
}
