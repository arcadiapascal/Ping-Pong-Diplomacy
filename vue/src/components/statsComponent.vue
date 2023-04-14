<template>
  <div>
      <h1>Top 10 Paddle Me Players</h1>
    <table>
      <thead>
        <tr>
          <th>playerId</th>
          <th>username</th>
          <th>name</th>
          <th>age</th>
          <th>city</th>
          <th>state</th>
          <th>wins</th>
          <th>losses</th>
          <th>totalPoints</th>
          <th>points per game</th>
          <th>right or Left Handed</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="player in sortedPlayers" :key="player.id">
          <td>{{ player.playerId }}</td>
          <td>{{ player.userName }}</td>
          <td>{{ player.name }}</td>
          <td>{{ player.age }}</td>
          <td>{{ player.city }}</td>
          <td>{{ player.state }}</td>
          <td>{{ player.wins }}</td>
          <td>{{ player.losses }}</td>
          <td>{{ player.totalPoints }}</td>
          <td>{{ player.ppg }}</td>
          <td>{{ player.rightOrLeftHanded }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import tournament from '../services/TournamentService';

export default {
  data() {
    return {
      players: [],
    };
  },

  mounted() {
    tournament.getPlayers().then((response) => {
      this.players = response.data;
    });
  },

  computed: {
    sortedPlayers() {
      return this.players.slice().sort((a, b) => b.wins - a.wins).slice(0, 10);
    },
  },
};
</script>
<style>
</style>