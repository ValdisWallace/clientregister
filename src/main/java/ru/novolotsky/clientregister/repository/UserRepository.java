package ru.novolotsky.clientregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.novolotsky.clientregister.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    @Transactional
    User save(User user);

    @Query("SELECT c FROM User c WHERE c.login=:login")
    User getByLogin(@Param("login") String login);
}
