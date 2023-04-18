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
            <input v-model.number="match.team1.inputScore" type="number" min="0" max="100" @input="updateScoreInput(tierIndex, matchIndex, 'team1')" />
          </div>
          <div v-if="match.team2" class="team">
            {{ match.team2.name }} ({{ match.team2.score }})
            <input v-model.number="match.team2.inputScore" type="number" min="0" max="100" @input="updateScoreInput(tierIndex, matchIndex, 'team2')" />
          </div>
        </div>
      </div>
    </div>
    <!-- Add table structure here -->
   <table v-if="isTableVisible">
  <tr v-for="(game, index) in gameSeries" :key="index">
    <td>
      <input v-model.number="game.team1Score" type="number" min="0" max="100" />
    </td>
    <td>
      <input v-model.number="game.team2Score" type="number" min="0" max="100" />
    </td>
  </tr>
</table>
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
      gameSeriesOptions: [1, 3, 5, 7]
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
      this.isTableVisible = true;
      this.seriesGames = series;
      this.gameSeries = Array.from({ length: series }, () => ({
        team1Score: null,
        team2Score: null
      }));
    },
    updateScore(tierIndex, matchIndex, team) {
      let match = this.bracket[tierIndex][matchIndex];
      if (match[team].score < this.gameSeries && match.team1.score < this.gameSeries && match.team2) {
        match[team].score += 1;
      }
      this.updateNextMatch(tierIndex, matchIndex);
    },
    updateScoreInput(tierIndex, matchIndex, team) {
      let match = this.bracket[tierIndex][matchIndex];
      let inputScore = match[team].inputScore;
        if (inputScore !== null && !isNaN(inputScore) && inputScore >= 0 && inputScore <= 100) {
        match[team].score = inputScore;
      }
      this.updateNextMatch(tierIndex, matchIndex);
    },
    updateNextMatch(tierIndex, matchIndex) {
      let nextTierIndex = tierIndex + 1;
      let nextMatchIndex = Math.floor(matchIndex / 2);

      if (nextTierIndex >= this.bracket.length) {
        return;
      }

      let nextMatch = this.bracket[nextTierIndex][nextMatchIndex];
      let currentMatch = this.bracket[tierIndex][matchIndex];

      if (nextMatch && nextMatch.team1 && !nextMatch.team2) {
        nextMatch.team2 = currentMatch[currentMatch.team1.score > currentMatch.team2.score ? 'team1' : 'team2'];
      }

      this.updateNextMatch(nextTierIndex, nextMatchIndex);
    }
  }
};
</script>

<style scoped>
.team {
  cursor: pointer;
}
</style>







     




<style scoped>
.h1 {
  margin-top: 0;
}

.button {
  margin-top: 10px;
}

.bracket {
  display: flex;
  justify-content: center;
  align-items: center;
}

.tier {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.match {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.team {
  cursor: pointer;
  padding: 5px;
  border: 1px solid #000;
  border-radius: 5px;
  margin-right: 10px;
}
</style>





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







     




<style scoped>
.h1 {
  margin-top: 0;
}

.button {
  margin-top: 10px;
}

.bracket {
  display: flex;
  justify-content: center;
  align-items: center;
}

.tier {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.match {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.team {
  cursor: pointer;
  padding: 5px;
  border: 1px solid #000;
  border-radius: 5px;
  margin-right: 10px;
}
</style>





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







     




<style scoped>
.h1 {
  margin-top: 0;
}

.button {
  margin-top: 10px;
}

.bracket {
  display: flex;
  justify-content: center;
  align-items: center;
}

.tier {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.match {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.team {
  cursor: pointer;
  padding: 5px;
  border: 1px solid #000;
  border-radius: 5px;
  margin-right: 10px;
}
</style>





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







     




<style scoped>
.h1 {
  margin-top: 0;
}

.button {
  margin-top: 10px;
}

.bracket {
  display: flex;
  justify-content: center;
  align-items: center;
}

.tier {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.match {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.team {
  cursor: pointer;
  padding: 5px;
  border: 1px solid #000;
  border-radius: 5px;
  margin-right: 10px;
}
</style>





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