package Summary;

import javax.persistence.*;
import java.util.UUID;

@Entity
public interface ChangeBudgetType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    UUID id = null;

    UUID getId() ;

    void setId(UUID id) ;

    //in dieser Klasse gibt eine transaction ihren Wert zurück. Die verwendete Strategy entscheidet, welche Methode genuzuz wird
    public float calculateAddedValue(float value);

    public String fetchTransactionType();
}
