package data_access;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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

    @Test
    void autocompleteTest() {
        WikipediaAccessObject wao = new WikipediaAccessObject();
        assertEquals("University of Toronto", wao.autocomplete("university of tornoto"));
    }

    @Test
    void searchTest() {
        WikipediaAccessObject wao = new WikipediaAccessObject();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("University of Toronto","University of Toronto Faculty of Law","University of Toronto Faculty of Applied Science and Engineering","University of Toronto Faculty of Information","University of Toronto Scarborough","University of Toronto Mississauga","University of Toronto Mississauga buildings","University of Toronto Faculty of Medicine","University of Toronto Faculty of Music","University of Toronto Schools"));
        ArrayList<String> actual = wao.getSearchResults("university of toronto");
        assertEquals(expected, actual);
    }

    @Test
    void linksTest() {
        // TODO fix this test
        WikipediaAccessObject wao = new WikipediaAccessObject();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Ancient_Egypt","Bishop_of_Exeter","Canterbury_Tales","Cat","Consumer_IR","Cyprus","Dog","Dog_run","Early_modern_period","Electromagnet","England","English_literature","Excretion","Exeter_Cathedral","Feral_cat","French_language","Geoffrey_Chaucer","ISBN_(identifier)","Integrated_circuit","Ireland","Isaac_Newton","Medway","Microchip_implant_(animal)","Oxford_English_Dictionary","Permanent_magnet","Pet","Polyvinyl_chloride","Radio-frequency_identification","Rincón_de_Ademuz","Sliding_glass_door","Spanish_language","Stile","United_Kingdom","Urban_legend","Valencia,_Spain","Vaunage","Wildcat","William_Cotton_(bishop)"));
        ArrayList<String> actual = wao.getPageLinks("Pet_door");
        assertEquals(expected, actual);
    }

// *************************************************************************************************************
// * helpers
// *************************************************************************************************************

    // just cause strings are weirdddddddd
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
