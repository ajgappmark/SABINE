package handler;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import static org.junit.Assert.*;

public class utilTest {
    private String a = "id=jeej&ip=localhost";

    @Test
    public void getPOSTFromString() {
        HashMap<String, String> post = util.getPOSTFromString(a);
        assertEquals("{ip=localhost, id=jeej}", post.toString());
    }

    @Test
    public void getFormattedDate() {
        Date d = new GregorianCalendar(1997, 10, 11, 9, 25).getTime();
        String response = util.getFormattedDate(d);
        assertEquals("1997-11-11 09:25:00", response);
    }
}