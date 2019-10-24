package ru.novolotsky.clientregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.novolotsky.clientregister.service.ClientService;
import ru.novolotsky.clientregister.to.Request;
import ru.novolotsky.clientregister.to.Response;

@RestController
@RequestMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response getRequest(@RequestBody Request request) {
        switch (request.getType()) {
            case GET_BALANCE:
                return clientService.getBalance(request);
            case CREATE:
                return clientService.create(request);
            default:
                return new Response(2);
        }
    }
}
