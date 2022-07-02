package Summary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class Monatliche_ZahlungTest {

    UUID id;
    Monatliche_Zahlung zahlung;

    @BeforeEach
    void setUp() {
        id = UUID.randomUUID();
        zahlung = new Monatliche_Zahlung(id);
    }
    @Test
    void getId() {
        assertEquals(id,zahlung.getId());
    }

    @Test
    void setId() {
        UUID newId = UUID.randomUUID();
        zahlung.setId(newId);
        assertEquals(newId,zahlung.getId());
    }

    @Test
    void calculateAddedValue() {
        assertEquals(50, zahlung.calculateAddedValue(50));
        //kann beliebig oft durchgeführt werden
        assertEquals(50, zahlung.calculateAddedValue(50));
    }

    @Test
    void fetchTransactionType() {
        assertEquals("MonthlyPayment", zahlung.fetchTransactionType());
    }
}