package ie.project1.dao.dto;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



//private int stylistId; // unique
//private String stylistName; // not blank, not unique
//private String stylistPhone; // can be blank
//private int stylistSalary; // positive number
//String salonName
public class StylistWithSalonRowMapper implements RowMapper<StylistWithSalon> {
    public StylistWithSalon mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new StylistWithSalon(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getInt(4),
                rs.getString(5)
        );
    }
}
