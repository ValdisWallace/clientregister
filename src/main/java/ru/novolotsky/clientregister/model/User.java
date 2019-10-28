package ru.novolotsky.clientregister.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.Hibernate;
import ru.novolotsky.clientregister.json.MoneySerializer;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@JsonIgnoreProperties({"id", "login", "password"})
@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = 100000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    Integer id;

    @Column(name = "login", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String login;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "balance", nullable = false)
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal balance;

    public User() {
    }

    public User(Integer id, String login, String password, BigDecimal balance) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.balance = balance;
    }

    public User(String login, String password, double balance) {
        this.login = login;
        this.password = password;
        this.balance = new BigDecimal(balance);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
