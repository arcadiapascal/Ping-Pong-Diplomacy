<template>
  
  <div class="container">
    <table id="tblUsers">
      <thead>
        <tr>
          <th>&nbsp;</th>
          <th>Tournament Name</th>
          <th>Tournament Location</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>
            <input type="text" id="tournamentNameFilter" v-model="filter.tournament_name" />
          </td>
          <td>
            <input type="text" id="tournamentLocationFilter" v-model="filter.tournament_address" />
          </td>
        </tr>
      </tbody>

      <tbody>
          <tr v-for="tournament in tournaments" v-bind:key="tournament.tournament_id">
          <td>{{ tournament.tournament_name }}</td>
          <td>{{ tournament.tournament_description }}</td>
          <td>{{ tournament.player_count }}</td>
          <td>{{ Tournament.tournament_date }}</td>
          <td>{{ Tournament.tournament_address }}</td>
          <td>{{ Tournament.skill_level }}</td>
          <td>{{ Tournament.active }}</td>
          <td>{{ Tournament.registration_deadline }}</td>
          </tr>
    </tbody>

    <tbody>
        <tr>
          <td>
            <input type="text" id="playerNameFilter" v-model="filterPlayer.userName" />
          </td>
          <td>
            <input type="text" id="playerLocationFilter" v-model="filterPlayer.city" />
          </td>
        </tr>
      </tbody>
        
</template>

<script>
import ProfileService from '../services/ProfileService';
import TournamentService from '../services/TournamentService';
export default {
    name: 'search-tournaments',
  data() {
    return {
      Tournaments: [],
      players: [],

      filterPlayer: {
          userName: "",
          city: ""
      },

      filter: {
        tournament_name: "",
        tournament_address: ""
             },
        
    }
  },
  created(){
    TournamentService.listTournaments().then(response => {
      this.Tournaments = response.data;
    })

    ProfileService.getProfile().then(response => {
        this.players = response.data;
    })
  },


computed: {
    filteredTournamentList() {
      let filteredTournaments = this.Tournaments;
      if (this.filter.tournament_name != "") {
        filteredTournaments = filteredTournaments.filter((tournament) =>
          tournament.tournament_name
            .toLowerCase()
            .includes(this.filter.tournament_name.toLowerCase())
        );
      }
      if (this.filter.tournament_address != "") {
        filteredTournaments = filteredTournaments.filter((tournament) =>
          tournament.tournament_address
            .toLowerCase()
            .includes(this.filter.tournament_address.toLowerCase())
        );
      }
      return filteredTournaments;
    },

    filteredPlayerList() {
      let filteredPlayers = this.Tournaments;
      if (this.filterPlayer.userName != "") {
        filteredPlayers = filteredPlayers.filter((player) =>
          player.userName
            .toLowerCase()
            .includes(this.filterPlayer.userName.toLowerCase())
        );
      }
      if (this.filterPlayer.city != "") {
        filteredPlayers = filteredPlayers.filter((tournament) =>
          tournament.city
            .toLowerCase()
            .includes(this.filterPlayer.city.toLowerCase())
        );
      }
      return filteredPlayers;
    }
  }
}

</script>

<style>

</style>