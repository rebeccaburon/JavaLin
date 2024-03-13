package app.persistence;

import app.exceptions.DatabaseException;
import io.javalin.http.Context;
import app.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    public static User login(Context ctx) throws DatabaseException {
        User user;

        ConnectionPool connectionPool = ConnectionPool.getInstance();

        String sql = "SELECT \"usersId\", username, password, role\n" +
                "\tFROM public.\"appUsers\" WHERE username = ? AND password = ?;";

        //Skaber forbindelse til databasen og dens table
        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, ctx.formParam("username"));
                ps.setString(2, ctx.formParam("password"));
                ResultSet rs = ps.executeQuery();

                if (rs.next()){
                    int id = rs.getInt("usersId");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");
                    user = new User(id, username, password, role);
                } else {
                    throw new DatabaseException ("Felj i input");
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}
