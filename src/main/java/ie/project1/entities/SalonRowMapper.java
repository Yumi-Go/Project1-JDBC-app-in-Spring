package ie.project1.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalonRowMapper implements RowMapper<Salon> {

    @Override
    public Salon mapRow(ResultSet rs, int rowNum) throws SQLException {
        Salon salon = new Salon();
        salon.setSalonId(rs.getString(1));
        salon.setSalonName(rs.getString(2));
        salon.setSalonAddress(rs.getString(3));
        salon.setSalonPhone(rs.getString(4));
        salon.setSalonOpenDays(rs.getString(5));
        return salon;
    }
}
