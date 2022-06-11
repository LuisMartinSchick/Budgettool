package Database;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

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

    // Defines weather it is income or Outcone 0 = Expense, 1 = Income
    @NotBlank(message = "Income qualifier is mandatory")
    private int bool_income;

    // TODO foreign KEy
    @NotBlank(message = "User foreign Key is mandatory")
    private int int_user_id_fk;


}