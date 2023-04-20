<template>
  <div class="bracket">
     <h2>Round: {{ round }} </h2>
    <div v-for="pair in filteredPairs" :key="pair[0].id" class="player-bracket">
      <!-- Generate a bracket for each pair of players -->
      <div class="participant">
        <h2>{{ pair[0].playerName }} vs {{pair[1].playerName}}</h2>
      </div>
      <div class="match">
        <div class="matchup">
          <div class="participant">
            {{ pair[0].playerName }}
            <button @click="addWinner(pair[0], pair[1])">Add winner</button>
            <div class="score" :class="{ winner: pair[0].winner }">{{ pair[0].score }}</div>
          </div>
          <div class="participant">
            {{ pair[1].playerName }}
            <button @click="addWinner(pair[1], pair[0])">Add winner</button>
            <div class="score" :class="{ winner: pair[1].winner }">{{ pair[1].score }}</div>
          </div>
        </div>
      </div>
    </div>
    <button @click="repopulateBracket(), incrimentRound()">Repopulate Bracket</button>
  </div>
</template>

<script>
// import profileService from '../services/ProfileService'
import tournament from '../services/TournamentService';
export default {
  data() {
    return {

      players: [],
      winners: [],
      losers: [],
      playersStats: [],
      round: 1
    }
  },
  
  computed: {
// updateThis(){
  
//     if(this.winners !== null){
     
//     for(let i = 0; i <= this.winners.length; i++){
//       const player = {
//         id: this.winners[i].id,
//         userId: this.winners[i].userId,
//         name: this.winners[i].playerName,
//         wins: this.winners[i].wins + 1,
//         author: this.winners[i].userId,
//         avatar: this.winners[i].stateAbbrev,
//         content: this.winners[i].rightLeftHanded,
//         lastOpened: this.winners[i].email,
//     profileService.update(player.id, player).then((response) => {
//       if(response.status === 200){
//         alert("wINNER INCRIMENTED!")
//       }
//     });
//      }
//     }
  // }
// },


    pairs() {
      // Generate pairs of players from remaining players or winners
      const remainingPlayers = this.players.filter(player => !player.winner && !player.loser);
      const players = remainingPlayers.length > 0 ? remainingPlayers : this.winners;
      const pairs = [];
      for (let i = 0; i < players.length; i += 2) {
        pairs.push([players[i], players[i + 1] || { playerName: 'No Opponent' }]);
      }
      return pairs;
    },


    filteredPairs() {
      // Filter out pairs with winners or losers
      return this.pairs.filter(pair => !pair[0].winner && !pair[1].winner && !pair[0].loser && !pair[1].loser)
      .sort((a, b) => b[0].score - a[0].score); // sort by score in descending order
    }
  },


  mounted() {
    tournament.getPlayers().then((response) => {
      this.players = response.data.map((player) => ({
        ...player,
        score: 0,
        winner: false,
        loser: false
      }));
      this.playersStats = response.data.map((player) => ({
        ...player,
        wins: 0,


losses: 0
}));
});
},


methods: {
incrimentRound(){
  this.round++;
},

addWinner(winningPlayer, losingPlayer) {
// Update winning player's score and winner flag
winningPlayer.score += 1;
winningPlayer.winner = true;
winningPlayer.wins +=1;


  // Update losing player's loser flag
  losingPlayer.loser = true;


  // Add winning player to winners array
  this.winners.push(winningPlayer);


  // Update player stats
  const winningPlayerStats = this.playersStats.find(player => player.id === winningPlayer.id);
  const losingPlayerStats = this.playersStats.find(player => player.id === losingPlayer.id);
  winningPlayerStats.wins += 1;
  losingPlayerStats.losses += 1;
},


repopulateBracket() {
  // Reset all players' scores and winner/loser flags
  this.players.forEach(player => {
    player.score = 0;
    player.winner = false;
    player.loser = false;
  });

  // Repopulate players array with winners
  this.players = [...this.winners];

  // Clear winners and losers arrays
  this.winners = [];
  this.losers = [];
}
}
}
</script>
<style scoped>
  .bracket {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    margin-top: 20px;
  }


  .player-bracket {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 10px;
    border: 2px solid #ccc;
    border-radius: 5px;
    padding: 20px;
    text-align: center;
  }


  .participant {
    background-color: #f2f2f2;
    border-radius: 5px;
    padding: 10px;
    text-align: center;
    width: 150px;
    font-weight: bold;
    margin-bottom: 10px;
  }


  .match {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 10px;
  }


  .matchup {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 150px;
  }


  .score {
    background-color: #4CAF50;
    border-radius: 50%;
    color: white;
    font-weight: bold;
    height: 30px;
    width: 30px;
    display: flex;
    justify-content: center;
    align-items: center;
  }


  .winner {
    background-color: #F44336;
    color: white;
}


button {
margin-left: 5px;
}


</style>