<template>
  <div>
    <button @click="createTournamentButton()" >Create a Tournament!</button>
    <input v-model="tournamentSearchTerm" type="text" placeholder="Search tournaments">
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Description</th>
          <th>Number of Players</th>
          <th>Date</th>
          <th>Location</th>
          <th>Address</th>
          <th>Level</th>
          <th>Active</th>
          <th>Registration Deadline</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="tournament in tournamentsToShow" :key="tournament.id">
          <td>{{ tournament.name }}</td>
          <td>{{ tournament.tournamentDescription }}</td>
          <td>{{ tournament.numberOfPlayers }}</td>
          <td>{{ tournament.date }}</td>
          <td>{{ tournament.location }}</td>
          <td>{{ tournament.address }}</td>
          <td>{{ tournament.level }}</td>
          <td>{{ tournament.active }}</td>
          <td>{{ tournament.registrationDeadline }}</td>
        </tr>
      </tbody>
    </table>
    <br>
    <input v-model="playerSearchTerm" type="text" placeholder="Search players">
    <table>
      <thead>
        <tr>
          <th>playerId</th>
          <th>username</th>
          <th>name</th>
          <th>age</th>
          <th>city</th>
          <th>state</th>
          <th>wins</th>
          <th>losses</th>
          <th>totalPoints</th>
          <th>points per game</th>
          <th>right or Left Handed</th>
          
        </tr>
      </thead>
      <tbody>
        <tr v-for="player in playersToShow" :key="player.playerId">
          <td>{{ player.playerId }}</td>
          <td>{{ player.userName }}</td>
          <td>{{ player.name }}</td>
          <td>{{ player.age }}</td>
          <td>{{ player.city }}</td>
          <td>{{ player.state }}</td>
          <td>{{ player.wins }}</td>
          <td>{{ player.losses }}</td>
          <td>{{ player.totalPoints }}</td>
          <td>{{ player.ppg }}</td>
          <td>{{ player.rightOrLeftHanded }}</td>
        </tr>
      </tbody>
    </table>
    <br>
    <input v-model="hostSearchTerm" type="text" placeholder="Search hosts">
    <table>
      <thead>
        <tr>
          <th>HostId</th>
          <th>name</th>
          <th>description</th>
          <th>city</th>
          <th>state</th>
          <th>username</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="host in hostsToShow" :key="host.id">
          <td>{{ host.id }}</td>
          <td>{{ host.hostName }}</td>
          <td>{{ host.description }}</td>
          <td>{{ host.city }}</td>
          <td>{{ host.state }}</td>
          <td>{{ host.userName }}</td>
        </tr>
      </tbody>
    </table>
    <br>
    <input v-model="teamSearchTerm" type="text" placeholder="Search Teams">
    <table>
      <thead>
        <tr>
          <th>teamId</th>
          <th>team name</th>
          <th>description</th>
          <th>address</th>
          <th>city</th>
          <th>state</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="team in teamsToShow" :key="team.id">
          <td>{{ team.id }}</td>
          <td>{{ team.teamName }}</td>
          <td>{{ team.teamDescription }}</td>
          <td>{{ team.address }}</td>
          <td>{{ team.city }}</td>
          <td>{{ team.state }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import tournament from '../services/TournamentService.js';


export default {
  data() {
    return {
      tournaments: [],
      tournamentSearchTerm: '',
      players: [],
      playerSearchTerm: '',
      hosts: [],
      hostSearchTerm: '',
      teams: [],
      teamSearchTerm: ''
    };
  },
  methods: {
    createTournamentButton() {
      this.$router.push(`/createtournament`);
    }
  },

  created() {
    tournament.listTournaments().then(response => {
      this.tournaments = response.data;
    });
    tournament.getPlayers().then(response => {
      this.players = response.data;
    });
    tournament.getHosts().then(response => {
      this.hosts = response.data;
    });
    tournament.getTeams().then(response =>{
      this.teams = response.data;
    });
  },
  computed: {
    tournamentsToShow() {
      if (this.tournamentSearchTerm.trim() === '') {
        return this.tournaments;
      } else {
        return this.tournaments.filter(tournament =>
          tournament.name.toLowerCase().includes(this.tournamentSearchTerm.toLowerCase())
        );
      }
    },
    playersToShow() {
      if (this.playerSearchTerm.trim() === '') {
        return this.players;
      } else {
        return this.players.filter(player =>
          player.name.toLowerCase().includes(this.playerSearchTerm.toLowerCase())
        );
      }
    },
    hostsToShow() {
      if (this.hostSearchTerm.trim() === '') {
        return this.hosts;
      } else {
        return this.hosts.filter(host =>
          host.hostName.toLowerCase().includes(this.hostSearchTerm.toLowerCase())
        );
      }
    },
    teamsToShow() {
      if (this.teamSearchTerm.trim() === '') {
        return this.teams;
      } else {
        return this.teams.filter(team =>
          team.teamName.toLowerCase().includes(this.teamSearchTerm.toLowerCase())
        );
      }
    },
  }
};
</script>

<style scoped >
  /* Center the content in the component */
  div {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  /* Style the "Create a Tournament!" button */
  button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 12px 28px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin-bottom: 20px;
    border-radius: 10px;
  }

  /* Style the search inputs */
  input[type="text"] {
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
    margin-bottom: 20px;
    width: 300px;
  }

  /* Style the tables */
  table {
    border-collapse: collapse;
    width: 80%;
  }

  th, td {
    text-align: left;
    padding: 8px;
  }

  th {
    background-color: #4CAF50;
    color: white;
  }

  tr:nth-child(even) {
    background-color: #f2f2f2;
  }
</style>