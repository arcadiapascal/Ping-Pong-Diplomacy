<template>
  <div class="carousel">
    <div class="carousel-inner">
      <div v-for="tournament in tournaments" :key="tournament.tournamentId" :class="{ active: tournament === activeTournament }">
        <h3>{{ tournament.name }}</h3>
        <div class="description">
          <p>{{ tournament.description }}</p>
          <ul>
            <li><strong>Players: </strong>{{ tournament.numberOfPlayers }}</li>
            <li><strong>Date: </strong>{{ tournament.tournamentDate | formatDate }}</li>
            <li><strong>Location: </strong>{{ tournament.address }}, {{ tournament.location }}</li>
            <li><strong>Skill: </strong>{{ tournament.skillLevel }}</li>
          </ul>
        </div>
        <div class="btn-container">
          <router-link :to="'/tournament/'+tournament.tournamentId" id="view-details" class="btn btn-primary">View Details</router-link>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#" role="button" @click.prevent="prevTournament">
  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
</a>
    <a class="carousel-control-next" href="#" role="button" @click.prevent="nextTournament">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
    </a>
  </div>
</template>

<script>
import tournament from '../services/TournamentService.js';

export default {
  name: 'TournamentCarousel',

  data() {
    return {
      tournaments: [],
      currentIndex: 0
    };
  },

  computed: {
    activeTournament() {
      return this.tournaments[this.currentIndex];
    }
  },
  created() {
    tournament.listTournaments().then((response)=> {
        this.tournaments = response.data;
    })
  },

  methods: {
    prevTournament() {
      this.currentIndex = (this.currentIndex === 0) ? this.tournaments.length - 1 : this.currentIndex - 1;
    },
    nextTournament() {
      this.currentIndex = (this.currentIndex === this.tournaments.length - 1) ? 0 : this.currentIndex + 1;
    },
    formatDate(date) {
      const options = { year: 'numeric', month: 'long', day: 'numeric' };
      return new Date(date).toLocaleDateString('en-US', options);
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
}
</script>

<style scoped>

.carousel {
  position: relative;
  margin: 0 auto;
  width: 100%;
  max-width: 100vh;
  height: 40vh;
  background-color: #DAE8F2;
  border-radius: 10px;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.carousel-inner > div {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  opacity: 0;
  transition: opacity 0.6s ease-in-out;
  background-color: #f5f5f5;
  text-align: center;
}

.carousel-inner > div.active {
  opacity: 1;
}

.carousel-inner h3 {
  font-size: 2rem;
  font-weight: bold;
  margin-bottom: 0.5rem;
  color: #222;
}

.carousel-inner p {
  font-size: 1.5rem;
  margin-bottom: 1rem;
  color: #666;
}

.carousel-inner ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.carousel-inner li {
  font-size: 1.25rem;
  margin-bottom: 0.5rem;
  color: #666;
}

.carousel-inner a {
  display: inline-block;
  background-color: #00ADEE;
  color: #DAE8F2;
  padding: 0.5rem 1rem;
  border-radius: 4px;
  text-decoration: none;
  margin-top: 1rem;
  font-size: 1.25rem;
  transition: background-color 0.3s ease-in-out;
}



.carousel-inner .btn {
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
.carousel-inner .btn:hover {
  background-color: #4d565e;
}

.carousel-control-prev,
.carousel-control-next {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: #71D96F;
  color: #4D565E;
  text-align: center;
  font-size: 1.5rem;
  line-height: 1.2;
  transition: background-color 0.3s ease-in-out, color 0.3s ease-in-out, box-shadow 0.3s ease-in-out;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  display: flex;
  justify-content: center;
  align-items: center;
}

.carousel-control-prev:hover,
.carousel-control-next:hover{
  background-color: #4d565e;
  color: #DAE8F2;
  box-shadow: 0px 2px 20px rgba(0, 0, 0, 0.3);
}

.carousel-control-prev {
  left: 0;
  margin-left: 20px;
}

.carousel-control-next {
  right: 0;
  margin-right: 20px;
}

.carousel-control-next .carousel-control-next-icon {
  display: inline-block;
  margin-left: 5px;
  width: 0;
  height: 0;
  border-top: 10px solid transparent;
  border-bottom: 10px solid transparent;
  border-left: 10px solid #DAE8F2;
}

.carousel-control-prev .carousel-control-prev-icon {
  display: inline-block;
  margin-right: 5px;
  width: 0;
  height: 0;
  border-top: 10px solid transparent;
  border-bottom: 10px solid transparent;
  border-right: 10px solid #DAE8F2;
}


</style>