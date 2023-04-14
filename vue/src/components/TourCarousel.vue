<template>
  <div class="carousel">
    <div class="carousel-inner">
      <div v-for="tournament in tournaments" :key="tournament.tournament_id" :class="{ active: tournament === activeTournament }">
        <h3>{{ tournament.tournament_name }}</h3>
        <p>{{ tournament.tournament_description }}</p>
        <ul>
          <li>Number of players: {{ tournament.player_count }}</li>
          <li>Date: {{ tournament.tournament_date }}</li>
          <li>Location: {{ tournament.tournament_address }}, {{ tournament.location }}</li>
          <li>Skill level: {{ tournament.skill_level }}</li>
          <li>Registration deadline: {{ tournament.registration_deadline }}</li>
        </ul>
      </div>
    </div>
    <a class="carousel-control-prev" href="#" role="button" @click.prevent="prevTournament">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#" role="button" @click.prevent="nextTournament">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'TournamentCarousel',
  data() {
    return {
      tournaments: [],
      activeTournament: null,
      currentIndex: 0
    };
  },
  created() {
    axios.get('/tournaments/upcoming')
      .then(response => {
        this.tournaments = response.data;
        this.activeTournament = this.tournaments[this.currentIndex];
      })
      .catch(error => {
        console.log(error);
      });
  },
  methods: {
    prevTournament() {
      this.currentIndex = (this.currentIndex === 0) ? this.tournaments.length - 1 : this.currentIndex - 1;
      this.activeTournament = this.tournaments[this.currentIndex];
    },
    nextTournament() {
      this.currentIndex = (this.currentIndex === this.tournaments.length - 1) ? 0 : this.currentIndex + 1;
      this.activeTournament = this.tournaments[this.currentIndex];
    }
  }
};
</script>

<style scoped>

.carousel {
  position: relative;
  margin: 0 auto;
  width: 100%;
  max-width: 800px;
  height: 400px;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
  overflow: hidden;
}

.carousel-inner {
  position: relative;
  width: 100%;
  height: 100%;
}

.carousel-inner > div {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  opacity: 0;
  transition: opacity 0.6s ease-in-out;
}

.carousel-inner > div.active {
  opacity: 1;
}

.carousel-inner h3 {
  font-size: 2rem;
  font-weight: bold;
  margin-bottom: 0.5rem;
  color: #2B4F60;
}

.carousel-inner p {
  font-size: 1.5rem;
  margin-bottom: 1rem;
  color: #556268;
}

.carousel-inner ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.carousel-inner li {
  font-size: 1.25rem;
  margin-bottom: 0.5rem;
  color: #556268;
}

.carousel-control-prev,
.carousel-control-next {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: #DAE8F2;
  color: #2B4F60;
  text-align: center;
  font-size: 1.5rem;
  line-height: 1.2;
  transition: background-color 0.3s ease-in-out, color 0.3s ease-in-out;
}

.carousel-control-prev:hover,
.carousel-control-next:hover {
  background-color: #2B4F60;
  color: #DAE8F2;
}

.carousel-control-prev {
  left: 20px;
}

.carousel-control-prev .carousel-control-prev-icon {
  display: inline-block;
  margin-right: 5px;
  width: 0;
  height: 0;
  border-top: 10px solid transparent;
  border-bottom: 10px solid transparent;
  border-right: 10px solid #2B4F60;
}

.carousel-control-next {
  right: 20px;
}

.carousel-control-next .carousel-control-next-icon {
  display: inline-block;
  margin-left: 5px;
  width: 0;
  height: 0;
  border-top: 10px solid transparent;
  border-bottom: 10px solid transparent;
  border-left: 10px solid #2B4F60;
}

</style>