<template>
  <div class="home">
    <first-look />
    <ping-pong-game />
  </div>
</template>


<script>
import FirstLook from '../components/FirstLook.vue';
import PingPongGame from '../components/pingPongGame.vue';

export default {
  name: "home",
  components: {
    FirstLook,
    PingPongGame
  }
};
</script>

<style>

.home {
  text-align: center;
  background: linear-gradient(to bottom, #DAE8F2, #ffffff);
}
</style>