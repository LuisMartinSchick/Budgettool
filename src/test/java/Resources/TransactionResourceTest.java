package Resources;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TransactionResourceTest {

    TransactionResource transaction;
    UUID id;

    @BeforeEach
    void setUp() {
        id = UUID.randomUUID();
       transaction = new TransactionResource(id, id, 5000, id);
    }

    @Test
    void getId() {
        UUID expected = transaction.getId();
        assertEquals(id, expected);
    }

    @Test
    void getUserId() {
        UUID expected = transaction.getUserId();
        assertEquals(id, expected);
    }

    @Test
    void getFloatValue() {
        float expected = transaction.getFloatValue();
        assertEquals(5000, expected);
    }

    @Test
    void getTrxTypeId() {
        UUID expected = transaction.getTrxTypeId();
        assertEquals(id, expected);
    }

    @Test
    void testToString() {
        String expected = transaction.toString();
        String test = "TransactionResource(id="+id.toString()+", userId="+id.toString()+", floatValue=5000.0, trxTypeId="+id.toString()+")";
        assertEquals(test, expected);
    }
}