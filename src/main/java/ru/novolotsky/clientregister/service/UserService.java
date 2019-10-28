package ru.novolotsky.clientregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.novolotsky.clientregister.model.User;
import ru.novolotsky.clientregister.repository.UserRepository;
import ru.novolotsky.clientregister.to.Request;
import ru.novolotsky.clientregister.to.Response;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Response getBalance(Request request) {
        User user = repository.getByLogin(request.getLogin());
        if (user == null) {
            return new Response(3);
        } else if (user.getPassword().equals(request.getPassword())) {
            return new Response(0, user);
        } else {
            return new Response(4);
        }
    }

    public Response create(Request request) {
        if (repository.getByLogin(request.getLogin()) == null) {
            repository.save(new User(request.getLogin(), request.getPassword(), 0));
            return new Response(0);
        } else {
            return new Response(1);
        }
    }
}
