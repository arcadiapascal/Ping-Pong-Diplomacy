<template>
  <div class="home">
    <display-users />
    <recent-tournaments />
    <my-tournaments />
    <tournament-carousel />
  </div>
</template>


<script>
import TournamentCarousel from '../components/TourCarousel.vue';

export default {
  name: "home",
  components: {
    TournamentCarousel
  }
};
</script>
