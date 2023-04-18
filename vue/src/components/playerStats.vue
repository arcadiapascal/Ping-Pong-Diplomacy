<template>
  <div>
    <h2>Player Stats</h2>
    <div class="table-container">
      <div class="table-row header">
        <div class="table-cell">Rank</div>
        <div class="table-cell">Username</div>
        <div class="table-cell">Wins</div>
        <div class="table-cell">Losses</div>
        <div class="table-cell">Total Points</div>
        <div class="table-cell">PPG</div>
      </div>
      <div v-if="player" class="table-row">
        <div class="table-cell">{{ player.rank }}</div>
        <div class="table-cell">{{ player.userName }}</div>
        <div class="table-cell">{{ player.wins }}</div>
        <div class="table-cell">{{ player.losses }}</div>
        <div class="table-cell">{{ player.totalPoints }}</div>
        <div class="table-cell">{{ player.ppg }}</div>
      </div>
      <div v-if="!player" class="no-results">Player not found.</div>
    </div>
  </div>
</template>

<script>
export default {
props: {
playerId: {
type: Number,
required: true
}
},

data() {
return {
player: null,
};
},

mounted() {
this.$store.state.player.id
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