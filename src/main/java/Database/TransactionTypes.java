package Database;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Getter
@Setter
public class TransactionTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @NotBlank(message = "Transaction Type Description is mandatory")
    private String str_trx_desc_EN;

    // Defines whether it is income or outcome
    // 0 = Expense, 1 = Income
    @NotBlank(message = "Income qualifier is mandatory")
    private int bool_income;

    // TODO foreign Key
    @NotBlank(message = "User foreign Key is mandatory")
    @Setter(AccessLevel.NONE)
    private UUID uuid_user_id_fk;


    public TransactionTypes(UUID trxId, int bool_income, UUID userId) {
        this.id=trxId;
        this.bool_income=bool_income;
        this.uuid_user_id_fk=userId;
    }

    public TransactionTypes(UUID trxId, String str_trx_desc_EN,int bool_income, UUID userId) {
        this.id=trxId;
        this.str_trx_desc_EN=str_trx_desc_EN;
        this.bool_income=bool_income;
        this.uuid_user_id_fk=userId;
    }

    public TransactionTypes() {

    }

    @Override
    public String toString() {
        return "TransactionType{UUID=" + id.toString() + ", trx-desc=" + str_trx_desc_EN +
                ", is-income=" + bool_income + ", User-UUID=" + uuid_user_id_fk.toString() + "}";
    }
}