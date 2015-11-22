package ua.park.gorky.db.dao.attraction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.park.gorky.core.entity.Attraction;
import ua.park.gorky.core.entity.exception.DBLayerException;
import ua.park.gorky.db.connection.MySQLConnection;
import ua.park.gorky.db.extractor.IEntityExtractor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladyslav
 */
@Service
public class AttractionDAO implements IAttractionDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(AttractionDAO.class);

    @Autowired
    private IEntityExtractor<Attraction> extractAttraction;

    private static final String ADD_ATTRACTION = "INSERT INTO Attraction "
            + " (title, description, height, att_picture,"
            + " price_adult, price_child) VALUE (?,?,?,?,?,?)";

    private static final String DELETE_ATTRACTION = "DELETE FROM Attraction WHERE"
            + " idAttraction = ?";

    private static final String GET_ATTRACTIONS = "SELECT * FROM Attraction";
    private static final String GET_ATTRACTION_BY_ID = "SELECT * FROM Attraction"
            + " WHERE idAttraction = ?";

    @Override
    public void addAttraction(Attraction attraction) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(ADD_ATTRACTION)) {
            int k = 1;
            pstm.setString(k++, attraction.getTitle());
            pstm.setString(k++, attraction.getDescription());
            pstm.setInt(k++, attraction.getHeight());
            pstm.setString(k++, attraction.getImage());
            pstm.setInt(k++, attraction.getAdultPrice());
            pstm.setInt(k, attraction.getChildPrice());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to add attraction" + attraction, ex);
        } finally {
            commit(con);
        }
    }

    @Override
    public void deleteAttraction(Attraction attraction) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(DELETE_ATTRACTION)) {
            pstm.setInt(1, attraction.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to delete attraction" + attraction, ex);
        } finally {
            commit(con);
        }
    }

    @Override
    public List<Attraction> getAttractions() {
        Connection con = MySQLConnection.getWebInstance();
        List<Attraction> attractions = new ArrayList<>();
        try {
            ResultSet rs = con.createStatement().executeQuery(GET_ATTRACTIONS);
            while (rs.next()) {
                attractions.add(extractAttraction.extract(rs));
            }
            return attractions;
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to get all attractions", ex);
        } finally {
            commit(con);
        }
    }

    @Override
    public Attraction getAttractionById(int id) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(GET_ATTRACTION_BY_ID)) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            rs.relative(1);
            return extractAttraction.extract(rs);
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to get attraction by id=" + id, ex);
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

}
