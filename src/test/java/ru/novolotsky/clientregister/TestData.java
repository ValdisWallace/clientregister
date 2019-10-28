package ru.novolotsky.clientregister;

import org.assertj.core.api.Assertions;
import ru.novolotsky.clientregister.model.User;
import ru.novolotsky.clientregister.to.Request;
import ru.novolotsky.clientregister.to.Response;
import ru.novolotsky.clientregister.to.Type;

import java.math.BigDecimal;

public class TestData {
    public static final User USER = new User(100000, "login123", "pass123", BigDecimal.valueOf(0));
    public static final Request CREATE_REQUEST = new Request(Type.CREATE, "login123", "pass123");
    public static final Request GET_BALANCE = new Request(Type.GET_BALANCE, "login123", "pass123");
    public static final Request GET_NOT_EXIST = new Request(Type.GET_BALANCE, "login12342", "pass123");
    public static final Request GET_PASS_NOT_VALID = new Request(Type.GET_BALANCE, "login123", "pass1234");
    public static final Request GET_TECH_ERROR = new Request(Type.GET_BALANCE, "login12342", "");
    public static final Response RESULT_0 = new Response(0);
    public static final Response RESULT_1 = new Response(1);
    public static final Response RESULT_2 = new Response(2);
    public static final Response RESULT_3 = new Response(3);
    public static final Response RESULT_4 = new Response(4);

    public static void assertMatch(Response expected, Response actual) {
        Assertions.assertThat(expected).isEqualToIgnoringGivenFields(actual);
    }

    public static void assertMatchWithExtras(Response expected, Response actual) {
        Assertions.assertThat(expected).isEqualTo(actual);
    }
}
