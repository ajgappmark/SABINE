package bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Bot {

    private long id;

    private Map<Class, Object> info;

    public Bot() {
        id = -1; /* Means that the object is not persistent yet */
        info = new HashMap<Class, Object>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public <T>T getInfo(Class<T> clazz) {
        return (T) info.get(clazz);
    }

    public <T>void setInfo(Class<T> clazz, T object) {
        info.put(clazz, object);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bot bot = (Bot) o;
        return id == bot.id;
    }

}
