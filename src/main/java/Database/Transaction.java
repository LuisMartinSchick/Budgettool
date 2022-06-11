package Database;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
/**
 * Automatically create Getter and Setter methods.
 */
@Entity
@Getter
@Setter
@Table(name = "tbl_transactions")
public class Transaction {
    /**
     * Constructors for the class Transaction.
     * */
    public Transaction() {}

    public Transaction(int int_user_id_fk,
                       float float_value,
                       int int_try_type_fkype
    ) {
        this.int_user_id_fk = int_user_id_fk;
        this.float_value = float_value;
        this.int_try_type_fkype = int_try_type_fkype;
    }
    /**
     * Variables for the Transaction class.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private long id;

    @NotBlank(message = "User foreign Key is mandatory")
    @Setter(AccessLevel.NONE)
    private long int_user_id_fk;

    @Column(nullable = false, columnDefinition = "Amount of money in the transaction")
    @NotBlank(message = "Value is mandatory")
    private float float_value;

    // TODO foreign key
    @NotBlank(message = "Transaction Type foreign Key is mandatory")
    private int int_try_type_fkype;
    /**
     * The toString method for the class Transaction.
     *
     * @return a String of the variables of the Transaction-object.
     */
    public String toString() {
        return "Transaction{id=" + id +
                ", user-id=" + int_user_id_fk +
                ", money=" + float_value +
                ", type=" + int_try_type_fkype + "}";
    }
}