<template>
  <div class="bracket-container">
    <div class="tier">
      <div class="match">
        <div class="team team1">
          <input type="text" v-model="team1Name" @input="updateWinner">
        </div>
        <div class="team team2">
          <input type="text" v-model="team2Name" @input="updateWinner">
        </div>
      </div>
    </div>
    <div class="winner">
      Winner: {{ winner }}
    </div>
  </div>
</template>

<script>
export default {
  name: 'Bracket',
  data() {
    return {
      team1Name: '',
      team2Name: '',
      winner: '',
    };
  },
  methods: {
    updateWinner() {
      if (this.team1Name && this.team2Name) {
        this.winner = this.team1Name.length > this.team2Name.length ? this.team1Name : this.team2Name;
      } else {
        this.winner = '';
      }
    },
  },
}
</script>

<style scoped>
.bracket-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-family: Arial, sans-serif;
}

.tier {
  display: flex;
  justify-content: center;
  gap: 1rem;
  margin-bottom: 1rem;
}

.match {
  display: flex;
  gap: 1rem;
}

.team {
  padding: 0.5rem;
  background-color: #f0f0f0;
  border: 1px solid #000;
  border-radius: 4px;
  flex: 1;
}

.team input {
  width: 100%;
  border: none;
}

.team input:focus {
  outline: none;
}

.team .team1 {
  border-right: none;
}

.team .team2 {
  border-left: none;
}

.team input[type="number"] {
  width: 3rem;
}

.winner {
  background-color: #c0e2c0;
}
</style>
