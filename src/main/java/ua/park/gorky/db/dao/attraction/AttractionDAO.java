package ua.park.gorky.db.dao.attraction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.Attraction;
import ua.park.gorky.db.connection.MySQLConnection;
import ua.park.gorky.db.constants.DbTables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladyslav
 */
public class AttractionDAO implements IAttractionDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(AttractionDAO.class);

    private static final String ADD_ATTRACTION = "INSERT INTO Attraction "
            + " (title, description, height, att_picture,"
            + " price_adult, price_child) VALUE (?,?,?,?,?,?)";

    private static final String DELETE_ATTRACTION = "DELETE FROM Attraction WHERE"
            + " idAttraction = ?";

    private static final String GET_ATTRACTIONS = "SELECT * FROM Attraction";
    private static final String GET_ATTRACTION_BY_ID = "SELECT * FROM Attraction"
            + " WHERE idAttraction = ?";

    @Override
    public boolean addAttraction(Attraction attraction) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(ADD_ATTRACTION)) {
            int k = 1;
            pstm.setString(k++, attraction.getTitle());
            pstm.setString(k++, attraction.getDescription());
            pstm.setInt(k++, attraction.getHeight());
            pstm.setString(k++, attraction.getImage());
            pstm.setInt(k++, attraction.getAdultPrice());
            pstm.setInt(k++, attraction.getChildPrice());
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            rollback(con);
        } finally {
            commit(con);
        }
        return false;
    }

    @Override
    public boolean deleteAttraction(Attraction attraction) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(DELETE_ATTRACTION)) {
            pstm.setInt(1, attraction.getId());
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            rollback(con);
        } finally {
            commit(con);
        }
        return false;
    }

    @Override
    public List<Attraction> getAttractions() {
        Connection con = MySQLConnection.getWebInstance();
        List<Attraction> attractions = new ArrayList<>();
        try {
            ResultSet rs = con.createStatement().executeQuery(GET_ATTRACTIONS);
            while (rs.next()) {
                attractions.add(extractAtraction(rs));
            }
            return attractions;
        } catch (SQLException e) {
            rollback(con);
        } finally {
            commit(con);
        }
        return attractions;
    }

    @Override
    public Attraction getAttractionById(int id) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(GET_ATTRACTION_BY_ID)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            rs.relative(1);
            return extractAtraction(rs);
        } catch (SQLException e) {
            rollback(con);
        } finally {
            commit(con);
        }
        return null;
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

    private Attraction extractAtraction(ResultSet rs) throws SQLException {
        Attraction attraction = new Attraction();
        attraction.setId(rs.getInt(DbTables.Attraction.ID));
        attraction.setTitle(rs.getString(DbTables.Attraction.TITLE));
        attraction.setDescription(rs.getString(DbTables.Attraction.DESC));
        attraction.setHeight(rs.getInt(DbTables.Attraction.HEIGHT));
        attraction.setImage(rs.getString(DbTables.Attraction.PICTURE));
        attraction.setAdultPrice(rs.getInt(DbTables.Attraction.ADULT_PRICE));
        attraction.setChildPrice(rs.getInt(DbTables.Attraction.CHILD_PRICE));
        return attraction;
    }
}
