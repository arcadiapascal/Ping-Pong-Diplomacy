<template>
  <section>
      <h2>My Tournaments</h2>
      <div class="my-tournaments">
          <tournament />
      </div>
  </section>
</template>

<script>
import Tournament from './Tournament.vue';

export default {
    name: 'my-tournaments',
    components: {
      Tournament
      }
}
</script>

<style>

</style>