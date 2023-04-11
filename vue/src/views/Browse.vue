<template>
<div id="browse">
    <div class="title-form">
        <label for="tournament-title">Tournament Title</label>
        <input type="text" id="tournament-title" />
    </div>
    <div class="location-form">
        <label for="location">Location</label>
        <input type="text" id="location" />
    </div>
</div>
</template>

<script>
import tournamentService from "../services/TournamentService.js";

export default {
    name: "tournament-list",
    methods: {
        getTournaments() {
            tournamentService.listTournaments().then(response => {
                this.$store.commit("SET_TOURNAMENTS", response.data);
            });
        }
    }
}
</script>

<style>

</style>