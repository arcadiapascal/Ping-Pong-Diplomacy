<template>
  <div>
    <input v-model="searchTerm" type="text" placeholder="Search by name">
    <table>
      <thead>
        <tr>
          <th>Team Name</th>
          <th>Description</th>
          <th>City</th>
          <th>State</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="team in allResultsToShow" :key="team.id">
          <td>{{ team.name }}</td>
          <td>{{ team.description }}</td>
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
      teams: [],
      searchTerm: '',
    };
  },
  created() {
    tournament.getTeams().then(response => {
      this.teams = response.data.map(team => ({
        id: team.id,
        name: team.teamName,
        description: team.teamDescription,
        city: team.city,
        state: team.state,
      }));
    });
  },
  computed: {
    allResultsToShow() {
      if (this.searchTerm.trim() === '') {
        return this.teams;
      } else {
        return this.teams.filter(team =>
          team.name.toLowerCase().includes(this.searchTerm.toLowerCase())
        );
      }
    }
  }
};
</script>

<style scoped>
  /* Center the content in the component */
  div {
    display: flex;
    flex-direction: column;
    align-items: center;
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
    background-color: #00ADEE;
    color: white;
  }

  tr:nth-child(even) {
    background-color: #f2f2f2;
  }
</style>