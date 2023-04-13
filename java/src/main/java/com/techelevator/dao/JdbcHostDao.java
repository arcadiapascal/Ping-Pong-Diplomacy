package com.techelevator.dao;

import com.techelevator.model.Host;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcHostDao implements HostDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcHostDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // CREATE A NEW HOST
    @Override
    public void addHost(Host host) throws SQLException {
        String sql = "INSERT INTO host (host_name, user_id) " +
                "VALUES (?, ?)";
        jdbcTemplate.update(sql, host.getHostName(), host.getUserId());
    }

    // LIST ALL HOSTS
    @Override
    public List<Host> getAllHosts() throws SQLException {
        List<Host> hosts = new ArrayList<>();
        String sql = "SELECT * FROM host";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Host host = mapRowToHost(results);
            hosts.add(host);
        }
        return hosts;
    }

    // GET HOST BY ID
    @Override
    public Host getHostById(int id) throws SQLException {
        Host host = null;
        String sql = "SELECT * FROM host WHERE host_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if (result.next()) {
            host = mapRowToHost(result);
        }
        return host;
    }

    // UPDATE A HOST
    @Override
    public void updateHost(Host host) throws SQLException {
        String sql = "UPDATE host SET host_name = ?, user_id = ? " +
                "WHERE host_id = ?";
        jdbcTemplate.update(sql, host.getHostName(), host.getUserId(), host.getId());
    }

    // DELETE A HOST
    @Override
    public void deleteHost(int id) throws SQLException {
        String sql = "DELETE FROM HOST WHERE host_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private Host mapRowToHost(SqlRowSet result) {
        int id = result.getInt("host_id");
        String hostName = result.getString("host_name");
        int userId = result.getInt("user_id");
        return new Host(id, hostName, userId);
    }
}
