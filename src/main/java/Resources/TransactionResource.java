package Resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Value
public class TransactionResource {
    /**
     * Constructors for the class TransactionResource
     */
    public TransactionResource(
            @JsonProperty("id") UUID id,
            @JsonProperty("userId") UUID userId,
            @JsonProperty("money") float floatValue,
            @JsonProperty("trxTypeId") UUID trxTypeId)
    {
        this.id = id;
        this.userId = userId;
        this.floatValue = floatValue;
        this.trxTypeId = trxTypeId;
    }

    @NotNull
    private UUID id;

    @NotNull
    private UUID userId;

    @NotNull
    private float floatValue;

    @NotNull
    private UUID trxTypeId;
}
