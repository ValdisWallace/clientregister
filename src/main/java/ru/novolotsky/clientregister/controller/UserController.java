package ru.novolotsky.clientregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.novolotsky.clientregister.service.UserService;
import ru.novolotsky.clientregister.to.Request;
import ru.novolotsky.clientregister.to.Response;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/request", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response getResponse(@Valid @RequestBody Request request) {
        try {
            switch (request.getType()) {
                case GET_BALANCE:
                    return userService.getBalance(request);
                case CREATE:
                    return userService.create(request);
                default:
                    return new Response(2);
            }
        } catch (RuntimeException e) {
            return new Response(2);
        }
    }
}
