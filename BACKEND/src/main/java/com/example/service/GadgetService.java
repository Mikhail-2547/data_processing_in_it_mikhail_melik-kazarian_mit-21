package com.example.service;

import com.example.model.Gadgets;
import com.example.utils.FileUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GadgetService {
    private static final String FILE_PATH = "src/main/resources/data.json";
    private List<Gadgets> gadgets;

    public GadgetService() {
        gadgets = loadGadgets();
    }

    public List<Gadgets> getAllGadgets() {
        return gadgets;
    }

    public void addGadget(Gadgets gadget) {
        // Find the maximum existing ID
        int maxId = 0;
        for (Gadgets g : gadgets) {
            if (g.getId() > maxId) {
                maxId = g.getId();
            }
        }
        // Assign a new unique ID
        gadget.setId(maxId + 1);
        gadgets.add(gadget);
        saveGadgets();
    }

    public boolean updateGadget(Gadgets updatedGadget) {
        for (int i = 0; i < gadgets.size(); i++) {
            if (gadgets.get(i).getId() == updatedGadget.getId()) {
                gadgets.set(i, updatedGadget);
                saveGadgets();
                return true;
            }
        }
        return false;
    }

    public boolean deleteGadget(int id) {
        boolean removed = gadgets.removeIf(g -> g.getId() == id);
        if (removed) saveGadgets();
        return removed;
    }

    private List<Gadgets> loadGadgets() {
        try {
            String json = FileUtil.readFromFile(FILE_PATH);
            return new Gson().fromJson(json, new TypeToken<List<Gadgets>>() {}.getType());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void saveGadgets() {
        try {
            String json = new Gson().toJson(gadgets);
            FileUtil.writeToFile(FILE_PATH, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}