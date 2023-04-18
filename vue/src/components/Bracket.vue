<template>
  <div>
    <h1>Bracket Generator</h1>

    <button v-for="size in bracketSizes" :key="size" @click="generateBracket(size)">
      {{ size }}-Team Bracket
    </button>
    <h2>Games in the Series</h2>
    <button v-for="series in gameSeriesOptions" :key="series" @click="generateGameSeries(series)">
      {{ series }} Game Series
    </button>
    <div id="bracketContainer" class="bracket">
      <div v-for="(tier, tierIndex) in bracket" :key="tierIndex" class="tier">
        <div v-for="(match, matchIndex) in tier" :key="matchIndex" class="match">
          <div class="team">
            {{ match.team1.name }} ({{ match.team1.score }})
            <!-- <input v-model="match.team1.inputScore" type="number" min="0" max="100" @input="updateScoreInput(tierIndex, matchIndex, 'team1')" /> -->
            <table v-if="isTableVisible">
              <tr v-for="(game, index) in gameSeries" :key="index">
                <td>
                  <input v-model="game.team2Score" type="number" min="0" max="100" />
                </td>
              </tr>
            </table>
          </div>
          <div v-if="match.team2" class="team">
            {{ match.team2.name }} ({{ match.team2.score }})
            <!-- <input v-model="match.team2.inputScore" type="number" min="0" max="100" @input="updateScoreInput(tierIndex, matchIndex, 'team2')" /> -->
            <table v-if="isTableVisible">
              <tr v-for="(game, index) in gameSeries" :key="index">
                <td>
                  <input v-model="game.team1Score" type="number" min="0" max="100" />
                </td>
                
              </tr>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>



<script>
export default {
  data() {
    return {
      // Store the generated bracket and game series data
      bracket: [],
      gameSeries: 1,
      bracketSizes: [4, 8, 16, 32],
      gameSeriesOptions: [1, 3, 5, 7],
      isTableVisible: false
    };
  },
  methods: {
    generateBracket(size) {
      if (size <= 1) {
        console.error("Bracket size must be greater than 1.");
        return;
      }

      let numTeams = size;
      let tiers = [];

      while (numTeams > 1) {
        let tier = [];
        for (let i = 0; i < numTeams; i += 2) {
          let match = {
            team1: { name: "Player " + (i + 1), score: 0, inputScore: null },
            team2: { name: "Player " + (i + 2), score: 0, inputScore: null },
          };
          tier.push(match);
        }
        tiers.push(tier);
        numTeams = Math.ceil(numTeams / 2);
      }

      tiers.push([{ team1: { name: "Winner 1", score: 0, inputScore: null }, team2: null }]);
      this.bracket = tiers;
    },
    generateGameSeries(series) {
      this.gameSeries = series;
      this.isTableVisible = true;
      for (let i = 0; i < this.bracket.length - 1; i++) {
        for (let j = 0; j < this.bracket[i].length; j++) {
          this.bracket[i][j].team1.inputScore = null;
          this.bracket[i][j].team2.inputScore = null;
        }
      }
    },
    updateScoreInput(tierIndex, matchIndex, team) {
      let score = this.bracket[tierIndex][matchIndex][team].inputScore;
      if (score !== null && score !== undefined && score !== "") {
        score = parseInt(score);
        if (isNaN(score)) {
          score = null;
        }
      }
      this.bracket[tierIndex][matchIndex][team].score = score;
    }
  }
};
</script>

<style scoped>
/* Styles for the bracket display */
.bracket {
  display: flex;
  flex-wrap: wrap;
}

.tier {
  flex: 1;
  padding: 20px;
}

.match {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.team {
  margin-bottom: 10px;
  cursor: pointer;
}
</style>

<style scoped>
/* Add your CSS styles here */
body {
  font-family: Arial, sans-serif;
  background-color: #f0f0f0;
}

h1 {
  text-align: center;
}

label {
  font-weight: bold;
}

input[type="number"] {
  width: 80px;
  margin-right: 10px;
}

button {
  margin-top: 10px;
}

#output {
  margin-top: 20px;
  white-space: pre;
  font-family: monospace;
}

.bracket {
  display: flex;
  flex-direction: row; /* Update to display bracket horizontally */
  justify-content: center; /* Update to center align bracket horizontally */
  align-items: center; /* Update to center align bracket vertically */
}

.tier {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-right: 30px; /* Add margin between tiers */
}

.match {
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-bottom: 20px; /* Add margin between matches */
}

.team {
  padding: 5px 10px;
  background-color: #fff;
  border: 1px solid #333;
}

.team::after {
  content: "-";
  margin-left: 10px;
}

.team:last-child::after {
  content: "";
}

</style>

<style scoped>
.team {
  cursor: pointer;
}
</style>








     




