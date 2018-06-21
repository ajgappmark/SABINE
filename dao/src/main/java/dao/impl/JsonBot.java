package dao.impl;

import bean.Bot;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

class JsonBot {

    private final String FILE_NAME = "botinfo.json";

    private Gson gson;

    private long nextId;

    private Set<Bot> persistentBots;


    private static JsonBot singleton;

    private JsonBot() {
        long max;

        max = 0;
        gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Reader reader = new FileReader(FILE_NAME);

            persistentBots = gson.fromJson(reader,  new TypeToken<HashSet<Bot>>(){}.getType());

            for (Bot bot : persistentBots)
                max = bot.getId() > max ? bot.getId() : max;
            nextId = max;

            reader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    static JsonBot getInstance() {
        if (singleton != null)
            return singleton;
        singleton = new JsonBot();
        return singleton;
    }

    Set<Bot> getAllBots() {
        return persistentBots;
    }

    void updateBots(Set<Bot> bots) {
        System.out.println(bots);
        for (Bot bot : bots) {
            if (bot.getId() == -1) {
                bot.setId(nextId++);
            }
        }
        persistentBots.addAll(bots);
        System.out.println(persistentBots);
        flush();

    }

    private void flush() {
        try {
            Writer writer = new FileWriter(FILE_NAME);
            gson.toJson(persistentBots, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
