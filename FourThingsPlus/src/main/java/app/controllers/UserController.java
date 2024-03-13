package app.controllers;

import app.entities.User;
import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.persistence.UserMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class UserController {

    public static void addRoutes (Javalin app,ConnectionPool connectionPool){
        app.post("login", ctx -> login(ctx, connectionPool));

    }

        //Lav en metoder der skal kører når vi rammer login
    //Da vi ikke skal instianziere der, er metoden statisk
    public static void login (Context ctx, ConnectionPool connectionPool){
        // Hent form parameter
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");
        // Check om bruger findes i DB med de angivende username+password
        try {
            User user = UserMapper.login(username, password, connectionPool);

            // Hvis ja, send videre til task siden
            ctx.render("task.html");

        } catch (DatabaseException e) {
            //hvis nej, send tilbage til login side med fejl besked.
            ctx.attribute("message", e.getMessage());
            // request scope = attribute (key, object value) - message er henvender til html sidens th:text="${#messages}"
            ctx.render("index.html");
        }


    }
}

