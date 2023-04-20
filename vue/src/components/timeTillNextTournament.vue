<template>
  <div>
    <div>
      <div>
        <p class="timer" v-if="upcomingTournament">{{ countdown }}</p>
        <p v-else>No upcoming tournaments</p>
      </div>
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
        countdown: ''
      };
    },
    created() {
      tournament.listTournaments()
        .then(response => {
          this.tournamentLister = response.data;
          this.upcomingTournament = this.findUpcomingTournament(this.tournamentLister);
          if (this.upcomingTournament) {
            setInterval(() => {
              this.countdown = this.getRemainingTime(this.upcomingTournament.tournamentDate);
            }, 1000);
          }
        });
    },
    methods: {
      getRemainingTime(tournamentDate) {
        const now = new Date();
        const endDate = new Date(tournamentDate);
        const timeRemaining = endDate - now;
        const daysRemaining = Math.floor(timeRemaining / (1000 * 60 * 60 * 24));
        const hoursRemaining = Math.floor((timeRemaining / (1000 * 60 * 60)) % 24);
        const minutesRemaining = Math.floor((timeRemaining / (1000 * 60)) % 60);
        const secondsRemaining = Math.floor((timeRemaining / 1000) % 60);
        return `${daysRemaining} days, ${hoursRemaining} hours, ${minutesRemaining} minutes, ${secondsRemaining} seconds`;
      },
      findUpcomingTournament(tournaments) {
        const now = new Date();
        let upcomingTournament = null;
        let upcomingTournamentDate = Infinity;
        for (let i = 0; i < tournaments.length; i++) {
          const tournamentDate = new Date(tournaments[i].tournamentDate);
          if (tournamentDate > now && tournamentDate < upcomingTournamentDate) {
            upcomingTournament = tournaments[i];
            upcomingTournamentDate = tournamentDate;
          }
        }
        return upcomingTournament;
      },
    },
  };
</script>

<style scoped>
  .timer{
      padding-left: 100px;
  }
</style>