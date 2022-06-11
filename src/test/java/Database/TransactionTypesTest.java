package Database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTypesTest {

    TransactionTypes tt;
    User u1;
    UUID uuidTt;
    UUID uuidUser;


    @BeforeEach
    void setUp() {
        u1 = new User("Test", 100);
        uuidTt = UUID.randomUUID();
        uuidUser = UUID.randomUUID();
        tt = new TransactionTypes(uuidTt, "Test", 1, uuidUser);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        String ttToString = tt.toString();
        String expected = "TransactionType{UUID=" + uuidTt.toString()
                + ", trx-desc=Test, is-income=1, User-UUID=" + uuidUser.toString() + "}";
        assertEquals(expected, ttToString);
    }

    @Test
    void getId() {
        assertEquals(uuidTt, tt.getId());

    }

    @Test
    void getStr_trx_desc_EN() {
        assertEquals("Test", tt.getStr_trx_desc_EN());
    }

    @Test
    void getBool_income() {
        assertEquals(1, tt.getBool_income());
    }

    @Test
    void getInt_user_id_fk() {
        assertEquals(uuidUser, tt.getUuid_user_id_fk());
    }

    @Test
    void setStr_trx_desc_EN() {
        tt.setBool_income(0);
        assertEquals(0, tt.getBool_income());
    }

    @Test
    void setBool_income() {
        tt.setStr_trx_desc_EN("Test2");
        assertEquals("Test2", tt.getStr_trx_desc_EN());
    }

}