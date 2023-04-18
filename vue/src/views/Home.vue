<template>
  <div class="home">
    <first-look />
  </div>
</template>


<script>
import FirstLook from '../components/FirstLook.vue';

export default {
  name: "home",
  components: {
    FirstLook
  }
};
</script>

<style>
.home {
  text-align: center;
}
</style>