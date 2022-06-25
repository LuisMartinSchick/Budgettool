package Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    Transaction transaction;
    Transaction transactionEmpty;
    UUID trxId;
    UUID userId;


    @BeforeEach
    void setUp() {
        trxId = UUID.randomUUID();
        userId = UUID.randomUUID();
        transaction = new Transaction(trxId, userId, 500, 1);
        transactionEmpty = new Transaction();
    }

    @Test
    void testToString() {
        String toString = transaction.toString();
        String expected = "Transaction{id=" + trxId.toString() + ", user-id=" + userId.toString() + ", money=500.0, type=1}";
        assertEquals(expected, toString);
        Exception exception = assertThrows(NullPointerException.class, () -> {
            String emptyString = transactionEmpty.toString();
        });

        String nullstring = "Cannot invoke \"java.util.UUID.toString()\" because \"this.id\" is null";
        assertEquals(nullstring, exception.getMessage());

    }

    @Test
    void getId() {
        UUID expected = transaction.getId();
        assertEquals(expected, trxId);
    }

    @Test
    void getInt_user_id_fk() {
        UUID expected = transaction.getUuidUserIdFk();
        assertEquals(expected, userId);
    }

    @Test
    void getFloat_value() {
        float expected = transaction.getFloatValue();
        assertEquals(500.0, expected);
    }

    @Test
    void getInt_try_type_fkype() {
        int expected = transaction.getIntTrxTypeFk();
        assertEquals(1, expected);
    }

    @Test
    void setFloat_value() {
        transaction.setFloatValue(5000.0f);
        assertEquals(5000.0f, transaction.getFloatValue());
    }

    @Test
    void setInt_try_type_fkype() {
        transaction.setIntTrxTypeFk(2);
        assertEquals(2, transaction.getIntTrxTypeFk());
    }
}