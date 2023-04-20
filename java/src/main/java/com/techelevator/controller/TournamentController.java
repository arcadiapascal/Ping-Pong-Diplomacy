package com.techelevator.controller;


import com.techelevator.dao.*;
import com.techelevator.model.Host;
import com.techelevator.model.Player;
import com.techelevator.model.Team;
import com.techelevator.model.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;


@RestController
public class TournamentController {


    // WIRES THE JDBCDAO CLASSES TOGETHER WITH THE CONTROLLER.
    @Autowired
    private UserDao userDao;
    @Autowired
    private PlayerDao playerDao;
    @Autowired
    private HostDao hostDao;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private TournamentDao tournamentDao;


    // TOURNAMENT METHODS
    // CREATES A NEW TOURNAMENT
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    @PostMapping("/tournaments/create")
    public ResponseEntity<?> createTournament(@RequestBody Tournament tournament) {
        try {
            tournamentDao.createTournament(tournament);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // UPDATE A TOURNAMENT
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin
    @PutMapping("/tournaments/update/{id}")
    public ResponseEntity<Tournament> updateTournament(@PathVariable int id, @RequestBody Tournament tournament) {
        try {
            tournamentDao.updateTournament(id, tournament);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating tournament", e);
        }
    }


    // GET LIST OF ALL TOURNAMENTS
    @CrossOrigin
    @GetMapping("/tournaments")
    public List<Tournament> getAllTournaments() {
        try {
            return tournamentDao.getAllTournaments();
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error getting tournaments", e);
        }
    }

    // GET LIST OF PAST TOURNAMENTS
    @GetMapping("/tournaments/past")
    public List<Tournament> getPastTournaments() {
        try {
            return tournamentDao.getPastTournaments();
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error getting past tournaments", e);
        }
    }

    // GET LIST OF PRESENT AND FUTURE TOURNAMENTS
    @GetMapping("/tournaments/upcoming")
    public List<Tournament> getPresentAndFutureTournaments() {
        try {
            return tournamentDao.getFutureTournaments();
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error getting present and future tournaments", e);
        }
    }

    // GET TOURNAMENT DETAILS
    @GetMapping("/tournaments/{id}")
    public Tournament getTournamentDetails(@PathVariable int id) {
        try {
            Tournament tournament = tournamentDao.getTournamentById(id);
            if (tournament == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tournament not found");
            }
            return tournament;
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error getting tournament details", e);
        }
    }

    // DELETE A TOURNAMENT
    @DeleteMapping("/tournaments/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable int id) {
        try {
            tournamentDao.deleteTournament(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting tournament", e);
        }
    }
    // GET ALL PLAYERS IN A TOURNAMENT
    @CrossOrigin
    @RequestMapping(path = "/tournaments/{tournamentId}/tournamentPlayers", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> getAllPlayersFromTournament(@PathVariable int tournamentId){
        List<Player> players = playerDao.getAllPlayersFromTournament(tournamentId);
        if (players.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(players, HttpStatus.OK);
    }


    // Add a player to a tournament
    @CrossOrigin
    @RequestMapping(path = "/tournaments/{tournamentId}/players", method = RequestMethod.POST)
    public void addPlayerToTournament(@PathVariable int tournamentId, @RequestBody Player player) throws SQLException {
        tournamentDao.addPlayerToTournament(tournamentId, player.getPlayerId());
    }

    // Remove a player from a tournament
    @RequestMapping(path = "/tournaments/{id}/players/{playerId}", method = RequestMethod.DELETE)
    public void removePlayerFromTournament(@PathVariable int id, @PathVariable int playerId) throws SQLException {
        tournamentDao.removePlayerFromTournament(id, playerId);
    }

//    // *Add a team to a tournament
//    @RequestMapping(path = "/tournaments/{id}/teams", method = RequestMethod.POST)
//    public void addTeamToTournament(@PathVariable int id, @RequestBody Team team) throws SQLException {
//        tournamentDao.addTeamToTournament(id, team.getId());
//    }
//
//    // *Remove a team from a tournament
//    @RequestMapping(path = "/tournaments/{id}/teams/{teamId}", method = RequestMethod.DELETE)
//    public void removeTeamFromTournament(@PathVariable int id, @PathVariable int teamId) throws SQLException {
//        tournamentDao.removeTeamFromTournament(id, teamId);
//    }


    // TEAM METHODS
    // POST NEW TEAM
    @RequestMapping(path = "/teams/create", method = RequestMethod.POST)
    public void addTeam(@RequestBody Team team) throws SQLException {
        teamDao.addTeam(team);
    }

    // PUT EXISTING TEAM
    @CrossOrigin
    @RequestMapping(path = "/teams/{id}", method = RequestMethod.PUT)
    public void updateTeam(@PathVariable int id, @RequestBody Team team) throws SQLException {
        team.setId(id);
        teamDao.updateTeam(team);
    }

    // GET ALL TEAMS
    @CrossOrigin
    @RequestMapping(path = "/teams/all", method = RequestMethod.GET)
    public List<Team> getAllTeams() throws SQLException {
        return teamDao.getAllTeams();
    }

    // GET TEAM BY ID
    @RequestMapping(path = "/teams/id/{id}", method = RequestMethod.GET)
    public Team getTeamById(@PathVariable int id) throws SQLException {
        return teamDao.getTeamById(id);
    }

    // GET TEAM BY NAME
    @RequestMapping(path = "/teams/name/{name}", method = RequestMethod.GET)
    public Team getTeamByName(@PathVariable String name) throws SQLException {
        return teamDao.getTeamByName(name);
    }

    // GET TEAMS BY STATE
    @RequestMapping(path = "/teams/state/{state}", method = RequestMethod.GET)
    public List<Team> getTeamsByState(@PathVariable String state) throws SQLException {
        return teamDao.listTeamsInState(state);
    }

    // GET TEAMS BY CITY
    @RequestMapping(path = "/teams/city/{city}", method = RequestMethod.GET)
    public List<Team> getTeamsByCity(@PathVariable String city) throws SQLException {
        return teamDao.listTeamsInCity(city);
    }

    // DELETE A TEAM
    @DeleteMapping("/teams/id/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable int id) throws SQLException {
        Team teamToDelete = teamDao.getTeamById(id);
        if (teamToDelete == null) {
            return ResponseEntity.notFound().build();
        }
        teamDao.deleteTeam(teamToDelete);
        return ResponseEntity.noContent().build();
    }

    // HOST METHODS
    // Create a new Host
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/hosts/create", method = RequestMethod.POST)
    public void addHost(@RequestBody Host host) {
        try {
            hostDao.addHost(host);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error adding host", e);
        }
    }

    // UPDATE A HOST
    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/hosts/{id}", method = RequestMethod.PUT)
    public void updateHost(@PathVariable int id, @RequestBody Host host) {
        try {
            Host existingHost = hostDao.getHostById(id);
            if (existingHost == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Host not found");
            }
            existingHost.setHostName(host.getHostName());
            existingHost.setUserId(host.getUserId());
            hostDao.updateHost(existingHost);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating host", e);
        }
    }

    // GET ALL HOSTS
    @CrossOrigin
    @RequestMapping(value = "/hosts", method = RequestMethod.GET)
    public List<Host> getAllHosts() {
        try {
            return hostDao.getAllHosts();
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error getting hosts", e);
        }
    }

    // GET SINGLE HOST
    @GetMapping("/hosts/{id}")
    public Host getHostById(@PathVariable int id) {
        Host host = null;
        try {
            host = hostDao.getHostById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return host;
    }

    // DELETE A HOST
    @DeleteMapping("/hosts/{id}")
    public void deleteHost(@PathVariable int id) {
        try {
            hostDao.deleteHost(id);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    // PLAYER METHODS
    // Create a new player
    @CrossOrigin
    @PostMapping("/players/create")
    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        try {
            playerDao.addPlayer(player);
            return new ResponseEntity<>("Player added successfully", HttpStatus.CREATED);
        } catch (SQLException e) {
            return new ResponseEntity<>("Error adding player", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    // ADDS A PLAYER TO A TEAM
//    @PostMapping("/teams/{teamId}/players")
//    public void addPlayerToTeam(@PathVariable int teamId, @RequestBody Player player) throws SQLException {
//        teamDao.addPlayerToTeam(teamId, player.getPlayerId());
//    }
//
//    // REMOVE PLAYER FROM TEAM
//    @DeleteMapping("/teams/{teamId}/players/{playerId}")
//    public void removePlayerFromTeam(@PathVariable int teamId, @PathVariable int playerId) throws SQLException {
//        teamDao.removePlayerFromTeam(teamId, playerId);
//    }

    // Get all players
    @CrossOrigin
    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAllPlayers() {
        try {
            List<Player> players = playerDao.getAllPlayers();
            if (players.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(players, HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get player by ID
    @CrossOrigin
    @GetMapping("/players/id/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable int id) {
        try {
            Player player = playerDao.getPlayerById(id);
            return new ResponseEntity<>(player, HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update player
    @CrossOrigin
    @PutMapping("/players/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestBody Player player) {
        try {
            Player existingPlayer = playerDao.getPlayerById(id);
            if (existingPlayer == null) {
                return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
            }
            player.setPlayerId(id);
            playerDao.updatePlayer(player);
            return new ResponseEntity<>("Player updated successfully", HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("Error updating player", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete player
    @DeleteMapping("/players/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id) {
        try {
            Player existingPlayer = playerDao.getPlayerById(id);
            if (existingPlayer == null) {
                return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
            }
            playerDao.deletePlayer(existingPlayer);
            return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>("Error deleting player", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Test
//    @CrossOrigin
//    @GetMapping("/users/username/{username}/id")
//    public int youThere( @PathVariable String username){
////        var user = SecurityContextHolder.getContext().getAuthentication();
////        boolean authenticated = user.isAuthenticated();
//            var user = userDao.findByUsername(username);
//            return user.getId();
//    }
    @CrossOrigin
    @GetMapping("/users/username/{username}/id")
    public int getUserIdByUsername(@PathVariable String username) {
        int userId = userDao.findIdByUsername(username);
        return userId;
    }

//     GETS A USER ID FROM THEIR USERNAME


}
