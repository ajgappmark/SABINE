package dao;

import bean.Bot;

import java.util.Set;

public interface BotDAO {

    Set<Bot> getAllBots();

    void updateBots(Set<Bot> bots);
}
