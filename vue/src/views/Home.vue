<template>
  <div class="home">
    <ping-pong-game />
    <display-users />
    <recent-tournaments />
    <my-tournaments />
    <my-tournaments />
  </div>
</template>


<script>
import PingPongGame from '../components/pingPongGame.vue';
import MyTournaments from '../components/MyTournaments.vue';

export default {
  name: "home",
  components: {
    MyTournaments,
    PingPongGame
  }
};
</script>

<style>
.home {
  text-align: center;
}
</style>