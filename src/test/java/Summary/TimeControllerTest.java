package Summary;

import Database.MockDatabase;
import Database.Transaction;
import Database.TransactionTypes;
import Database.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TimeControllerTest {
    MockDatabase database = MockDatabase.getDatabase();
    TimeController controller = TimeController.getTimeController();

    //für die User
    User user1;
    User user2;
    UUID userId1;
    UUID userId2;

    // für die Transactions
    Transaction transactionPlusMonatlich1;
    Transaction transactionPlusMonatlich2;
    Transaction transactionPlusEinmalig;
    Transaction transactionMinusMonatlich;
    Transaction transactionMinusEinmalig;

    Transaction transactionEmpty;
    UUID trxIdPlusMonatlich1;
    UUID trxIdPlusMonatlich2;
    UUID trxTypeIdPlusMonatlich;
    UUID trxTypeIdMinusMonatlich;
    UUID trxTypeIdMinusEinmalig;
    UUID  trxTypeIdPlusEinmalig;
    List<Transaction> trxList;
    List<TransactionTypes> ttList;

    //für die Transaction Types
    TransactionTypes ttPlusMonatlich;
    TransactionTypes ttMinusMonatlich;
    TransactionTypes ttMinusEinmalig;
    TransactionTypes ttPlusEinmalig;

    @BeforeEach
    void setUp() {
        database.cleanDatabase();
        database = MockDatabase.getDatabase();

        userId1 = UUID.randomUUID();
        user1 = new User("Vester", "Carmen", "bsp@gmx.de",
                "123", "456", 862437600, 1, 10, userId1);
        userId2 = UUID.randomUUID();
        user2 = new User("Luis", "Martin-Schick", "bsp@gmx.de",
                "421", "653", 890437600, 1, 1000, userId2);

        //Transaction Types
        trxTypeIdPlusMonatlich = UUID.randomUUID();
        trxTypeIdPlusEinmalig = UUID.randomUUID();
        trxIdPlusMonatlich1 = UUID.randomUUID();
        trxTypeIdMinusMonatlich = UUID.randomUUID();
        trxTypeIdMinusEinmalig = UUID.randomUUID();

        ttPlusMonatlich =  new TransactionTypes(trxTypeIdPlusMonatlich, "TestPlusM", 1, userId1, new Monatliche_Zahlung());
        transactionPlusMonatlich1 = new Transaction(trxIdPlusMonatlich1, userId1,10,trxTypeIdPlusMonatlich);
        transactionPlusMonatlich2 = new Transaction(trxIdPlusMonatlich1, userId1,7,trxTypeIdPlusMonatlich);

        ttPlusEinmalig = new TransactionTypes( trxTypeIdPlusEinmalig, "TestPlusE",1,userId1, new Einmalige_Zahlung());
        transactionPlusEinmalig = new Transaction(UUID.randomUUID(), userId1, 3, trxTypeIdPlusEinmalig);

                ttMinusMonatlich =  new TransactionTypes(trxTypeIdMinusMonatlich, "TestMinusM", 0, userId1, new Monatliche_Zahlung());
        transactionMinusMonatlich = new Transaction(  UUID.randomUUID(), userId1,7, trxTypeIdMinusMonatlich );
        ttMinusEinmalig =  new TransactionTypes(trxTypeIdMinusEinmalig, "TestMinusE", 0, userId1, new Einmalige_Zahlung());
        transactionMinusEinmalig = new Transaction(UUID.randomUUID(), userId1, 3,trxTypeIdMinusEinmalig);
    }

    @Test
    void getTimeController() {
        assertEquals(controller, TimeController.getTimeController());
    }

    @Test
    void advanceTimePlus() {
     database.saveUser(user1);
     database.saveTransactionType(ttPlusMonatlich);
     database.saveTransactionType(ttPlusEinmalig);
     database.saveTransaction(transactionPlusMonatlich1);
     database.saveTransaction(transactionPlusMonatlich2);
     database.saveTransaction( transactionPlusEinmalig);

        assertEquals(10, user1.getFloat_money_amount());
        controller.advanceTime();
        assertEquals(30,user1.getFloat_money_amount());
        controller.advanceTime();
        assertEquals(47,user1.getFloat_money_amount());
    }

    @Test
    void advanceTimeMinus() {
        database.saveUser(user1);
        database.saveTransactionType(ttMinusMonatlich);
        database.saveTransactionType(ttMinusEinmalig);
        database.saveTransaction(transactionMinusMonatlich);
        database.saveTransaction( transactionMinusEinmalig);

        assertEquals(10, user1.getFloat_money_amount());
        controller.advanceTime();
        assertEquals(0,user1.getFloat_money_amount());
        controller.advanceTime();
        assertEquals(-7,user1.getFloat_money_amount());
    }
}