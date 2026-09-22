package controllers;

import io.javalin.http.Context;
import models.User;
import services.UserService;


public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void getAll(Context ctx) {
        ctx.json(userService.getAllUsers());
    }

    public void getOne(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        User user = userService.getUserById(id);

        if (user != null) {
            ctx.json(user);
        } else {
            ctx.status(404).result("User not found");
        }
    }

    /*
    public void create(Context ctx) {
        User user = ctx.bodyAsClass(User.class);
        userService.createUser(user);
        ctx.status(201).result("User created successfully");
    }
     **/
}