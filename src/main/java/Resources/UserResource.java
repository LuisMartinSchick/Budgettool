package Resources;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import javax.validation.constraints.NotNull;

@Value
public class UserResource {
    /**
     * Constructors for the class UserResource.
     * */
       public UserResource(@JsonProperty("name") String name,
                @JsonProperty("first-name") String first_name,
                @JsonProperty("email") String email,
                @JsonProperty("password")String password_hash,
                @JsonProperty("password_salt") String password_salt,
                @JsonProperty("birthday") int birthday,
                @JsonProperty("student") int student,
                @JsonProperty("money") float money) {
        this.txt_name = name;
        this.txt_first_name = first_name;
        this.txt_email = email;
        this.txt_password_hash = password_hash;
        this.txt_password_salt = password_salt;
        this.dat_unix_birthday = birthday;
        this.bool_student = student;
        this.float_money_amount = money;
    }
    /**
     * Variables for the UserResource class.
     * */
    @NotNull
    private String txt_name;

    @NotNull
    private String txt_first_name;

    @NotNull
    private String txt_email;

    @NotNull
    private String txt_password_hash;

    @NotNull
    private String txt_password_salt;

    @NotNull
    private int dat_unix_birthday;

    @NotNull
    private int bool_student;

    @NotNull
    private float float_money_amount;
}
