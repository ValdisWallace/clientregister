package ru.novolotsky.clientregister.service;

import org.springframework.stereotype.Service;
import ru.novolotsky.clientregister.model.Client;
import ru.novolotsky.clientregister.to.Request;
import ru.novolotsky.clientregister.to.Response;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class ClientService {
    private ConcurrentHashMap<String, Client> clients = new ConcurrentHashMap<>();

    {
        clients.put("login", new Client("login", "asd123", 123.56));
        clients.put("admin", new Client("admin", "admin", 256));
    }

    public Response getBalance(Request request) {
        Client client = clients.get(request.getLogin());
        if (client == null) {
            return new Response(3);
        } else if (client.getPassword().equals(request.getPassword())) {
            return new Response(0, client);
        } else {
            return new Response(4);
        }
    }

    public Response create(Request request) {
        if (clients.containsKey(request.getLogin())) {
            return new Response(1);
        } else {
            clients.put(request.getLogin(), new Client(request.getLogin(), request.getPassword(), 0));
            return new Response(0);
        }
    }
}
