package Resources;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserResourceTest {

    UserResource user;

    @BeforeEach
    void setUp() {
        user = new UserResource("Vester", "Carmen",
                "bsp@gmx.de","123",
                "456", 862437600,
                1, 5000);
    }

    @Test
    void getTxt_name() {
        String name = user.getTxt_name();
        String expected = "Vester";
        assertEquals(expected, name);
    }

    @Test
    void getTxt_first_name() {
        String first_name = user.getTxt_first_name();
        String expected = "Carmen";
        assertEquals(expected, first_name);
    }

    @Test
    void getTxt_email() {
        String email = user.getTxt_email();
        String expected = "bsp@gmx.de";
        assertEquals(expected, email);
    }

    @Test
    void getTxt_password_hash() {
        String pwhash = user.getTxt_password_hash();
        String expected = "123";
        assertEquals(expected, pwhash);
    }

    @Test
    void getTxt_password_salt() {
        String pwsalt = user.getTxt_password_salt();
        String expected = "456";
        assertEquals(expected, pwsalt);
    }

    @Test
    void getDat_unix_birthday() {
        int birthday = user.getDat_unix_birthday();
        assertEquals(862437600, birthday);
    }

    @Test
    void getBool_student() {
        int student = user.getBool_student();
        assertEquals(1, student);
    }

    @Test
    void getFloat_money_amount() {
        float money = user.getFloat_money_amount();
        assertEquals(5000.0, money);
    }

    @Test
    void testToString() {
        String toString = user.toString();
        String expected = "UserResource(txt_name=Vester, txt_first_name=Carmen, txt_email=bsp@gmx.de, txt_password_hash=123, txt_password_salt=456, dat_unix_birthday=862437600, bool_student=1, float_money_amount=5000.0)";
        assertEquals(expected, toString);
    }
}