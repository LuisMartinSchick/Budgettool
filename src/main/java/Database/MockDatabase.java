package Database;

import Summary.Einmalige_Zahlung;
import Summary.Monatliche_Zahlung;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MockDatabase {
    private List<User> userList = new ArrayList<User>();
    private List<Transaction> trxList = new ArrayList<Transaction>();
    private List<TransactionTypes> trxTypesList = new ArrayList<TransactionTypes>();

    //Sinlgeton Pattern
    private static MockDatabase database;

    public static MockDatabase getDatabase() {
        if (database == null) {
            database = new MockDatabase();
        }
        return database;
    }

    public String saveUser(User user) {
            userList.add(user);
        return "Added user successfully";
    }

    public List<User> findAllUsers() {
        return userList;
    }

    public User findUserById(UUID id) {
        User userResult = null;
        for (User user : userList) {
            if (user.getId().equals(id)) {
                userResult = user;
            }
        }
        return userResult;
    }

    public String deleteUserById(UUID id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                userList.remove(user);
                return "User was deleted";
            }
        }
        return "No User with that ID was found";
    }

    public String saveTransaction(Transaction transaction) {
            trxList.add(transaction);
        return "Added transaction successfully";
    }

    public List<Transaction> findAllTransactions() {
        return trxList;
    }

    public List<Transaction> findTransactionsByUserId(UUID userId){
        List<Transaction> ausgabeListe = new ArrayList<Transaction>();

        for(Transaction t : trxList){
            if(t.getUuidUserIdFk() == userId)
                ausgabeListe.add(t);
        }
        return ausgabeListe;
    }

    public Transaction findTransactionById(UUID id) {
        Transaction transactionResult = null;
            for (Transaction transaction : trxList) {
                if (transaction.getId().equals(id)) {
                    transactionResult = transaction;
                }
            }
        return transactionResult;
    }

    public String deleteTransactionById(UUID id) {
        for (Transaction transaction : trxList) {
            if (transaction.getId().equals(id)) {
                trxList.remove(transaction);
                return "Transaction was deleted";
            }
        }
        return "No Transaction with that ID was found";
    }

    public String saveTransactionType(TransactionTypes tt) {
        trxTypesList.add(tt);
        return "Added transaction type successfully";
    }

    public List<TransactionTypes> findAllTransactionTypes() {
        return trxTypesList;
    }

    public TransactionTypes findTransactionTypeById(UUID id) {
        TransactionTypes ttResult = null;

        for (TransactionTypes tt : trxTypesList) {
            if (tt.getId().equals(id)) {
                ttResult = tt;
            }
        }

        return ttResult;
    }

    public TransactionTypes getTransactionTypeToTransaction(Transaction transaction){
        return findTransactionTypeById(transaction.getUuidTrxTypeFk());
    }

    public String deleteTransactionTypeById(UUID id) {
        for (TransactionTypes tt : trxTypesList) {
            if (tt.getId().equals(id)) {
                trxTypesList.remove(tt);
                return "Transaction Type was deleted";
            }
        }
        return "No Transaction Type with that ID was found";
    }

    public String changeStrategy(UUID id,  String Type) {
        TransactionTypes transactionType = findTransactionTypeById(id);
        if (Type == "einmalig") {
            transactionType.setStrategy(new Einmalige_Zahlung());
            return "Die Strategie wurde auf eine einmalige Zahlung gesetzt";
        } else if (Type == "monatlich") {
            transactionType.setStrategy(new Monatliche_Zahlung());
            return "Die Strategie wurde auf eine monatliche Zahlung gesetzt";
        }
        return "Eine solcheStrategy ist nicht bekannt";
    }

    public void cleanDatabase() {
        userList.removeAll(userList);
        trxList.removeAll(trxList);
        trxTypesList.removeAll(trxTypesList);
    }


}
