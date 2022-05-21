package Database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User("Vester", "Carmen", "bsp@gmx.de",
                "123", "456", 862437600, 1, 5000);
    }

    @Test
    void testToString() {
        String toString = user.toString();
        String expected = "User{id=0, name=Vester, first name=Carmen, " +
                "email=bsp@gmx.de, birthday=862437600, student=1, money=5000.0}";
        assertEquals(expected, toString);
    }

    @Test
    void getId() {
        long id = user.getId();
        assertEquals(0, id);
    }

    @Test
    void getTxt_name() {
        String name = user.getTxt_name();
        assertEquals("Vester", name);
    }

    @Test
    void getTxt_first_name() {
        String firstname = user.getTxt_first_name();
        assertEquals("Carmen", firstname);
    }

    @Test
    void getTxt_email() {
        String email = user.getTxt_email();
        assertEquals("bsp@gmx.de", email);
    }

    @Test
    void getTxt_password_hash() {
        String pw_hash = user.getTxt_password_hash();
        assertEquals("123", pw_hash);
    }

    @Test
    void getTxt_password_salt() {
        String pw_salt = user.getTxt_password_salt();
        assertEquals("456", pw_salt);
    }

    @Test
    void getDat_unix_birthday() {
        int birthday = user.getDat_unix_birthday();
        assertEquals(862437600, birthday);
    }

    @Test
    void getBool_student() {
        int studentTest = user.getBool_student();
        assertEquals(1, studentTest);
    }

    @Test
    void getFloat_money_amount() {
        float money = user.getFloat_money_amount();
        assertEquals(5000, money);
    }

    @Test
    void setTxt_name() {
        user.setTxt_name("Lang");
        assertEquals("Lang", user.getTxt_name());
    }

    @Test
    void setTxt_first_name() {
        user.setTxt_first_name("Jonas");
        assertEquals("Jonas", user.getTxt_first_name());
    }

    @Test
    void setTxt_email() {
        user.setTxt_email("JL@hotmail.com");
        assertEquals("JL@hotmail.com", user.getTxt_email());
    }

    @Test
    void setTxt_password_hash() {
        user.setTxt_password_hash("321");
        assertEquals("321", user.getTxt_password_hash());
    }

    @Test
    void setTxt_password_salt() {
        user.setTxt_password_salt("654");
        assertEquals("654", user.getTxt_password_salt());
    }

    @Test
    void setDat_unix_birthday() {
        user.setDat_unix_birthday(989186400);
        assertEquals(989186400, user.getDat_unix_birthday());
    }

    @Test
    void setBool_student() {
        user.setBool_student(0);
        assertEquals(0, user.getBool_student());
    }

    @Test
    void setFloat_money_amount() {
        user.setFloat_money_amount(10000);
        assertEquals(10000, user.getFloat_money_amount());
    }
}