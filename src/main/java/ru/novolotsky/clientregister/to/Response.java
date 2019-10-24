package ru.novolotsky.clientregister.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.novolotsky.clientregister.model.Client;

public class Response {
    private int result;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Client extras;

    public Response() {
    }

    public Response(int result) {
        this.result = result;
    }

    public Response(int result, Client extras) {
        this.result = result;
        this.extras = extras;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Client getExtras() {
        return extras;
    }

    public void setExtras(Client extras) {
        this.extras = extras;
    }
}
