package handler;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class utilTest {
    private String a = "id=jeej&ip=localhost";

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getPOSTFromString() {
        HashMap<String, String> post = util.getPOSTFromString(a);
        assertEquals("{ip=localhost, id=jeej}", post.toString());
    }
}