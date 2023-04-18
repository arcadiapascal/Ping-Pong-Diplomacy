<template>
  <div>
    <h2>Teams</h2>
    <div class="search-bar-container">
      <input v-model="searchTerm" type="text" placeholder="Search by name..." class="search-bar">
    </div>
    <div class="table-container">
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
          <tr v-for="(team, index) in allResultsToShow" :key="team.id" :class="index % 2 === 0 ? 'even' : 'odd'">
            <td>{{ team.name }}</td>
            <td>{{ team.description }}</td>
            <td>{{ team.city }}</td>
            <td>{{ team.state }}</td>
          </tr>
        </tbody>
      </table>
      <div v-if="allResultsToShow.length === 0" class="no-results">No results found.</div>
    </div>
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
  /* Global styles */
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
  }

  /* Header styles */
  h2 {
    text-align: center;
    font-size: 2.5rem;
    margin-bottom: 2rem;
  }

  /* Search bar styles */
  .search-bar-container {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    margin-bottom: 2rem;
  }
  .search-bar {
    padding: 0.5rem 1rem;
    border-radius: 5px;
    border: none;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    width: 300px;
    font-size: 1.2rem;
    outline: none;
  }

  /* Table styles */
  .table-container {
    display: table;
    width: 100%;
    border-collapse: collapse;
  }
  table {
    width: 100%;
    border-collapse: collapse;
    margin: auto;
  }
  th, td {
    text-align: left;
    padding: 8px;
  }
  th {
    background-color: #DAE8F2;
  }
  tr.even {
    background-color: #f2f2f2;
  }
  .no-results {
    text-align: center;
    padding: 16px;
    font-size: 1.2rem;
  }
</style>