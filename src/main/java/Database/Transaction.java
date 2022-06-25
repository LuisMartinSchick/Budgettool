package Database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "tbl_transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotBlank(message = "User foreign Key is mandatory")
    private UUID uuidUserIdFk;

    @Column(nullable = false, columnDefinition = "Amount of money in the transaction")
    @NotBlank(message = "Value is mandatory")
    private float floatValue;

    // TODO foreign key
    @NotBlank(message = "Transaction Type foreign Key is mandatory")
    private int intTrxTypeFk;

    public Transaction(UUID id, UUID userID, float floatAmount, int intTrxTypeFk) {
        this.id=id;
        this.uuidUserIdFk=userID;
        this.floatValue=floatAmount;
        this.intTrxTypeFk=intTrxTypeFk;
    }

    public Transaction() {

    }

    /**
     * The toString method for the class Transaction.
     *
     * @return a String of the variables of the Transaction-object.
     */
    public String toString() {
        return "Transaction{id=" + id.toString() +
                ", user-id=" + uuidUserIdFk.toString() +
                ", money=" + floatValue +
                ", type=" + intTrxTypeFk + "}";
    }
}