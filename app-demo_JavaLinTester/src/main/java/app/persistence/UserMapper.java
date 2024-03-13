package app.persistence;

import app.entities.User;
import app.exceptions.DatabaseException;
import io.javalin.http.Context;


import java.sql.*;

public class UserMapper {

    public static User login(Context ctx) {
        User user;
        //forbindelse til databasen
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        String sql = "SELECT * FROM Users WHERE username =? AND password = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, ctx.formParam("username"));
                ps.setString(1, ctx.formParam("username"));
                ResultSet rs = ps.executeQuery();

                if (rs.next()){
                    int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");

                    user = new User(id, username, password, role);
                } else {
                    throw new DatabaseException
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

}
