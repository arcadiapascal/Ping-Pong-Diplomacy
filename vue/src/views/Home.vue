<template>
  <div class="home">
    <ping-pong-game />
    <first-look />
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
}
</style>