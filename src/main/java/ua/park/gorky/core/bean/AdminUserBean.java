package ua.park.gorky.core.bean;

import ua.park.gorky.core.validator.annotation.NotNull;
import ua.park.gorky.core.validator.annotation.StringNotEmpty;

/**
 * @author Vladyslav
 */
public class AdminUserBean extends UserBean {
    @NotNull
    @StringNotEmpty
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("AdminUserBean{");
        sb.append(super.toString());
        sb.append("role='").append(role).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
