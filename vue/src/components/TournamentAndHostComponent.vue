<template>
  <div id="tournament-and-host">
    <h2 class="heading">Tournaments</h2>
    <div class="search-bar-container">
      <input type="text" placeholder="Search Tournaments" class="search-bar" v-model="tournamentSearchTerm" />
    </div>
    <div style="margin: 0 auto">
      <time-till-next-tournament/>
    </div>
    <div class="tournament-cards-container">
      <a v-for="tournament in tournamentsToShow" :key="tournament.id" :href="'/tournament/' + tournament.tournamentId" 
      class="tournament-card" :style="{ backgroundImage: tournament.image ? 'url(' + tournament.image + ')' : tournamentPhotoStyle }">
        <h3>{{ tournament.name }}</h3>
        <p class="tournament-description">{{ tournament.description }}</p>
        <div class="tournament-details">
          <p id="Skill"><strong>Skill Level:</strong><br> {{ tournament.skillLevel }}</p>
          <p id="Location"><strong>Location:</strong><br> {{ tournament.location }}</p>
          <p id="Date"><strong>Date/Time:</strong><br> {{ tournament.tournamentDate | formatDate }}</p>
          <p id="Players"><strong>Current Size:</strong><br> {{ tournament.numberOfPlayers }}</p>
        </div>
        <button id="join-tournament" @click="joinTournament(tournament.tournamentId)">Join Tournament!</button>
      </a>
    </div>
  </div>
</template>

<script>
import tournament from '../services/TournamentService.js';
import tournamentPhoto from '../Assets/tournamentPhoto.jpg';
import profileService from '../services/ProfileService.js';
import timeTillNextTournament from '../components/timeTillNextTournament.vue'


export default {
 components:{
   timeTillNextTournament
 },
  data() {
    return {
      tournamentLister: [],
      tournamentSearchTerm: '',
      players: [],
      playersInTournament: []
    };
  },
  created() {
    tournament.listTournaments().then((response) => {
      this.tournamentLister = response.data;
    });
    profileService.getPlayers().then((response) => {
      this.players = response.data;
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
      };
    },
  },

  methods: {
    joinTournament(id) {
      const currentPlayer = this.players.find((player) => player.userId === this.$store.state.user.id);
      if (currentPlayer) {
        tournament.addPlayerToTournament(id, currentPlayer).then(() => {
           this.$router.push(`/tournament/${id}`)
        }).catch(() => {
          
          this.$router.push(`/tournament/${id}`);
          
        });
      } else {
        alert('You are not a registered player');
      }
    }
  },

  filters: {
  formatDate(value) {
    const date = new Date(value);
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const year = date.getFullYear();
    const hours = date.getHours() % 12 || 12;
    const minutes = date.getMinutes();
    const amPm = date.getHours() < 12 ? 'AM' : 'PM';
    return `${month}/${day}/${year} ${hours}:${minutes < 10 ? '0' + minutes : minutes} ${amPm}`;
  }
}

};
</script>

<style scoped>

#tournament-and-host {
  background: linear-gradient(to bottom, #DAE8F2, #ffffff);

}
.heading {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  margin: 2rem;
  font-size: 2.5rem;
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
  background-color: #FFF;
}

.tournament-cards-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}

a {
  text-decoration: none
}

.tournament-card {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: calc(25% - 3vh);
  height: 30vh;
  padding: 3vh;
  margin-bottom: 3vh;
  background: center/cover no-repeat;
  transition: transform 0.3s, box-shadow 0.3s;
  position: relative;
  border-radius: 8px;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
  background-color: #FFF;
}

.tournament-card:hover {
  transform: translateY(-8px);
  box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
}

.tournament-card h3 {
  font-size: 20px;
  font-weight: bold;
  color: #333;
  font-family: inherit;
  position: relative;
  z-index: 2;
}

.tournament-description {
  font-size: 18px;
  color: #333;
  font-family: inherit;
  position: relative;
  z-index: 2;
}

.tournament-details {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 1vh;
}

.tournament-details p {
  margin: 0;
  font-size: 16px;
  font-family: inherit;
  color: #555;
}

.tournament-details p strong {
  color: #333;
  font-weight: bolder;
}

#join-tournament {
  display: inline-block;
  padding: 1rem 2rem;
  border: none;
  border-radius: 0.25rem;
  text-align: center;
  text-decoration: none;
  font-size: 1rem;
  font-weight: bold;
  color: #fff;
  background-color: #71D96F;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  transition: background-color 0.3s ease-in-out;
  cursor: pointer;
}
#join-tournament:hover {
  background-color: #4d565e;

}

#join-tournament:hover {
  background-color: #4d565e;
}

.tournament-details div:first-child p {
  margin-right: 16px;
}

</style>