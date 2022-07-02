package Controller;

import Database.MockDatabase;
import Database.TransactionTypes;
import Summary.ChangeBudgetType;
import Summary.Einmalige_Zahlung;
import Summary.Monatliche_Zahlung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Controller
@RequestMapping("/transactionTypes")
public class TransactionTypesController {
    private final MockDatabase mockDatabase;

    @Autowired
    public TransactionTypesController(MockDatabase mockDatabase) {
        this.mockDatabase = mockDatabase;
    }

    @PostMapping("/addType")
    public String addType(@Valid TransactionTypes transactionType, String text_trx_desc_EN, int bool_income, int int_user_id_fk) {
        // if (result.hasErrors()) return "add-Type";

        mockDatabase.saveTransactionType(transactionType);
        return "redirect:/Type/index";
    }

    @GetMapping
    public CollectionModel<TransactionTypes> fetchaAllItems(@Valid TransactionTypes transaction) {
        List<TransactionTypes> allTypes = mockDatabase.findAllTransactionTypes();
        CollectionModel<TransactionTypes> result = CollectionModel.of(allTypes);
        return result;
    }

    @PostMapping("/changeStrategy/{id}/{name}")
        public String changeStrategy(@PathVariable("id")UUID id, @PathVariable("name") String Type){
              mockDatabase.changeStrategy(id,Type);
         return "redirect:/index";
        }


    /* @GetMapping("/{id}")
    public TransactionTypes fetchTransactionTypeById(@PathVariable int id) {

    }*/

//        Optional<TransactionTypes> optionalTransaktionType = transactionTypesRepository.findById(id);
//        TransactionTypes transactionType;
//
//        if (optionalTransaktionType.isPresent())
//            transactionType = optionalTransaktionType.get();
//        else return null;
//
//        EntityModel<TransactionTypes> result = new EntityModel(transactionType);
//
//        return result;
//
//
//    }

}
