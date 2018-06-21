package bean;

import java.util.HashMap;
import java.util.Map;

public class Bot {

    private long id;

    private Map<Class, Object> info;

    public Bot() {
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
}
