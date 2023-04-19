<template>
  <div>
    <h1>Tournament's</h1>
    <div class="search-bar-container">
      <input type="text" placeholder="Search Tournaments" class="search-bar" v-model="tournamentSearchTerm">
    </div>
    <div class="tournament-card" v-for="tournament in tournamentsToShow" :key="tournament.id" :style="tournament.image ? { backgroundImage: 'url(' + tournament.image + ')' } : tournamentPhotoStyle">
      <h1>{{ tournament.name }} </h1>
      <p class="tournament-description">{{ tournament.description }}</p>
      <div class="tournament-details">
        <div>
          <p><strong>LEVEL:</strong> {{ tournament.skillLevel }}</p>
        </div>
        <div>
          <p><strong class="location">LOCATION:</strong> {{ tournament.location }}</p>
          <p><strong class="date">Date:</strong> {{ tournament.tournamentDate.slice(0, 10) }} </p>
        </div>
      </div>
      <button v-on:click="joinTournament">Join Tournament!</button>
    </div>
  </div>
</template>

<script>
import tournament from '../services/TournamentService.js';
import tournamentPhoto from '../Assets/tournamentPhoto.jpg';
import profileService from '../services/ProfileService.js';


// import store from '../store';
export default {
  data() {
    return {
      tournamentLister: [],
      tournamentSearchTerm: '',
      players: [] 
      
    };
  },
  created() {
    tournament.listTournaments().then((response) => {
      this.tournamentLister = response.data;
    });
    profileService.getPlayers().then((response => {
        this.players = response.data;
      }));
  },
  computed: {
    tournamentsToShow() {
      if (this.tournamentSearchTerm.trim() === '') {
        return this.tournamentLister;
      } else {
        return this.tournamentLister.filter((tournament) =>
          tournament.name.toLowerCase().includes(this.tournamentSearchTerm.toLowerCase())
        );
      } 
    },
    tournamentPhotoStyle() {
      return {
        backgroundImage: `url(${tournamentPhoto})`,
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        color: 'black'
      }
    }
  },
  methods: {
    joinTournament(id, player) {
       
       const currentPlayer = this.$store.state.user.id;
      for(let i = 0; i < this.players.length; i++){
        if(this.players[i].userId === currentPlayer){
          player = this.players[i];
        }
      }
      
      tournament.addPlayerToTournament(player.userId, player).then(() => {
        
        alert('You have joined the tournament!');
      }).catch((error) => {
       
        alert('Failed to join tournament: ' + error.message);
      }); 
    }
  }
};
</script>
<style scoped>
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
  }

  .search-bar-container {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    margin-bottom: 2rem;
  }

  .search-bar {
    padding: 0.5rem 1rem;
    border-radius: 5px;
    border: none;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    width: 300px;
    font-size: 1.2rem;
    outline: none;
  }

  .tournament-card {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    width: 98%;
    height: 300px;
    border: 1px solid #e3e3e3;
    padding: 16px;
    margin-bottom: 24px;
    background-color: #fff;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    transition: transform 0.3s, box-shadow 0.3s;
  }

  .tournament-card:hover {
    transform: translateY(-8px);
    box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.1);
  }

  .tournament-card h1 {
    margin: 0;
    font-size: 70px;
    font-weight: bold;
    color: #00ADEE;
    font-family: inherit;
  }

  .tournament-description {
    font-size: 40px;
    color: grey;
    margin-bottom: 8px;
    font-family: inherit;
  }

  .tournament-details {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .tournament-details div {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  .tournament-details div p {
    margin: 0;
    font-size: 20px;
    font-weight: bold;
    color: #00ADEE;
    font-family: inherit;
  }

  .search-bar-container {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    margin-bottom: 2rem;
  }

  .search-bar {
    padding: 0.5rem 1rem;
    border-radius: 5px;
    border: none;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    width: 300px;
    font-size: 1.2rem;
    outline: none;
  }

  .location {
    text-align: center;
    font-weight: bold;
  }

  .date {
    text-align: center;
    font-weight: bold;
  }

  button {
    padding: 10px 15px;
    border: none;
    border-radius: 5px;
    background-color: #00ADEE;
    color: #fff;
    font-size: 1.2rem;
    cursor: pointer;
    transition: background-color 0.3s;
  }

  button:hover {
    background-color: #008bbd;
  }

</style>