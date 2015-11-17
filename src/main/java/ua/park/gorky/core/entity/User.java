package ua.park.gorky.core.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Владислав on 16.11.2015.
 */
public class User extends Entity {

    private Role role;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Timestamp regDate;
    private boolean statusBanned;
    private Date dob;
    private String salt;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

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

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    public boolean isStatusBanned() {
        return statusBanned;
    }

    public void setStatusBanned(boolean statusBanned) {
        this.statusBanned = statusBanned;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id_user=", getId())
                .append("id_role=", role.getId())
                .append("login=", login)
                .append("password=", password)
                .append("firstName=", firstName)
                .append("lastName=", lastName)
                .append("email=", email)
                .append("phone=", phone)
                .append("reg_date=", regDate)
                .append("status_banned=", statusBanned)
                .append("dob=", dob)
                .append("salt=", salt)
                .build();
    }
}
