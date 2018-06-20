package dao.impl;

import bean.Bot;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.BotDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "BotDAO")
public class BotDAOImpl implements BotDAO {

    private Gson gson;

    public BotDAOImpl() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public List<Bot> getAllBots() {
        return null;
    }

    public void updateBots(List<Bot> bots) {

    }

}
