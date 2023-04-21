<template>
  <div id="generate-bracket">
      <div id="control">
       <button class="btn btn-primary" v-on:click="shuffleArray(players)">shuffle</button>
      <button class="btn btn-secondary" v-on:click="generateBracket">Generate</button>
      </div>
  <div class="tournament-bracket">
    
      <div v-for="(tier, tierId) in updateTournament"  v-bind:key="tierId" class="round">
            <h2>Round: {{tierId+1}}</h2>
        
            <div v-for="(match,matchId) in tier"  v-bind:key="matchId" class="match">
                <div v-on:click="toggleDisplayMatchWinner(match,$event)">
                
                        <div v-for="(player, playerId) in match"  v-bind:key="playerId"  class="player" >
                          <div class = "individual_player">{{ (player !== 0 ? player.playerName : "......" )}} </div>
                            <!-- <div class = "individual_player">{{ (player !== 0 ? player.playerName : "......" )}} <div class = "score>">Score: {{player.score}}</div></div>
                             -->
       
                            
                </div>
                </div>
       </div>
           </div>
       </div> 
       <div class = "round">

         </div>
       <div v-if="displayMatchWinner" class="modal">
           <h2> Choose a Winner </h2>
           <button class="button" id="player1" v-on:click="addWinningPlayer(playersInMatch[0])"> {{playersInMatch[0].playerName}} </button>
           <button class="button" id="player2" v-on:click="addWinningPlayer(playersInMatch[1])"> {{playersInMatch[1].playerName}} </button>
           <!-- <h3> {{playersInMatch[0].playerName}} Score: {{playersCurrentScore}} <button v-on:click="addScore(playersInMatch,playersInMatch[0])">+</button></h3>
           <h3> {{playersInMatch[1].playerName}} Score: {{playerTwoCurrentScore}} <button v-on:click="addScore(playersInMatch,playersInMatch[1])">+</button></h3> -->

           
           
        </div>
        <div v-if="displayMatchWinner" class="overlay"></div>
               <!-- <li v-for="todo in $store.state.todos" v-bind:key="todo.name"  v-bind:class="{ 'todo-completed': todo.done }"> -->

  </div>
</template>

<script>
import tournamentPlayers from '../services/TournamentService.js'
export default {
data() {
      return {
        matchid:[],
       name: "oddBracket",
       tournament_id:"",
       players:[],
       tournament: [],      
       displayMatchWinner:false,
       playersInMatch:"",
       winningPlayer:"",
       score: 0,
       playerTwoScore:0,
       lastplayerclicked: "",
        }        
      },
computed:{
     updateTournament(){
   return this.tournament
     },
     playersCurrentScore(){
       return this.score; 
     },
     playerTwoCurrentScore(){
       return this.score; 
     }
},
created(){
this.generateBracket();
},

      

methods: {
    getAllPlayers(){
    tournamentPlayers.getPlayersInTournament(this.$route.params.id).then((response)=>{
       if(response.status === 200){
           this.players = response.data;
       }
    }).catch(error => {
          if (error.response.status === 404) {
            this.$router.push("/404");
          } else {
            console.error(error);
          }
        });
    },
     shuffleArray(array) {
  // Loop through the array from the end to the start
  for (let i = array.length - 1; i > 0; i--) {
    // Generate a random index from 0 to i
    const j = Math.floor(Math.random() * (i + 1));
    // Swap the elements at indexes i and j
    [array[i], array[j]] = [array[j], array[i]];
  }
  return array;
},
    addScore(match,player){
      if(match[0]==player){
      this.score = player.score;
      }
      if(match[1]==player){
        console.log("I'm player two")
        this.secondPlayerScore = player.score
      }
      console.log(player.playerName +"i'm in score")
      
    player.score++;
    },
    getPlayerInTournament(){
        let a =2;
        a;
    },
    toggleDisplayMatchWinner(match, event){
      this.lastplayerclicked = event.currentTarget;
      console.log(this.lastplayerclicked);
    this.displayMatchWinner = !this.displayMatchWinner;
        this.playersInMatch = match;
    },
addWinningPlayer(player){
 // player.score=0;
    //change winning player color
    var matchPlayers = this.lastplayerclicked.getElementsByClassName("individual_player");
    if(matchPlayers[0].innerText.includes(player.playerName)){
      matchPlayers[0].classList.add("winner");
    }
    else{
      matchPlayers[1].classList.add("winner");
    }
    
    this.winningPlayer = player.playerName;
     let win = player;
let found = false;
this.displayMatchWinner = !this.displayMatchWinner;
for (let i = 1; i < this.tournament.length; i++) {
  for (let j = 0; j < this.tournament[i].length; j++) {
    let element = this.tournament[i][j];
    let index = element.indexOf(0);
    if (index !== -1) {
      this.tournament[i][j][index] = win;
      found = true;
       

      break;
    }
  }
  if (found) {
       

    break;
  }
     
}
     
},


addScoreToPlayer(){
  console.log("I'm in addScoreToPlayer")
this.players.forEach(element => {
  element.score = this.score;
});
},
    generateBracket(){
      this.getAllPlayers();
      console.log("I'm in the bracket")
      this.addScoreToPlayer();
        var perfectBrackets = [2, 4, 8, 16, 32, 64];
var playerList = this.players;

var tiers = [];
var numOfPlayers = playerList.length;
var highestValue = null;

for (let i = 0; i < perfectBrackets.length; i++) {
  if (
    perfectBrackets[i] < numOfPlayers &&
    (highestValue === null || perfectBrackets[i] > highestValue)
  ) {
    highestValue = perfectBrackets[i];
  }
}

var numOfFirstTierPlayers = (numOfPlayers - highestValue) * 2;

var j = 0;
var localHighestValue = highestValue;
var q =0;
var p=0;
//generates tiers

for (let i = highestValue; i >= 1; i /= 2) {
  tiers.push([]);
  if (j === 0) {
    for (let x = 0; x < numOfFirstTierPlayers; x += 2) {
      tiers[j].push([0, 0]);
    }
  }
  if (j >= 1) {
    for (let z = 0; z < localHighestValue; z += 2) {
      
      if (localHighestValue === 1) {
        tiers[j].push([0,0]);
      } else {
        tiers[j].push([0, 0]);
      }
    }
  }
  if (j >=1) {
    localHighestValue /= 2;
  }
  j++;
}
//inputs player object
for (let i = 0; i < tiers.length; i ++) {
  console.log(p)
  if(playerList.length % 2 != 0 && p === playerList.length){
      break;
    }
   if(p > playerList.length-1){
      break;
    }
  for(let x=0; x<tiers[i].length; x++){
    
    tiers[i][x][q] = playerList[p];
    p++
    if(playerList.length % 2 != 0 && p === playerList.length){
      break;
    }
    tiers[i][x][q+1] = playerList[p];
    p++
    q=0
    if(p > playerList.length-1){
      break;
    }
    
  }
  //Adds winning player
 
}

this.tournament = tiers;
    }
}


}
</script>

