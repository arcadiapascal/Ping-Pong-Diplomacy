<template>
  <div class="countdown-container">
    <div>
      <h1>Time Till Next Tournament</h1>
      <p class="timers" v-if="upcomingTournament">{{ countdown }}</p>
      <p v-else>No upcoming tournaments</p>
    </div>
  </div>
</template>
<script>
  import tournament from '../services/TournamentService.js';
export default {
data() {
return {
tournamentLister: [],
upcomingTournament: null,
countdown: '',
upcomingTournamentDate: Infinity,
now: null
};
},
created() {
this.now = new Date();
tournament.listTournaments()
.then(response => {
this.tournamentLister = response.data;
this.findUpcomingTournament();
if (this.upcomingTournament) {
requestAnimationFrame(this.updateCountdown);
}
});
},
methods: {
updateCountdown() {
this.now = new Date();
this.countdown = this.getRemainingTime(this.upcomingTournament.tournamentDate);
requestAnimationFrame(this.updateCountdown);
},
getRemainingTime(tournamentDate) {
const endDate = new Date(tournamentDate);
const timeRemaining = endDate - this.now;
const daysRemaining = Math.floor(timeRemaining / (1000 * 60 * 60 * 24));
const hoursRemaining = Math.floor((timeRemaining / (1000 * 60 * 60)) % 24);
const minutesRemaining = Math.floor((timeRemaining / (1000 * 60)) % 60);
const secondsRemaining = Math.floor((timeRemaining / 1000) % 60);
return `${daysRemaining} days, ${hoursRemaining} hours, ${minutesRemaining} minutes, ${secondsRemaining} seconds`;
},
findUpcomingTournament() {
this.tournamentLister.map(tournament => {
const tournamentDate = new Date(tournament.tournamentDate);
if (tournamentDate > this.now && tournamentDate < this.upcomingTournamentDate) {
this.upcomingTournament = tournament;
this.upcomingTournamentDate = tournamentDate;
}
});
},
},
};
</script>

<style scoped>

  .countdown-container {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  margin-bottom: 5vh;
  }
  h1 {
    color: #4D565E;
    font-size: 30px;
    /* #00ADE */
  }
  .timers {
    display: inline-block;
    padding: 0.5rem 1rem;
    margin: 0 0.5rem;
    margin-left: 50px;
    border: none;
    border-radius: 0.25rem;
    text-align: center;
    text-decoration: none;
    font-size: 1rem;
    font-weight: bold;
    color: #fff;
    background-color: #4D565E;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
    transition: background-color 0.3s ease-in-out;
  }
</style>