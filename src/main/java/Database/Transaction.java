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
    private int int_user_id_fk;

    @Column(nullable = false, columnDefinition = "Amount of money in the transaction")
    @NotBlank(message = "Value is mandatory")
    private float float_value;

    // TODO foreign key
    @NotBlank(message = "Transaction Type foreign Key is mandatory")
    private int int_try_type_fkype;
}