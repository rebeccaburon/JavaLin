package app;

import app.config.ThymeleafConfig;
import app.persistence.ConnectionPool;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinThymeleaf;


public class Main {
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:postgresql://localhost:5432/%s?currentSchema=public";
    private static final String DB = "Second Hand Shop";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance(USER, PASSWORD, URL, DB);

    public static void main(String[] args) {

        {
            // Initializing Javalin and Jetty webserver

            Javalin app = Javalin.create(config -> {
                config.staticFiles.add("/public");
                config.fileRenderer(new JavalinThymeleaf(ThymeleafConfig.templateEngine()));
            }).start(7070);

            // Routing - navigere rundt mellem forskellige sider.
            //HTTP get request
            //Der stod først render

            app.get("/", ctx ->  ctx.redirect("index.html"));
            app.get("index.html", ctx ->  ctx.render("index.html"));

            app.post("index.html", ctx ->  ctx.redirect("welcome.html"));
            app.get("welcome.html", ctx ->  ctx.render("welcome.html"));
            // ctx er lambada exprection.
        }


    }
}