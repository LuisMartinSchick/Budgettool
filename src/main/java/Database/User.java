package Database;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/*
 * Automatically create Getter and Setter methods.
 */
@Entity
@Getter
@Setter
public class User {
    /**
     * Constructors for the class User.
     */
    public User() {
    }

    public User(String name,
                String first_name,
                String email,
                String password_hash,
                String password_salt,
                int birthday,
                int student,
                float money) {
        this.txt_name = name;
        this.txt_first_name = first_name;
        this.txt_email = email;
        this.txt_password_hash = password_hash;
        this.txt_password_salt = password_salt;
        this.dat_unix_birthday = birthday;
        this.bool_student = student;
        this.float_money_amount = money;
    }

    public User(String name,
                String first_name,
                String email,
                String password_hash,
                String password_salt,
                int birthday,
                int student,
                float money,
                UUID id){
        this.txt_name = name;
        this.txt_first_name = first_name;
        this.txt_email = email;
        this.txt_password_hash = password_hash;
        this.txt_password_salt = password_salt;
        this.dat_unix_birthday = birthday;
        this.bool_student = student;
        this.float_money_amount = money;
        this.id = id;
    }

    public User(String name,
                float money) {
        this.txt_name = name;
        this.float_money_amount = money;
    }

    /**
     * Variables for the user class.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, columnDefinition = "User ID")
    @Setter(AccessLevel.NONE)
    private UUID id;

    @NotNull(message = "Must not be null")
    @Column(nullable = false, columnDefinition = "User name")
    @NotBlank(message = "User  name is mandatory")
    private String txt_name;

    @NotNull(message = "Must not be null")
    @NotBlank(message = "User first name is mandatory")
    private String txt_first_name;

    @Email(message = "Must be in email format!")
    @NotBlank(message = "Email is mandatory")
    private String txt_email;

    @NotNull(message = "Must not be null")
    @NotBlank(message = "A password hash is Mandatory")
    private String txt_password_hash;

    @NotBlank(message = "A password salt is Mandatory")
    private String txt_password_salt;

    @NotBlank(message = "A birthday is Mandatory")
    private int dat_unix_birthday;

    @NotBlank(message = "A student Qualifier is Mandatory")
    private int bool_student;

    @NotBlank(message = "A Money Amount is Mandatory")
    private float float_money_amount;

    /**
     * The toString method for the class User.
     *
     * @return a String of the variables of the User-object.
     */
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + txt_name + ", first name=" + txt_first_name +
                ", email=" + txt_email + ", birthday=" + dat_unix_birthday + ", student=" +
                bool_student + ", money=" + float_money_amount + "}";
    }
}