<style>
#generate-bracket {
  background: linear-gradient(to bottom, #DAE8F2, #ffffff);
  height: 100vh;
}
h2 {
  font-size: 2rem;
}
.tournament-bracket{
     margin:20px;
     padding: 10px;
    border-radius:5px;
    display:flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    
   
}
.round{
    
     margin:20px;
     padding: 10px;
     
 
}
.match{
   
    margin:20px;
}

.individual_player{
    background: linear-gradient(to bottom, #00ADEE, #DAE8F2);
    text-align: center;
    font-weight: bold;
    font-size: 1.5rem;
     border-radius:5px;
     padding: 30px;
     margin:5px;
     box-shadow: 0 2px 4px rgba(0,0,0,0.15), 0 4px 8px rgba(0,0,0,0.15) ;
}
.winner{
    background: linear-gradient(to bottom, #45e27a, #DAE8F2);

}
.modal{
    position: fixed;
    top: 50%;
    left:50%;
    transform: translate(-50%,-50%);
    z-index: 100;
    background-color:white;
    padding:20px;
    border-radius: 5px;
    box-shadow: 0px 0px 10px rgba(0,0,0,0.5);
}
.button{
  display: inline-block;
  padding: 1rem 2rem;
  border: none;
  border-radius: 0.25rem;
  text-align: center;
  text-decoration: none;
  font-size: 1rem;
  font-weight: bold;
  color: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  transition: background-color 0.3s ease-in-out;
  cursor: pointer;
  margin: 10px
}
#player1 {
  background-color: #71D96F;
}
#player2 {
  background-color: #FF6359;
}
#control {
  display: flex;
  justify-content: center;
  align-items: center;
}
.btn {
  display: inline-block;
  padding: 1rem 2rem;
  border: none;
  border-radius: 0.25rem;
  text-align: center;
  text-decoration: none;
  font-size: 1rem;
  font-weight: bold;
  color: #fff;
  background-color: #FF6359;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  transition: background-color 0.3s ease-in-out;
  cursor: pointer;
}

.btn:hover {
  background-color: #4d565e;
}

.btn-primary {
  background-color: #FF6359;
  margin: 0.5rem;

}

.btn-secondary {
  background-color: #71D96F;
  margin: 0.5rem;  

}
/* .overlay{
    position: fixed;
    top:0;
    left:0;
    width:100%;
    height:100%;
    z-index: 99;
    background-image: linear-gradient(to bottom right, rgba(255,255,255,0.2),rgba(255,255,255,0.2));
    backdrop-filter: blur(10px);

} */
 /* .tournament-bracket {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  height: 100%;
}

.tournament-tier {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
  flex-grow: 1;
  margin: 0 20px;
  width: 100%;
}

.tournament-match {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  margin: 10px 0;
  position: relative;
  width: 100%;
}

.tournament-player {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 30px;
  margin: 5px 0;
  background-color: #fff;
  border: 1px solid #000;
  font-size: 16px;
  font-weight: bold;
  text-align: center;
  color: #000;
}

.tournament-player:before {
  content: "";
  position: absolute;
  top: 50%;
  left: -5px;
  transform: translateY(-50%);
  width: 5px;
  height: 100%;
  background-color: #000;
}

.tournament-player:last-child:before {
  display: none;
}

.tournament-player:after {
  content: "";
  position: absolute;
  top: 50%;
  right: -5px;
  transform: translateY(-50%);
  width: 5px;
  height: 50%;
  background-color: #000;
  z-index: -1;
}

.tournament-player:first-child:after {
  display: none;
}

.tournament-player:nth-child(2n):after {
  height: calc(50% + 1px);
  top: 0;
}

.tournament-player:nth-child(2n+1):after {
  height: calc(50% - 1px);
  bottom: 0;
}

.tournament-player.active {
  background-color: #000;
  color: #fff;
} */
</style>