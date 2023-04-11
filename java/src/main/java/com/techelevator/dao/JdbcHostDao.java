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

    @Override
    public void addHost(Host host) throws SQLException {
        String sql = "INSERT INTO host (id, host_name, description, city, state, username) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, host.getId(), host.getHostName(), host.getDescription(),
                host.getCity(), host.getState(), host.getUsername());
    }

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

    @Override
    public Host getHostById(int id) throws SQLException {
        Host host = null;
        String sql = "SELECT * FROM host WHERE id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if (result.next()) {
            host = mapRowToHost(result);
        }
        return host;
    }

    @Override
    public void updateHost(Host host) throws SQLException {
        String sql = "UPDATE host SET host_name = ?, description = ?, city = ?, state = ?, " +
                "username = ? WHERE id = ?";
        jdbcTemplate.update(sql, host.getHostName(), host.getDescription(), host.getCity(),
                host.getState(), host.getUsername(), host.getId());
    }

    @Override
    public void deleteHost(Host host) throws SQLException {
        String sql = "DELETE FROM host WHERE id = ?";
        jdbcTemplate.update(sql, host.getId());
    }

    private Host mapRowToHost(SqlRowSet result) {
        int id = result.getInt("id");
        String hostName = result.getString("host_name");
        String description = result.getString("description");
        String city = result.getString("city");
        String state = result.getString("state");
        String username = result.getString("username");
        return new Host(id, hostName, description, city, state, username);
    }
}
