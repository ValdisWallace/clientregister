package ru.novolotsky.clientregister.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Request {

    private Type type;

    @NotBlank
    @Size(min = 5, max = 100)
    private String login;

    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    public Request() {
    }

    public Request(Type type, @NotBlank @Size(min = 5, max = 100) String login, @NotBlank @Size(min = 5, max = 100) String password) {
        this.type = type;
        this.login = login;
        this.password = password;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
