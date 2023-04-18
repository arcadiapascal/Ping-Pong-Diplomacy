<template>
  <div class="home">
    <ping-pong-game />
    <display-users />
    <recent-tournaments />
    <my-tournaments />
    <tournament-carousel />
  </div>
</template>


<script>
import PingPongGame from '../components/pingPongGame.vue';
import TournamentCarousel from '../components/TourCarousel.vue';

export default {
  name: "home",
  components: {
    TournamentCarousel,
    PingPongGame
  }
};
</script>

<style>
.home {
  text-align: center;
}
</style>