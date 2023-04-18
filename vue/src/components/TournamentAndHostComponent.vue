<template>
  <div>
    <div class="search-container">
      <h2>EVENT LIST</h2>
      <input type="text" placeholder="Search Tournaments" v-model="tournamentSearchTerm">
    </div>
    <div class="tournament-card" v-for="tournament in tournamentsToShow" :key="tournament.id" :style="tournament.image ? { backgroundImage: 'url(' + tournament.image + ')' } : tournamentPhotoStyle">
      <h3>{{ tournament.name }}</h3>
      <p class="tournament-description">{{ tournament.description }}</p>
      <div class="tournament-details">
        <div>
          <p><strong>LEVEL:</strong> {{ tournament.level }}</p>
        </div>
        <div>
          <p><strong>DATE &amp; LOCATION:</strong> {{ tournament.date }}, {{ tournament.location }}</p>
        </div>
      </div>
      <button v-on:click="joinTournament(tournament.id, this.player)">Join Tournament!</button>
    </div>
  </div>
</template>

<script>
import tournament from '../services/TournamentService.js';
import tournamentPhoto from '../Assets/tournamentPhoto.jpg';
import store from '../store';
export default {
  data() {
    return {
      tournamentLister: [],
      tournamentSearchTerm: '',
      player: store.state.player
    };
  },
  created() {
    tournament.listTournaments().then((response) => {
      this.tournamentLister = response.data;
    });
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
    joinTournament(tournamentId, player) {
      
      tournament.addPlayerToTournament(tournamentId, player).then(() => {
        
        alert('You have joined the tournament!');
      }).catch((error) => {
       
        alert('Failed to join tournament: ' + error.message);
      }); 
    }
  }
};
</script>

<style scoped>

.search-container {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

input[type="text"] {
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
    margin-bottom: 20px;
    width: 300px;
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

.tournament-card h3 {
  margin: 0;
  font-size: 20px;
  font-weight: bold;
  color: #000;
}

.tournament-description {
  font-size: 14px;
  color: #999;
  margin-bottom: 8px;
}

.tournament-details {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.tournament-details div {
  display: flex;
  align-items: center;
}

.tournament-details p {
  margin: 0;
  font-size: 14px;
  color: #999;
}

.tournament-details p strong {
   font-weight: 700;
}
  </style>
