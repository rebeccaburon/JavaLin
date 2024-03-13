package app.persistence;

import app.entities.Items;
import app.exceptions.DatabaseException;
import io.javalin.http.Context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemMapper {

    public static List<Items> getAllItems (Context ctx) throws DatabaseException {

        List<Items> itemsList = new ArrayList<>();

        ConnectionPool connectionPool = ConnectionPool.getInstance();

        String sql ="SELECT \"itemId\", brand, titel, body, prices FROM public.\"Items\"";

        try(Connection connection = connectionPool.getConnection()){

            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int itemId = rs.getInt("itemId");
                    String brand = rs.getString("brand");
                    String titel = rs.getString("titel");
                    String body = rs.getString("body");
                    int prices = rs.getInt("prices");

                    itemsList.add(new Items(itemId,brand,titel,body,prices));
                }
            }   catch (SQLException throwables){
                throwables.printStackTrace();
            }

        } catch ( SQLException e) {
            throw new RuntimeException();
        }


        return itemsList;

    }

}
