package ie.project1.dao;

import ie.project1.entities.Salon;
import ie.project1.entities.SalonRowMapper;
import ie.project1.entities.StylistRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SalonDaoImpl implements SalonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    // Get all salons.
    @Override
    public List<Salon> getAll() {
        return jdbcTemplate.query("select * from salons", new SalonRowMapper());
    }

    // Create a new salon providing all data and return this new salon (from service layer).
    @Override
    public void save(Salon salon) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", salon.getSalonId());
        mapSqlParameterSource.addValue("name", salon.getSalonName());
        mapSqlParameterSource.addValue("address", salon.getSalonAddress());
        mapSqlParameterSource.addValue("phone", salon.getSalonPhone());
        mapSqlParameterSource.addValue("open", salon.getSalonOpenDays());
        String SQL = "insert into salons(salon_id, salon_name, salon_address, salon_phone, salon_open_days) " +
                "values (:id, :name, :address, :phone, :open)";
        namedParameterJdbcTemplate.update(SQL, mapSqlParameterSource);
    }

    // Get all salons by name e.g. all salons called "Hair Today".
    @Override
    public List<Salon> findAllByName(String name) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name", name);
        return namedParameterJdbcTemplate.getJdbcTemplate().query("select * from salons where salon_name=:name", new SalonRowMapper());
    }

    // Get a salon by its primary key.
    @Override
    public Optional<Salon> findById(String id) {
        try {
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("id", id);
            return Optional.ofNullable(namedParameterJdbcTemplate.queryForObject(
                    "select * from salons where salon_id=:id", mapSqlParameterSource, new SalonRowMapper())
            );
        } catch(EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }

    // Update salon by modifying the days on which it is open
    @Override
    public boolean editOpenDays(String newOpenDays, String id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("new_open_days", newOpenDays);
        mapSqlParameterSource.addValue("id", id);
        String SQL = "update salons set salon_open_days = :new_open_days where salon_id=:id";
        return namedParameterJdbcTemplate.update(SQL, mapSqlParameterSource) == 1;
    }

    // Delete a salon and all that salon's stylists.
    @Override
    public boolean deleteById(String id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        return namedParameterJdbcTemplate.update("delete from salons where salon_id=:id", mapSqlParameterSource) == 1;
    }

    // List all those salons open 7 days a week.
    @Override
    public List<Salon> findAllDaysOpen() {
        return jdbcTemplate.query("select * from salons where salon_open_days = '1111111'", new SalonRowMapper());
    }
}
