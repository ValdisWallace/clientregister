package ru.novolotsky.clientregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.novolotsky.clientregister.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT c FROM User c")
    List<User> getAll();

    @Query("SELECT c FROM User c WHERE c.login=:login")
    User getByLogin(@Param("login") String login);
}
