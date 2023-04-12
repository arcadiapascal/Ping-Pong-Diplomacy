<template>
  <div class="host-view">
      <h1>Host View</h1>
      
      <player-list />
      <results />
      <tournament />
      </div>
</template>

<script>
import PlayerList from '../components/PlayerList.vue'
import Results from '../components/Results.vue'
import Tournament from '../components/Tournament.vue'

export default {
  components: {
      PlayerList,
      Results,
      Tournament
      }
}
</script>
