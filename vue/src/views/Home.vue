<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <search />
    <browse />
  </div>
</template>

<script>
import Search from '../components/Search.vue';
import Browse from '../components/Browse.vue'

export default {
  name: "home",
  components: {
    Search,
    Browse
  }
};
</script>
