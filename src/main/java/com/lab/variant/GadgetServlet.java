package com.lab.variant;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import java.io.IOException;

@WebServlet("/gadgets")
public class GadgetServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Gadgets gadget = new Gadgets("Apple Watch SE",
                "https://m.media-amazon.com/images/I/81DL86TQ2gL._AC_SL1500_.jpg",
                "SmartWatch",
                "The Apple Watch SE (2nd Generation) packs all the essential features to keep you motivated, connected, and safe. Powered by watchOS 11, it offers enhanced intelligence, personalization, and connectivity. Stay in touch with calls, texts, music, and Siri, all while enjoying health and safety features like Fall Detection, Crash Detection, and heart rate notifications. Seamlessly compatible with Apple devices, it also unlocks your Mac, helps find lost devices, and supports Apple Pay. With 50m water resistance, stylish finishes, and customizable bands, it’s both functional and fashionable. Plus, it’s a great fitness companion with advanced workout metrics and Apple Fitness+ integration. The Apple Watch SE is even carbon neutral when paired with select bands, reflecting Apple’s commitment to sustainability.",
                "Apple");
        Gson gson = new Gson();
        String json = gson.toJson(gadget);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }
}
