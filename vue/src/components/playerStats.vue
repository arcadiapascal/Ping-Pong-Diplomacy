<template>
  <div class="box">
    <h2 class="heading">Player Stats</h2>
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

.player-stats {
    width: 66vh;
}

h2 {
  text-align: center;
}

.box {
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  font-family: inherit;
  padding: 20px;
  margin: 1vh;
  height: 27vh;
}

/* Table styles */
.table-container {
  display: table;
  width: 50vh;
  border-collapse: collapse;
}

.table-row-header {
  align-items: center;
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
