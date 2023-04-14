<template>
  <div>
       <h2>Username: {{$store.state.user.username}}</h2>
        <ul class="player-details">
          <li>Name: {{this.$store.state.player.playerName}}</li>
          <li>Email: {{this.$store.state.player.email}}</li>
          <li>Age: {{this.$store.state.player.age}}</li>
          <li>City: {{this.$store.state.player.city}}</li>
          <li>State: {{this.$store.state.player.state}}</li>
          <li>Hand: {{this.$store.state.player.hand}}</li>
          <li>Skill Level: {{this.$store.state.player.skillLevel}}</li>
        </ul>
      <router-link v-bind:to="{name:'createTournament'}"><button>Create</button></router-link>

  </div>
</template>

<script>
export default {
data() {
      return {
        currentUser: this.$store.state.user,
        currentPlayer: this.$store.state.player
      };
},
}
</script>

<style>

</style>