package data_access;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WikiAccessObjectTest {

    @Test
    void existTest() {
        WikipediaAccessObject wao = new WikipediaAccessObject();
        assertTrue(wao.pageExists("University_of_Toronto"));
    }

    @Test
    void notExistTest() {
        WikipediaAccessObject wao = new WikipediaAccessObject();
        assertFalse(wao.pageExists("DLFKAKSL"));
    }

    @Test
    void getTitleTest() {
        WikipediaAccessObject wao = new WikipediaAccessObject();
        assertEquals("University of Toronto", wao.getTitle("University_of_Toronto"));
    }

    @Test
    void getHTMLTest() {
        WikipediaAccessObject wao = new WikipediaAccessObject();
        int expected = -644953292; // hashcode for the correct string
        int actual = escape(wao.getHTML("Buccaneer_Bay_(radio_play)")).hashCode();
        assertEquals(expected, actual);
    }

    private static String escape(String s){
        return s.replace("\\", "\\\\")
                .replace("\t", "\\t")
                .replace("\b", "\\b")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\f", "\\f")
                .replace("\'", "\\'")      // <== not necessary
                .replace("\"", "\\\"");
    }
}
