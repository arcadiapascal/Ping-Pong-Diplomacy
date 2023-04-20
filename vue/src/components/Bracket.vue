<template>
  <div class="tournament">
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
  display: flex;
  flex-direction: column;
  align-items: center;
}

.tournament-size {
  margin-bottom: 20px;
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

.match {
  display: flex;
  align-items: center;
  margin: 10px;
}

.matchup {
  display: flex;
  align-items: center;
  margin-right: 10px;
  position: relative;
}

.box {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 40px;
  height: 40px;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: #f0f0f0;
}

.button {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 40px;
  height: 40px;
  border: none;
  border-radius: 4px;
  background-color: #007bff;
  color: #fff;
  cursor: pointer;
}

.button:hover {
  background-color: #0056b3;
}

.round::after {
  content: "";
  display: block;
  width: 0;
  height: 100%;
  border: 1px solid #ccc;
  position: absolute;
  right: -10px;
  top: 0;
  z-index: -1;
}

.round:last-child::after {
  display: none;
}

.matchup::after {
  content: "";
  display: block;
  width: 100%;
  height: 0;
  border: 1px solid #ccc;
  position: absolute;
  bottom: -20px;
  left: 50%;
  z-index: -1;
  transform: translateX(-50%);
}

.matchup:last-child::after {
  display: none;
}

.matchup span {
  padding: 8px 10px;
  background-color: #f0f0f0;
  border-radius: 4px;
}

.matchup input {
  padding: 6px 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  padding: 6px 10px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
