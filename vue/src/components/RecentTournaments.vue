<template>
  <section>
      <h2>Recent Tournaments</h2>
      <div class="recent-tournaments">
          <tournament />
      </div>
  </section>
</template>

<script>
import Tournament from './Tournament.vue'

export default {
    name: "recent-tournaments",
    computed: {
        // tournaments() {
        //     return this.$store.state.recentTournaments.filter((tournament) => {
        //         return tournament.recent === true;
        //     });
        // }
    },
    components: { Tournament },

}
</script>

<style>

</style>
