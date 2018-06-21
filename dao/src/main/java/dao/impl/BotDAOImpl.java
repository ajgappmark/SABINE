package dao.impl;

import bean.Bot;
import dao.BotDAO;


import java.util.Set;

public class BotDAOImpl implements BotDAO {

    public Set<Bot> getAllBots() {
        return JsonBot.getInstance().getAllBots();
    }

    public void updateBots(Set<Bot> bots) {
        JsonBot.getInstance().updateBots(bots);
    }

}
