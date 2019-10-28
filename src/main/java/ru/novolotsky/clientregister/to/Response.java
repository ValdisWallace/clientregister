package ru.novolotsky.clientregister.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.Hibernate;
import ru.novolotsky.clientregister.model.User;

public class Response {
    private Integer result;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User extras;

    public Response() {
    }

    public Response(int result) {
        this.result = result;
    }

    public Response(int result, User extras) {
        this.result = result;
        this.extras = extras;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public User getExtras() {
        return extras;
    }

    public void setExtras(User extras) {
        this.extras = extras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        Response that = (Response) o;

        if (that.extras != null && extras != null) {
            return result != null && result.equals(that.result) && extras.getBalance().equals(that.extras.getBalance());
        }
        return result != null && result.equals(that.result);
    }

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                ", extras=" + extras +
                '}';
    }
}
