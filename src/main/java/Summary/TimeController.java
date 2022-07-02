package Summary;

import Database.MockDatabase;
import Database.Transaction;
import Database.User;

import java.util.ArrayList;
import java.util.List;


public class TimeController {
    //Singleton Pattern
    private static TimeController timeController;
    MockDatabase database = MockDatabase.getDatabase();
    float addedValue;

    public static TimeController getTimeController() {
        if (timeController == null) {
            timeController = new TimeController();
        }
        return timeController;
    }

    // TODO: hier vergisst er das Boolean, dass muss ich noch einfügen
    public String advanceTime() {
        List<User> userList = database.findAllUsers();
        for (User user : userList) {
            List<Transaction> trxList = database.findTransactionsByUserId(user.getId());
            float float_money_amount = user.getFloat_money_amount();

            for (Transaction trx : trxList) {
                float trx_value = trx.getFloatValue();
                addedValue = database.getTransactionTypeToTransaction(trx).getStrategy().calculateAddedValue(trx_value);
                if (database.getTransactionTypeToTransaction(trx).getBool_income() == 1)
                    float_money_amount += addedValue;
                else if (database.getTransactionTypeToTransaction(trx).getBool_income() == 0)
                    float_money_amount -= addedValue;
            }
            user.setFloat_money_amount(float_money_amount);
        }

        return "The Time has been sucessfully advanced";
    }
}
