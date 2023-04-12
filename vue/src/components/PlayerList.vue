<template>
  <div class="player-list">
  </div>
</template>

<script>
import profileService from "../services/ProfileService.js";

export default {
    name: "player-list",
    methods: {
        getPlayers() {
            profileService.list().then(response => {
                this.$store.commit("SET_PROFILES", response.data);
            });
        }
    }

}
</script>

<style>

</style>