package pl.coderslab.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.validation.constraints.Size;

public class RegistrationDto {

    @Size(min = 3, max = 30)
    private String name;
    @Size(min = 3, max = 30)
    private String lastName;

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

    @NotEmpty
    private String passwordRepeat;

    @PESEL
    private String pesel;


    //getter setter

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
