package ie.project1.dao;

import ie.project1.dao.dto.StylistWithSalon;
import ie.project1.dao.dto.StylistWithSalonRowMapper;
import ie.project1.entities.Salon;
import ie.project1.entities.SalonRowMapper;
import ie.project1.entities.Stylist;
import ie.project1.entities.StylistRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StylistDaoImpl implements StylistDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//    @Autowired
//    public StylistDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//    }

    // Get all stylists in a particular salon.
    @Override
    public List<Stylist> findAllBySalon(int salonId) {
        return jdbcTemplate.query("select * from stylists where salon_id = ?", new StylistRowMapper(), salonId);
    }

    // Add a stylist, ensuring you add them to a salon.
    @Override
    public void create(Stylist stylist) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", stylist.getSalonId());
        mapSqlParameterSource.addValue("name", stylist.getStylistName());
        mapSqlParameterSource.addValue("phone", stylist.getStylistPhone());
        mapSqlParameterSource.addValue("salary", stylist.getStylistSalary());
        mapSqlParameterSource.addValue("salon", stylist.getSalonId());
        String SQL = "insert into stylists(stylist_id, stylist_name, stylist_phone, stylist_salary, salon_id) " +
                "values (:id, :name, :phone, :salary, :salon)";
        namedParameterJdbcTemplate.update(SQL, mapSqlParameterSource);
    }

    @Override
    public Optional<Stylist> findById(int id) {
        try {
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("id", id);
            return Optional.ofNullable(namedParameterJdbcTemplate.queryForObject(
                    "select * from stylists where stylist_id=:id", mapSqlParameterSource, new StylistRowMapper())
            );
        } catch(EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }

    // Move a stylist from one salon to another.
    @Override
    public boolean updateSalon(int id, int newSalonId) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("new_salon", newSalonId);
        mapSqlParameterSource.addValue("id", id);
        String SQL = "update stylists set salon_id = :new_salon where stylist_id=:id";
        return namedParameterJdbcTemplate.update(SQL, mapSqlParameterSource) == 1;
    }

    // Delete a stylist.
    @Override
    public boolean deleteById(int id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource().addValue("id", id);
        String SQL = "delete from stylists where stylist_id = :id";
        return namedParameterJdbcTemplate.update(SQL, mapSqlParameterSource) == 1;
    }

    @Override
    public int getSalaryBySalon(int salonId) {
        List<Stylist> stylists = findAllBySalon(salonId);
        List<Integer> salaryList = stylists.stream().map(Stylist::getStylistSalary).toList();
//        for (Stylist s : stylists) {
//        }
        int sum = 0;
        int average;
        for (Integer salary : salaryList) {
            sum = sum + salary;
        }
        average = sum / salaryList.size();
        System.out.println("average of salary: " + average);
        return average;
    }

    // Get all stylists along with the name of the salon for which they work - use a record.
    @Override
    public List<StylistWithSalon> findAllWithSalon() {
        return jdbcTemplate.query("select st.stylist_id, st.stylist_name, st.stylist_phone, st.stylist_salary, sa.salon_name " +
                "from stylists st inner join salons sa on st.salon_id = sa.salon_id", new StylistWithSalonRowMapper());

//        String SQL = "select st.stylist_id, st.stylist_name, st.stylist_phone, st.stylist_salary, sa.salon_name " +
//                "from stylists st inner join salons sa on st.salon_id = sa.salon_id";
//        return namedParameterJdbcTemplate.getJdbcTemplate().query(SQL, new StylistWithSalonRowMapper());
    }
}
