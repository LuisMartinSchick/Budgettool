package Database;

import Summary.ChangeBudgetType;
import Summary.Einmalige_Zahlung;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "tbl_transaction_types")
public class TransactionTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotBlank(message = "Transaction Type Description is mandatory")
    private String str_trx_desc_EN;

    // Defines whether it is income or outcome 0 = Expense, 1 = Income
    @NotBlank(message = "Income qualifier is mandatory")
    private int bool_income;

    // TODO foreign KEy
    @NotBlank(message = "User foreign Key is mandatory")
    private UUID uuid_user_id_fk;

    //Strategy des Strategy Patterns
    @OneToOne
    private ChangeBudgetType strategy;

    public TransactionTypes(UUID trxUuid, String strTrxName, int isIncome, UUID uuidUser) {
             this.id=trxUuid;
             this.str_trx_desc_EN=strTrxName;
             this.bool_income=isIncome;
             this.uuid_user_id_fk=uuidUser;
         }

    public TransactionTypes(UUID trxUuid, String strTrxName, int isIncome, UUID uuidUser, ChangeBudgetType strategy) {
        this.id=trxUuid;
        this.str_trx_desc_EN=strTrxName;
        this.bool_income=isIncome;
        this.uuid_user_id_fk=uuidUser;
        this.strategy = strategy;
    }
    public TransactionTypes() {

    }

    public TransactionTypes(UUID trxUuid, int isIncome, UUID uuidUser) {
        this.id=trxUuid;
        this.bool_income=isIncome;
        this.uuid_user_id_fk=uuidUser;
    }

    @Override
    public String toString() {
        return "TransactionType{UUID=" + id.toString() + ", trx-desc=" + str_trx_desc_EN +
                ", is-income=" + bool_income + ", User-UUID=" + uuid_user_id_fk.toString() + "}";
    }
}