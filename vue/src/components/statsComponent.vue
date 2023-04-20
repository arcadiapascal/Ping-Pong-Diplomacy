<template>
  <div>
    <h2>Top Players</h2>
    <div class="search-bar-container">
      <input v-model="searchQuery" type="text" placeholder="Search by username..." class="search-bar">
    </div>
    <div class="table-container">
      <div class="table-row header">
        <div class="table-cell">Rank</div>
        <div class="table-cell">Username</div>
        <div class="table-cell">Wins</div>
        <div class="table-cell">Losses</div>
        <div class="table-cell">PPG</div>
        <div class="table-cell">Win Percentage</div>
        <div class="table-cell">Total Points</div>
      </div>
      <div v-for="(player, index) in sortedPlayers" :key="player.id" class="table-row">
        <div class="table-cell">{{ index+1 }}</div>
        <div class="table-cell">{{ player.playerName }}</div>
        <div class="table-cell">{{ player.wins }}</div>
        <div class="table-cell">{{ player.losses }}</div>
        <div class="table-cell">{{calculatePointsPerGame(player.totalPoints, player.wins, player.losses).toFixed(0)}}</div>
        <div class="table-cell">{{calculateWinPercentage(player.wins, player.losses)}}%</div>
        <div class="table-cell">{{ player.totalPoints }}</div>
      </div>
      <div v-if="sortedPlayers.length === 0" class="no-results">No results found.</div>
    </div>
  </div>
</template>

<script>
import tournament from '../services/TournamentService';
// import tournamentPhoto from '../Assets/tournamentPhoto.jpg';
export default {
  data() {
    return {
      players: [],
      searchQuery: '',
    };
  },

  mounted() {
    tournament.getPlayers().then((response) => {
      this.players = response.data;
    });
  },

  computed: {
    sortedPlayers() {
      if (this.searchQuery === '') {
        return this.players.slice().sort((a, b) => b.wins - a.wins);
      }
      return this.players.filter(player => player.playerName.toLowerCase().includes(this.searchQuery.toLowerCase()))
        .slice().sort((a, b) => b.wins - a.wins);
    },
  },

  methods: {
    calculatePointsPerGame(totalPoints, wins, losses) {
      return totalPoints / (wins + losses);
    },
    calculateWinPercentage(wins, losses) {
      return ((wins / (wins + losses)) * 100).toFixed(0);
    }
  },
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
  .table-row {
    display: table-row;
    border: 1px solid #ccc;
  }
  .header {
    font-weight: bold;
    background-color: #DAE8F2;
  }
  .table-cell {
    display: table-cell;
    padding: 1rem;
    text-align: center;
    vertical-align: middle;
  }
  .no-results {
    text-align: center;
    margin-top: 20px;
  }
  /* New styles for the World Table Tennis website */
  .players-table {
    width: 100%;
  }
  .players-table .table-row.header {
    background-color: #0D1C2E;
    color: #fff;
  }
  .players-table .table-cell {
    padding: 0.8rem;
  }
  .players-table .table-cell:nth-child(1),
  .players-table .table-cell:nth-child(2) {
    width: 30%;
  }
  .players-table .table-cell:nth-child(3),
  .players-table .table-cell:nth-child(4),
  .players-table .table-cell:nth-child(5) {
    width: 20%;
  }
  .players-table .table-cell:nth-child(1) {
    text-align: left;
  }
  .players-table .table-cell:nth-child(2) {
    text-align: center;
  }
  .players-table .table-cell:nth-child(3),
  .players-table .table-cell:nth-child(4),
  .players-table .table-cell:nth-child(5) {
    text-align: right;
  }
  .players-table .table-cell:nth-child(1) a {
    color: #0D1C2E;
    text-decoration: none;
  }
  .players-table .table-cell:nth-child(1) a:hover {
    color: #FDB913;
  }
</style>