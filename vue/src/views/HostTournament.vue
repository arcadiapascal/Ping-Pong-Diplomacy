<template>
  <div class="host-view">
      <h2>Host View</h2>
      <router-link :to="{ name: 'EditTournament' }">Edit Tournament</router-link>
      <router-view />
      <results />
      <tournament />
      </div>
</template>

<script>
import Results from '../components/Results.vue'
import Tournament from '../components/Tournament.vue'


export default {
  components: {
      Results,
      Tournament,
      
      }
}
</script>
