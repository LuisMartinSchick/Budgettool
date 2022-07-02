package Database;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MockDatabaseTest {
    MockDatabase database = MockDatabase.getDatabase();

    //für den User Test
    User user1;
    User user2;
    User userEmpty;
    User userMoney;
    UUID userId1;
    UUID userId2;
    List<User> userList;

    // für den Transaction Test
    Transaction transaction1;
    Transaction transaction2;
    Transaction transactionEmpty;
    UUID trxId1;
    UUID trxId2;
    UUID trxTypeId;
    UUID trxTypeIdAlternative;
    List<Transaction> trxList;
    List<TransactionTypes> ttList;

    TransactionTypes tt1;

    @BeforeEach
    void setUp() {
        //für den User test
        database.cleanDatabase();
        userList = new ArrayList<User>();
        database = MockDatabase.getDatabase();
        userId1 = UUID.randomUUID();
        user1 = new User("Vester", "Carmen", "bsp@gmx.de",
                "123", "456", 862437600, 1, 5000, userId1);
        userId2 = UUID.randomUUID();
        user2 = new User("Luis", "Martin-Schick", "bsp@gmx.de",
                "421", "653", 890437600, 1, 1000, userId2);
        userEmpty = new User();
        userMoney = new User("Test", 100);
        database.saveUser(user1);
        userList.add(user1);

        //für den transaction test
        trxList = new ArrayList<Transaction>();
        trxId1 = UUID.randomUUID();
        trxId2 = UUID.randomUUID();

        trxTypeId = UUID.randomUUID();
        trxTypeIdAlternative = UUID.randomUUID();
        transaction1 = new Transaction(trxId1, userId1, 500, trxTypeId);
        transaction2 = new Transaction(trxId2, userId1, 900, trxTypeId);
        transactionEmpty = new Transaction();

        //Transaction Types List
        ttList = new ArrayList<TransactionTypes>();
        tt1 = new TransactionTypes(trxTypeId, "Test", 1, userId1);
        ttList.add(tt1);
    }

    //Überprüfen, dass der Singleton funktioniert
    @Test
    void getDatabase() {
        assertEquals(database, MockDatabase.getDatabase());
    }

    @Test
    void saveUser() {
        assertEquals("Added user successfully", database.saveUser(user1));
    }

    @Test
    void findAllUsers() {
        assertEquals(userList, database.findAllUsers());
    }

    @Test
    void findUserById() {
        assertEquals(user1, database.findUserById(userId1));
    }

    @Test
    void deleteUserById() {
        assertEquals("User was deleted", database.deleteUserById(userId1));
        assertEquals("No User with that ID was found", database.deleteUserById(userId1));
    }

    @Test
    void saveTransaction() {
        assertEquals("Added transaction successfully", database.saveTransaction(transaction1));
        assertEquals("Added transaction successfully", database.saveTransaction(transaction2));
    }

    @Test
    void findAllTransactions() {
        assertEquals(trxList, database.findAllTransactions());
    }

    @Test
    void findTransactionById() {
        database.saveTransaction(transaction1);
        database.saveTransaction(transaction2);
        assertEquals(transaction2, database.findTransactionById(trxId2));
    }
    @Test
    void getTransactionTypeToTransaction(){
        database.saveTransactionType(tt1);
       database.saveTransaction(transaction1);
        assertEquals(tt1, database.getTransactionTypeToTransaction(transaction1));
    }

    @Test
    void deleteTransactionById() {
        database.saveTransaction(transaction1);
        assertEquals("Transaction was deleted", database.deleteTransactionById(trxId1));
        assertEquals("No Transaction with that ID was found", database.deleteTransactionById(trxId1));
    }

    @Test
    void saveTransactionType() {
        assertEquals("Added transaction type successfully", database.saveTransactionType(tt1));
    }

    @Test
    void findAllTransactionTypes() {
        database.saveTransactionType(tt1);
        assertEquals(ttList, database.findAllTransactionTypes());
    }

    @Test
    void findTransactionTypeById() {
        database.saveTransactionType(tt1);
        assertEquals(tt1, database.findTransactionTypeById(trxTypeId));
    }

    @Test
    void deleteTransactionTypeById() {
        database.saveTransactionType(tt1);
        assertEquals("Transaction Type was deleted", database.deleteTransactionTypeById(trxTypeId));
        assertEquals("No Transaction Type with that ID was found", database.deleteTransactionTypeById(trxTypeId));

    }

    @Test
    void changeStrategy() {
        database.saveTransactionType(tt1);
        assertEquals("Die Strategie wurde auf eine monatliche Zahlung gesetzt", database.changeStrategy(trxTypeId, "monatlich"));
        assertEquals("Eine solcheStrategy ist nicht bekannt", database.changeStrategy(trxTypeId, "Das sollte nicht funktionieren"));
        //feststellen, dass sie auch wirklich geändert wurde
        TransactionTypes transactionType = database.findTransactionTypeById(trxTypeId);
        assertEquals("MonthlyPayment", transactionType.getStrategy().fetchTransactionType());

        assertEquals("Die Strategie wurde auf eine einmalige Zahlung gesetzt", database.changeStrategy(trxTypeId, "einmalig"));
        assertEquals("SinglePayment", transactionType.getStrategy().fetchTransactionType());
    }

    @Test
    void cleanDatabase() {
        database.saveTransactionType(tt1);
        database.saveUser(user1);
        database.saveTransaction(transaction1);

        database.cleanDatabase();

        assertTrue(database.findAllUsers().isEmpty());
        assertTrue(database.findAllTransactions().isEmpty());
        assertTrue(database.findAllTransactionTypes().isEmpty());
    }

    @Test
    void  findTransactionsByUserId() {
        database.saveTransactionType(tt1);
        database.saveUser(user1);
        database.saveTransaction(transaction1);
        List<Transaction> testList =new ArrayList<Transaction>();
        testList.add(transaction1);
        assertEquals(testList,database.findTransactionsByUserId(userId1));
    }
}