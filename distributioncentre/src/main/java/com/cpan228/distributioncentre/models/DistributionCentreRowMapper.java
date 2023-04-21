package com.cpan228.distributioncentre.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//import com.cpan228.distributioncentre.models.DistributionCentre;

public class DistributionCentreRowMapper implements RowMapper<DistributionCentre> {

    @Override
    public DistributionCentre mapRow(ResultSet rs, int rowNum) throws SQLException {
        DistributionCentre distributionCentre = new DistributionCentre();
        distributionCentre.setId(rs.getLong("id"));
        distributionCentre.setName(rs.getString("name"));
        distributionCentre.setLatitude(rs.getDouble("latitude"));
        distributionCentre.setLongitude(rs.getDouble("longitude"));
        return distributionCentre;
    }
}
