package com.cpan228.distributioncentre.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;
//import javax.sql.DataSource;
import java.util.Optional;

import com.cpan228.distributioncentre.models.DistributionCentreRowMapper;
import com.cpan228.distributioncentre.models.DistributionCentre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DistributionCentreRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<DistributionCentre> findAll() {
        String sql = "SELECT * FROM distribution_centres";
        return jdbcTemplate.query(sql, new DistributionCentreMapper());
    }

    public Optional<DistributionCentre> findById(Long id) {
        String sql = "SELECT * FROM distribution_centre WHERE id = ? LIMIT 1";
        RowMapper<DistributionCentre> rowMapper = new DistributionCentreRowMapper();
        List<DistributionCentre> results = jdbcTemplate.query(sql, new Object[] { id }, rowMapper);
        return results.stream().findFirst();
    }    

    public DistributionCentre save(DistributionCentre distributionCentre) {
        String sql = "INSERT INTO distribution_centres (name, latitude, longitude) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, distributionCentre.getName(), distributionCentre.getLatitude(), distributionCentre.getLongitude());

        return distributionCentre;
    }

    public DistributionCentre update(DistributionCentre distributionCentre) {
        String sql = "UPDATE distribution_centres SET name = ?, latitude = ?, longitude = ? WHERE id = ?";
        jdbcTemplate.update(sql, distributionCentre.getName(), distributionCentre.getLatitude(), distributionCentre.getLongitude(), distributionCentre.getId());

        return distributionCentre;
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM distribution_centres WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<DistributionCentre> findByItemBrandAndItemName(String brand, String name) {
        String sql = "SELECT * FROM distribution_centre dc INNER JOIN item i ON dc.id = i.distribution_centre_id WHERE i.brand = ? AND i.name = ?";
        RowMapper<DistributionCentre> rowMapper = new DistributionCentreRowMapper();
        List<DistributionCentre> result = jdbcTemplate.query(sql, new Object[] { brand, name }, rowMapper);
        return result;
    }
    

    private static final class DistributionCentreMapper implements RowMapper<DistributionCentre> {
        public DistributionCentre mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            Double latitude = rs.getDouble("latitude");
            Double longitude = rs.getDouble("longitude");

            return new DistributionCentre(id, name, null, latitude, longitude);
        }
    }
}


