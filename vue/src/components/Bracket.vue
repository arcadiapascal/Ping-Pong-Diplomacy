<template>
  <div>
    <h1>Bracket Generator</h1>
    <label for="bracketSize">Bracket Size: </label>
    <input type="number" id="bracketSize" v-model="bracketSize" list="bracketsAllowed">
    <datalist id="bracketsAllowed">
      <option value="4"></option>
      <option value="8"></option>
      <option value="16"></option>
      <option value="32"></option>
      <option value="64"></option>
    </datalist>
    <button @click="generateBracketAndDisplay">Generate Bracket</button>
    <pre id="output">{{ bracketOutput }}</pre>
  </div>
</template>
<script>
export default {
  data() {
    return {
      bracketSize: null,
      bracketOutput: ''
    };
  },
  methods: {
    generateBracketAndDisplay() {
      const size = parseInt(this.bracketSize);
      if (size <= 1) {
        this.bracketOutput = "Bracket size must be greater than 1.";
        return;
      }
      let bracket = [];
      let tiers = [];
      let numTeams = size;
      while (numTeams > 1) {
        let tier = [];
        for (let i = 0; i < numTeams; i += 2) {
          let match = {
            team1: "Player " + (i + 1),
            team2: "Player " + (i + 2)
          };
          tier.push(match);
        }
        tiers.push(tier);
        numTeams = Math.ceil(numTeams / 2);
      }
      bracket = tiers[tiers.length - 1];
      // Add final tier with only 1 team
      tiers.push([{ team1: "Winner 1", team2: null }]);
      let bracketOutput = "Bracket:\n";
      for (let i = 0; i < tiers.length; i++) {
        bracketOutput += "Tier " + (i + 1) + ":\n" + JSON.stringify(tiers[i], null, 2) + "\n";
      }
      this.bracketOutput = bracketOutput;
    }
  }
};
</script>

<style scoped>

</style>