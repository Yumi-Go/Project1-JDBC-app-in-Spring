package ie.project1.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StylistRowMapper implements RowMapper<Stylist> {


//    private int stylistId; // unique
//    private String stylistName; // not blank, not unique
//    private String stylistPhone; // can be blank
//    private int stylistSalary; // positive number
    @Override
    public Stylist mapRow(ResultSet rs, int rowNum) throws SQLException {
        Stylist stylist = new Stylist();
        stylist.setStylistId(rs.getInt(1));
        stylist.setStylistName(rs.getString(2));
        stylist.setStylistPhone(rs.getString(3));
        stylist.setStylistSalary(rs.getInt(4));
        stylist.setSalonId(rs.getInt(5));
        return stylist;
    }
}
