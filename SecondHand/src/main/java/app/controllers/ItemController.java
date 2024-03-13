package app.controllers;

import app.entities.Items;
import app.exceptions.DatabaseException;
import app.persistence.ItemMapper;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.List;

public class ItemController {

    public static List<Items> loadItems(Context ctx) {
        List<Items> loadlist = new ArrayList<>();

        try {
           loadlist = ItemMapper.getAllItems(ctx);
        } catch (DatabaseException e) {
            ctx.attribute("message", e.getMessage());
        }
        return loadlist;

    }
}
