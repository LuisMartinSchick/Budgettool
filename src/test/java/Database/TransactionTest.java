package Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    Transaction transaction;
    Transaction transactionEmpty;
    UUID trxId;
    UUID userId;
    UUID trxTypeId;
    UUID trxTypeIdAlternative;


    @BeforeEach
    void setUp() {
        trxId = UUID.randomUUID();
        userId = UUID.randomUUID();
        trxTypeId = UUID.randomUUID();
        trxTypeIdAlternative = UUID.randomUUID();
        transaction = new Transaction(trxId, userId, 500, trxTypeId);
        transactionEmpty = new Transaction();
    }

    @Test
    void testToString() {
        String toString = transaction.toString();
        String expected = "Transaction{id=" + trxId.toString() + ", user-id=" + userId.toString() +
                ", money=500.0, type=" + trxTypeId.toString() + "}";
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
    void getUuid_try_type_fkype() {
        UUID expected = transaction.getUuidTrxTypeFk();
        assertEquals(expected, trxTypeId);
    }

    @Test
    void setFloat_value() {
        transaction.setFloatValue(5000.0f);
        assertEquals(5000.0f, transaction.getFloatValue());
    }

    @Test
    void setInt_try_type_fkype() {
        transaction.setUuidTrxTypeFk(trxTypeIdAlternative);
        assertEquals(trxTypeIdAlternative, transaction.getUuidTrxTypeFk());
    }
}