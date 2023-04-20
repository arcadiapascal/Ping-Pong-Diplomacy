<template>
  <div class="tournament">
    <h2>Quick Tournament</h2>
    <div class="tournament-size">
      <label>Select Bracket Size:</label>
      <select v-model="size" @change="createBracket">
        <option v-for="option in options" :key="option.value" :value="option.value">{{ option.label }}</option>
      </select>
    </div>
    <div class="tournament-bracket">
      <div v-for="(round, index) in bracket" :key="index" class="round">
        <h3>Round {{ index + 1 }}</h3>
        <div v-for="player in round" :key="player.id" class="player">
          <div class="matchup">
            <span v-if="player.winner">{{ player.winner }}</span>
            <input v-else type="text" v-model="player.name">
            <input type="number" v-model="player.points" min="0" step="1">
          </div>
          <button v-if="!player.winner" @click="movePlayerToNextBracket(round, player)">Won the Match!</button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      options: [
        { label: '2 Players', value: 2 },
        { label: '4 Players', value: 4 },
        { label: '8 Players', value: 8 },
        { label: '16 Players', value: 16 },
        { label: '32 Players', value: 32 },
        { label: '64 Players', value: 64 },
      ],
      size: 2,
      bracket: [],
    }
  },
  methods: {
    createBracket() {
      let players = [];
      for (let i = 0; i < this.size; i++) {
        players.push({ id: i, name: '', winner: null, points: 0 });
      }
      this.bracket = [players];
      let round = 2;
      while (players.length > 1) {
        players = [];
        for (let i = 0; i < this.bracket[round - 2].length; i += 2) {
          players.push({ id: i, name: '', winner: null, points: 0 });
        }
        this.bracket.push(players);
        round++;
      }
    },
    movePlayerToNextBracket(currentRound, player) {
      const currentRoundIndex = this.bracket.findIndex(round => round === currentRound);
      const nextRoundIndex = currentRoundIndex + 1;
      if (nextRoundIndex >= this.bracket.length) {
        player.winner = player.name;
      } else {
        const nextRound = this.bracket[nextRoundIndex];
        const playerIndex = currentRound.findIndex(p => p === player);
        const nextPlayerIndex = Math.floor(playerIndex / 2);
        nextRound[nextPlayerIndex].name = player.name;
        nextRound[nextPlayerIndex].points = player.points;
      }
    },
  },
  watch: {
    size() {
      this.createBracket();
    }
  },
  mounted() {
    this.createBracket();
  }
}
</script>

<style scoped>
.tournament {
  margin-top: 5vh;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.tournament-size {
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-bottom: 10px;
}

.tournament-size label {
  margin-right: 10px;
  font-size: 14px;
  font-weight: bold;
  text-transform: uppercase;
}

.tournament-size select {
  padding: 5px 10px;
  border: none;
  border-radius: 4px;
  background-color: #f0f0f0;
  font-size: 14px;
}

.tournament-bracket {
  display: flex;
  justify-content: center;
}

.round {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-right: 20px;
}

.round h3 {
  margin: 0;
  font-size: 16px;
  font-weight: bold;
  text-transform: uppercase;
  color: #606060;
}

.player {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 10px;
}

.matchup {
  display: flex;
  align-items: center;
  margin-right: 10px;
  position: relative;
}

.matchup::before {
  content: "";
  display: block;
  width: 1px;
  height: 100%;
  background-color: #ccc;
  position: absolute;
  left: -5px;
  top: 0;
}

.matchup span {
  padding: 8px 10px;
  border-radius: 4px;
  font-size: 14px;
  font-weight: bold;
  background-color: #f0f0f0;
}

.matchup input {
  padding: 6px 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 14px;
  font-weight: bold;
  color: #606060;
}

.button {
  display: flex;
}

.viewport {
  height: 100vh;
  background-color: #f7f7f7;
  display: flex;
  justify-content: center;
  align-items: center;
}

.viewport.modern {
  background-color: #ececec;
}

.viewport.modern-dark {
  background-color: #121212;
  color: #f7f7f7;
}

.winners .player:nth-child(2n) .matchup {
  flex-direction: row-reverse;
}

.winners .player:nth-child(2n) .matchup::before {
  left: auto;
  right: -5px;
}

.winners .player:nth-child(2n) .matchup span {
  background-color: #fff;
  color: #606060;
}

.winners .player:nth-child(2n) .matchup input {
  color: #f7f7f7;
}

.winners .player:nth-child(2n) .matchup input:focus {
  background-color: #f7f7f7;
  color: #606060;
}
</style>