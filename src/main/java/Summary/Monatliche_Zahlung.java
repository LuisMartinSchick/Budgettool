package Summary;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class Monatliche_Zahlung implements ChangeBudgetType{

    UUID id = UUID.randomUUID();
    public  Monatliche_Zahlung( @JsonProperty("id") UUID id)
    {
        this.id = id;
    }

    @Override
    public UUID getId() {
        return id;
    }



    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public float calculateAddedValue(float value){
            return value;
    }

    @Override
    public String fetchTransactionType(){
        return "MonthlyPayment";
    }
}
