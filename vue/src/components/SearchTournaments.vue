<template>
  <div>
    <button @click="createTournamentButton()">Create a Tournament!</button>
    <input v-model="searchTerm" type="text" placeholder="Search by name">
    <table>
      <thead>
        <tr>
          <th>Category</th>
          <th>id</th>
          <th>Name</th>
          <th>Description</th>
          <th>City</th>
          <th>State</th>
          <th>active</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="result in allResultsToShow" :key="result.id">
          <td>{{ result.category }}</td>
          <td>{{ result.id }}</td>
          <td>{{ result.name }}</td>
          <td>{{ result.description }}</td>
          <td>{{ result.city }}</td>
          <td>{{ result.state }}</td>
          <td>{{ result.active }}</td>
          <td v-show="result.category === 'Tournament' && result.active === true">
      <button @click="joinTournament(result.tournamentId)">Join!</button>
    </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import tournament from '../services/TournamentService.js';
// import { mapState } from 'vuex'

export default {
  data() {
    return {
      tournaments: [],
      players: [],
      hosts: [],
      teams: [],
      searchTerm: '',
    };
  },
  methods: {
    createTournamentButton() {
      this.$router.push(`/createtournament`);
    },
    joinTournament(tournamentId){
      tournament
        .addPlayerToTournament(tournamentId, this.$store.state.player)
        .then(response => {
          if (response.status === 200) {
            this.$router.push(`/browse`);
          }
        })
      
    }

  },
  created() {
    tournament.listTournaments().then(response => {
      this.tournaments = response.data.map(tournament => ({
        category: 'Tournament',
        id: tournament.id,
        name: tournament.name,
        description: tournament.tournamentDescription,
        city: tournament.location,
        state: tournament.state,
        active: tournament.active
      }));
    });
    tournament.getPlayers().then(response => {
      this.players = response.data.map(player => ({
        category: 'Player',
        name: player.playerName,
        description: `Username: ${player.userName}, Age: ${player.age}, Wins: ${player.wins}, Losses: ${player.losses}, Points: ${player.totalPoints}`,
        city: player.city,
        state: player.state
      }));
    });
    tournament.getHosts().then(response => {
      this.hosts = response.data.map(host => ({
        category: 'Host',
        name: host.hostName,
        description: host.description,
        city: host.city,
        state: host.state
      }));
    });
    tournament.getTeams().then(response => {
      this.teams = response.data.map(team => ({
        category: 'Team',
        name: team.teamName,
        description: team.teamDescription,
        city: team.city,
        state: team.state
      }));
    });
  },
  computed: {
    allResultsToShow() {
      const allResults = [...this.tournaments, ...this.players, ...this.hosts, ...this.teams];
      if (this.searchTerm.trim() === '') {
        return allResults;
      } else {
        return allResults.filter(result =>
          result.name.toLowerCase().includes(this.searchTerm.toLowerCase())
        );
      }
    }
  //   ...mapState({
  //   player: state => state.player
  // })

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

