package ru.novolotsky.clientregister.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import static ru.novolotsky.clientregister.TestData.*;

@SpringBootTest
@Sql(scripts = "classpath:populateHSQLDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    void create() {
        assertMatch(service.create(CREATE_REQUEST), RESULT_0);
    }

    @Test
    void createDuplicate() {
        service.create(CREATE_REQUEST);
        assertMatch(service.create(CREATE_REQUEST), RESULT_1);
    }

    @Test
    void getBalance() {
        service.create(CREATE_REQUEST);
        assertMatchWithExtras(service.getBalance(GET_BALANCE), RESULT_0);
    }

    @Test
    void userNotFound() {
        assertMatch(service.getBalance(GET_NOT_EXIST), RESULT_3);
    }

    @Test
    void passwordNotValid() {
        service.create(CREATE_REQUEST);
        assertMatch(service.getBalance(GET_PASS_NOT_VALID), RESULT_4);
    }
}