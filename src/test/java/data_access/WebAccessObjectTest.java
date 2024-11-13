package data_access;

import data_access.WebAccessObject;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class WebAccessObjectTest {

    @Test
    void notExistTest() {
        WebAccessObject wao = new WebAccessObject();
        assertTrue(wao.subjectExists("University_of_Toronto"));
    }
}
