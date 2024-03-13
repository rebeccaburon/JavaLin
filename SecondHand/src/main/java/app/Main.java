package app;

import app.config.ThymeleafConfig;
import app.controllers.ItemController;
import app.controllers.UserController;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinThymeleaf;

import java.util.Map;

public class Main {


    public static void main(String[] args) {

        //Initializing Javalin med Jetty webServer
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/app");
            config.fileRenderer(new JavalinThymeleaf(ThymeleafConfig.templateEngine()));
        }).start(7070);

        //Routting



        app.get("/", ctx ->  ctx.render("index.html"));

        app.post("/login", ctx ->
        {
            UserController.login(ctx);
        });


        app.get("/item", ctx ->
        {
            var items = ItemController.loadItems(ctx);
            ctx.render("/item.html", Map.of("items", items));
        });

    }
}