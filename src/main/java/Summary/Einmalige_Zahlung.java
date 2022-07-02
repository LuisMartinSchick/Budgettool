package Summary;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class Einmalige_Zahlung implements ChangeBudgetType {

    boolean isActive =true;
    UUID id = UUID.randomUUID();

   public  Einmalige_Zahlung( @JsonProperty("id") UUID id)
   {
      this.id = id;
      isActive = true;
   }

    @Override
    public float calculateAddedValue(float value){
        if(isActive){
            isActive = false;
            return value;
        }
        return 0;
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
    public String fetchTransactionType(){
        return "SinglePayment";
    }
}
