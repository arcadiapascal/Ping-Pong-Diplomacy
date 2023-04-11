<template>
  <div class="user-view">
      <h1>User View</h1>
      <bracket />
      <player-list />
      <results />
      <tournament />
</template>

<script>
import Bracket from '../components/Bracket.vue'
import PlayerList from '../components/PlayerList.vue'
import Results from '../components/Results.vue'
import Tournament from '../components/Tournament.vue'

export default {
  components: {
      Bracket,
      PlayerList,
      Results,
      Tournament
      }
}
</script>
