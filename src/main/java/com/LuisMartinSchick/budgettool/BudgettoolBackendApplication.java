package com.LuisMartinSchick.budgettool;

import Database.MockDatabase;
import Database.Transaction;
import Database.TransactionTypes;
import Database.User;
import Summary.Einmalige_Zahlung;
import Summary.Monatliche_Zahlung;
import Summary.TimeController;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.UUID;


@SpringBootApplication
public class BudgettoolBackendApplication {
    static Scanner scanner = new Scanner(System.in);
    private static final MockDatabase mockDatabase = MockDatabase.getDatabase();
    static UUID userUUID;
    static TimeController controller = TimeController.getTimeController();


    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(BudgettoolBackendApplication.class, args);
        Thread.sleep(500);
        userUUID = UUID.randomUUID();
        System.out.println("Welcome to the CLI-Version of the tool!\nFirst, let's get to know you!");
        User newUser = new User(
                getInput("What is your name?"),
                getInput("What is your first name?"),
                getInput("What is your mail?"), "N/A", "N/A",
                Integer.parseInt(getInput("Your birthday? Formatted as YYYYMMDD")),
                Integer.parseInt(getInput("Are you a student? Yes: 1\tNo: 0")),
                Float.parseFloat(getInput("How much money do you wish to start with?")),
                userUUID);
        mockDatabase.saveUser(newUser);
        System.out.println("Nice! Now, let's create your first Transaction Type - with these you'll be able to categorize your transactions.");
        createTrxType();
        System.out.println("Awesome! Shall we add our first transaction?");
        System.out.println("As a reminder, here is a list with all the Transaction Types:");
        int i = 0;
        for (TransactionTypes tt : mockDatabase.findAllTransactionTypes()) {
            System.out.println(i + "\t" + tt.toString());
            i++;
        }
        createTrx();
        boolean endprogram = false;
        while (!endprogram) {
            switch (Integer.parseInt(getInput("What would you like to do?" +
                    "\n1:\tAdd a new Transaction Type" +
                    "\n2:\tAdd a new Transaction" +
                    "\n3:\tGet all my Transaction Types" +
                    "\n4:\tGet all my Transactions" +
                    "\n5:\tAdvance Time" +
                    "\n0:\tEnd the program"))) {
                case 1:
                    createTrxType();
                    break;
                case 2:
                    createTrx();
                    break;
                case 3:
                    for (TransactionTypes tt : mockDatabase.findAllTransactionTypes()) {
                        System.out.println(i + "\t" + tt.toString());
                        i++;
                    }
                    break;
                case 4:
                    for (Transaction t : mockDatabase.findAllTransactions()) {
                        System.out.println(i + "\t" + t.toString());
                        i++;
                    }
                    break;
                case 5:
                    controller.advanceTime();
                    System.out.println("Your current money: " + mockDatabase.findUserById(userUUID).getFloat_money_amount());
                    break;
                case 0:
                default:
                    endprogram = true;
                    break;
            }
        }
        scanner.close();


    }

    private static String getInput(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }

    private static void createTrx() {
        do {
            Transaction trx = new Transaction(
                    UUID.randomUUID(),
                    userUUID,
                    Float.parseFloat(getInput("How much money is in this transaction?")),
                    UUID.fromString(getInput("Copy the Hexcode of the UUID above you want to assign it to")));
            mockDatabase.saveTransaction(trx);
        } while (getInput("Would you like to do another Transaction? If so, write '1', if not, write '0'").equals("1"));
    }

    private static void createTrxType() {
        do {
            TransactionTypes newTT = new TransactionTypes(
                    UUID.randomUUID(),
                    getInput("Whats the name of the Type?"),
                    Integer.parseInt(getInput("Will you use it for incoming transactions? If so, write '1', if not, write '0'")),
                    userUUID,
                    (getInput("Do you want this to be a Monthly Transaction? If so, write '1', else write '0'")
                            .equals("1")) ? new Monatliche_Zahlung() : new Einmalige_Zahlung());
            mockDatabase.saveTransactionType(newTT);
        } while (getInput("Would you like to do another Transaction Type? If so, write '1', if not, write '0'").equals("1"));
    }


}
