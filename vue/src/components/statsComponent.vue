<template>
  <div>
    <h2>Top Paddle Me Players</h2>
    <div class="search-bar-container">
      <input v-model="searchQuery" type="text" placeholder="Search by username..." class="search-bar">
    </div>
    <div class="table-container">
      <div class="table-row header">
        <div class="table-cell">Rank</div>
        <div class="table-cell">Photo</div>
        <div class="table-cell">Username</div>
        <div class="table-cell">Wins</div>
        <div class="table-cell">Losses</div>
        <div class="table-cell">Total Points</div>
        <div class="table-cell">PPG</div>
      </div>
      <div v-for="(player, index) in sortedPlayers" :key="player.id" class="table-row">
        <div class="table-cell">{{ index+1 }}</div>
        <div class="table-cell"><img :src="player.photo" class="player-photo"></div>
        <div class="table-cell">{{ player.userName }}</div>
        <div class="table-cell">{{ player.wins }}</div>
        <div class="table-cell">{{ player.losses }}</div>
        <div class="table-cell">{{ player.totalPoints }}</div>
        <div class="table-cell">{{ player.ppg }}</div>
      </div>
      <div v-if="sortedPlayers.length === 0" class="no-results">No results found.</div>
    </div>
  </div>
</template>
<script>
import tournament from '../services/TournamentService';
import tournamentPhoto from '../Assets/tournamentPhoto.jpg';

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
    return this.players.filter(player => player.userName.toLowerCase().includes(this.searchQuery.toLowerCase()))
      .slice().sort((a, b) => b.wins - a.wins);
  },
    tournamentPhotoStyle() {
      return {
        backgroundImage: `url(${tournamentPhoto})`,
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        color: 'black'
      }
    }
  },
};
</script>
<style>
.search-bar-container {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
  /* Search bar styles */
  input[type="text"] {
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
    margin-bottom: 20px;
    width: 300px;
  }

  /* Table styles */
  .table-container {
    display: table;
    width: 100%;
    border-collapse: collapse;
  }
  .table-row {
    display: table-row;
    background-color: #fff;
    border: 1px solid #ccc;
  }
  .header {
    font-weight: bold;
    background-color: #eee;
  }
  .table-cell {
    display: table-cell;
    padding: 10px;
    text-align: center;
    vertical-align: middle;
  }
  .player-photo {
  width: 80px;
  height: 80px;
  border-radius: 50%;
}
  .no-results {
    text-align: center;
    margin-top: 20px;
  }
</style>