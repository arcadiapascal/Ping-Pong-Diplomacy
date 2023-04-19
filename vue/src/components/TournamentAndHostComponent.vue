<template>
  <div>
    <h1 class="heading">Tournaments</h1>
    <div class="search-bar-container">
      <input type="text" placeholder="Search Tournaments" class="search-bar" v-model="tournamentSearchTerm">
    </div>
    <div class="tournament-cards-container">
      <div class="tournament-card" v-for="tournament in tournamentsToShow" :key="tournament.id" :style="tournament.image ? { backgroundImage: 'url(' + tournament.image + ')' } : tournamentPhotoStyle">
        <h3>{{ tournament.name }}</h3>
        <p class="tournament-description">{{ tournament.description }}</p>
        <div class="tournament-details">
          <div>
            <p><strong>LEVEL:</strong> {{ tournament.skillLevel }}</p>
          </div>
          <div>
            <p><strong>DATE &amp; LOCATION:</strong> {{ tournament.date }}, {{ tournament.location }}</p>
          </div>
        </div>
        <button v-on:click="joinTournament">Join Tournament!</button>
      </div>
    </div>
  </div>
</template>

<script>
import tournament from '../services/TournamentService.js';
import tournamentPhoto from '../Assets/tournamentPhoto.jpg';


// import store from '../store';
export default {
  data() {
    return {
      tournamentLister: [],
      tournamentSearchTerm: '',
      player: this.$store.state.player
      
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
    joinTournament(id, player) {
      id = 1;
      
      tournament.addPlayerToTournament(id, player).then(() => {
        
        alert('You have joined the tournament!');
      }).catch((error) => {
       
        alert('Failed to join tournament: ' + error.message);
      }); 
    }
  }
};
</script>

<style scoped>

.heading {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  margin: 2rem;
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

.tournament-cards-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
}

.tournament-card::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0,0,0,0.5);
  z-index: 1;
}

.tournament-card {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: calc(25% - 16px);
  height: 300px;
  padding: 16px;
  margin-bottom: 24px;
  background: center/cover no-repeat;
  transition: transform 0.3s, box-shadow 0.3s;
  margin-right: 16px;
  position: relative;
}

.tournament-card:nth-child(4n) {
  margin-right: 0;
}

.tournament-card:hover {
  transform: translateY(-8px);
  box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.1);
}

.tournament-card h3, .tournament-description {
  margin: 0;
  font-size: 20px;
  font-weight: bold;
  color: #fff;
  font-family: inherit;
  position: relative;
  z-index: 2;
}

.tournament-details {
  color: #fff;
}

.tournament-details div p {
  margin: 0;
  font-size: 20px;
  font-weight: bold;
  font-family: inherit;
  color: #fff;
}

.tournament-details div:first-child p {
  margin-right: 16px;
}

</style>
