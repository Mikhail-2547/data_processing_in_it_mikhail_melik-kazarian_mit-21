package com.example.servlet;

import com.example.model.Gadgets;
import com.example.service.GadgetService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/gadgets")
public class GadgetServlet extends HttpServlet {
    private GadgetService gadgetService = new GadgetService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Gadgets> gadgets = gadgetService.getAllGadgets();
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(gadgets));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        // Parse JSON and remove the id field
        JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        jsonObject.remove("id");
        // Deserialize without id (id will default to 0)
        Gadgets newGadget = gson.fromJson(jsonObject, Gadgets.class);
        gadgetService.addGadget(newGadget);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        Gadgets updatedGadget = gson.fromJson(reader, Gadgets.class);
        if (gadgetService.updateGadget(updatedGadget)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if (gadgetService.deleteGadget(id)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}