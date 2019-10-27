package ru.novolotsky.clientregister.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.novolotsky.clientregister.model.User;

public class Response {
    private int result;

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

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public User getExtras() {
        return extras;
    }

    public void setExtras(User extras) {
        this.extras = extras;
    }
}
