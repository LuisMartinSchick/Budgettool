package Controller;

import Database.MockDatabase;
import Database.Transaction;
import Resources.TransactionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/transaction")
public class TransactionController {

    private final MockDatabase mockDatabase;

    @Autowired
    public TransactionController(MockDatabase mockDatabase) {
        this.mockDatabase = mockDatabase;
    }

//    @PostMapping("addtransaction")
//    String addtransaction(@Valid @RequestBody TransactionResource transactionResource) {}

}
