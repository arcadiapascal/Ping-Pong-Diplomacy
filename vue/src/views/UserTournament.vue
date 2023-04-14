<template>
  <div class="user-view">
      <h2>User View</h2>
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
