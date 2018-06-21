package dao;

import bean.Bot;

import java.util.List;

public interface BotDAO {

    List<Bot> getAllBots();

    void updateBots(List<Bot> bots);
}
