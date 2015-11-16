package ua.park.gorky.db.dao.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.Role;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.entity.exception.DBLayerException;
import ua.park.gorky.db.connection.MySQLConnection;
import ua.park.gorky.db.constants.DbTables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Владислав on 16.11.2015.
 */
public class UserDAO implements IUserDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);

    private static final String ADD_USER = "INSERT INTO User (id_role, login, password, "
            + "first_name, last_name, email, phone, reg_date, status_banned, dob, salt)"
            + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    private static final String DELETE_USER = "DELETE FROM User WHERE idUser = ?";

    private static final String UPDATE_USER_PASSWORD = "UPDATE User SET Password = ? WHERE idUser =?";

    private static final String UPDATE_USER_STATUS = "UPDATE User SET status_banned = ? WHERE idUser = ?";

    private static final String GET_USER_BY_ID = "SELECT * FROM User WHERE idUser = ?";

    private static final String GET_USER_BY_LOGIN = "SELECT * FROM User WHERE login = ?";

    private static final int FIRST = 1;

    @Override
    public User getUserById(int id) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(GET_USER_BY_ID)) {
            pstm.setInt(FIRST, id);
            ResultSet rs = pstm.executeQuery();
            rs.relative(FIRST);
            return extractUser(rs);
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to get user with id = " + id, ex);
        } finally {
            commit(con);
        }
    }

    @Override
    public User getUserByLogin(String login) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(GET_USER_BY_LOGIN)) {
            pstm.setString(FIRST, login);
            ResultSet rs = pstm.executeQuery();
            rs.relative(FIRST);
            return extractUser(rs);
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to get user with login = " + login, ex);
        } finally {
            commit(con);
        }
    }

    @Override
    public void addUser(User user) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(ADD_USER)) {
            int k = FIRST;
            pstm.setInt(k++, user.getRole().getId());
            pstm.setString(k++, user.getLogin());
            pstm.setString(k++, user.getPassword());
            pstm.setString(k++, user.getFirstName());
            pstm.setString(k++, user.getLastName());
            pstm.setString(k++, user.getEmail());
            pstm.setString(k++, user.getPhone());
            pstm.setTimestamp(k++, user.getRegDate());
            pstm.setBoolean(k++, user.isStatusBanned());
            pstm.setDate(k++, user.getDob());
            pstm.setString(k, user.getSalt());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to add user" + user, ex);
        } finally {
            commit(con);
        }
    }

    @Override
    public void deleteUser(User user) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(DELETE_USER)) {
            pstm.setInt(1, user.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to delete user" + user, ex);
        } finally {
            commit(con);
        }
    }

    @Override
    public void updateUserPassword(User user) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(UPDATE_USER_PASSWORD)) {
            int k = FIRST;
            pstm.setString(k++, user.getPassword());
            pstm.setInt(k++, user.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to update user password" + user, ex);
        } finally {
            commit(con);
        }
    }

    @Override
    public void updateUserStatus(User user) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(UPDATE_USER_STATUS)) {
            int k = FIRST;
            pstm.setBoolean(k++, user.isStatusBanned());
            pstm.setInt(k++, user.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to update user status" + user, ex);
        } finally {
            commit(con);
        }
    }

    private void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                LOGGER.error("RollBack: " + ex.getMessage());
            }
        }
    }

    private void commit(Connection con) {
        if (con != null) {
            try {
                con.commit();
                con.close();
            } catch (SQLException ex) {
                LOGGER.error("Commit: " + ex.getMessage());
            }
        }
    }

    private User extractUser(ResultSet rs) {
        User user = new User();
        try {
            user.setId(rs.getInt(DbTables.User.ID));
            user.setLogin(rs.getString(DbTables.User.LOGIN));
            user.setPassword(rs.getString(DbTables.User.PASS));
            user.setFirstName(rs.getString(DbTables.User.NAME));
            user.setLastName(rs.getString(DbTables.User.LNANE));
            user.setEmail(rs.getString(DbTables.User.EMAIL));
            user.setPhone(rs.getString(DbTables.User.PHONE));
            user.setRegDate(rs.getTimestamp(DbTables.User.REG_DATE));
            user.setStatusBanned(rs.getBoolean(DbTables.User.STATUS));
            user.setDob(rs.getDate(DbTables.User.DOB));

            String role = rs.getString(DbTables.User.ROLE);
            user.setRole(Role.valueOf(role));

            return user;
        } catch (SQLException ex) {
            throw new DBLayerException("Failed to extract user" + user, ex);
        }
    }
}


