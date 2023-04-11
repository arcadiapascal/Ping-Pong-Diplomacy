<template>
  <div class="host-view">
      <h1>Host View</h1>
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
