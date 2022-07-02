package Summary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;



class Einmalige_ZahlungTest {

    UUID id;
    Einmalige_Zahlung zahlung;
    @BeforeEach
    void setUp() {
        id = UUID.randomUUID();
       zahlung = new Einmalige_Zahlung(id);
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
        //kann nur einmal durchgeführt werden
        assertEquals(0, zahlung.calculateAddedValue(50));
    }


    @Test
    void fetchTransactionType() {
        assertEquals("SinglePayment", zahlung.fetchTransactionType());
    }
}