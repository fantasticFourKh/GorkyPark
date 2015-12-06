package ua.park.gorky.core.bean;

import ua.park.gorky.core.constants.CoreConsts;
import ua.park.gorky.core.validator.annotation.MatchPattern;
import ua.park.gorky.core.validator.annotation.NotNull;
import ua.park.gorky.core.validator.annotation.StringNotEmpty;

/**
 * @author Vladyslav
 */
public class UserBean implements ViewBean {
    @NotNull
    @StringNotEmpty
    @MatchPattern(pattern = CoreConsts.Pattern.INTERNATIONAL, message = "Incorrect login form")
    private String login;
    @NotNull
    @StringNotEmpty
    @MatchPattern(pattern = CoreConsts.Pattern.PASS, message = "Incorrect password form")
    private String password;
    @NotNull
    @StringNotEmpty
    private String repeatPassword;
    @NotNull
    @StringNotEmpty
    @MatchPattern(pattern = CoreConsts.Pattern.PERSONAL, message = "Incorrect first name")
    private String firstName;
    @NotNull
    @StringNotEmpty
    @MatchPattern(pattern = CoreConsts.Pattern.PERSONAL, message = "Incorrect last name")
    private String lastName;
    @NotNull
    @StringNotEmpty
    @MatchPattern(pattern = CoreConsts.Pattern.EMAIL, message = "Incorrect email")
    private String email;
    @NotNull
    @StringNotEmpty
    @MatchPattern(pattern = CoreConsts.Pattern.PHONE, message = "Incorrect phone number")
    private String phone;
    @NotNull
    @StringNotEmpty
    private String dob;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserBean{");
        sb.append("login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", repeatPassword='").append(repeatPassword).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", dob='").append(dob).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
