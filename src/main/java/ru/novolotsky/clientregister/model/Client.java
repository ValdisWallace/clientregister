package ru.novolotsky.clientregister.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ru.novolotsky.clientregister.json.MoneySerializer;

import java.math.BigDecimal;

@JsonIgnoreProperties({"login", "password"})
public class Client {
    private String login;
    private String password;

    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal balance;

    public Client() {
    }

    public Client(String login, String password, double balance) {
        this.login = login;
        this.password = password;
        this.balance = new BigDecimal(balance);
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = new BigDecimal(balance);
    }
}
