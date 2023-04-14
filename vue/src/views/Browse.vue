<template>
<div id="browse">
    <h2>Browse</h2>
    <form class="browse-by-form" v-on:submit.prevent>
        <label for="tournament-title">Tournament Title</label>
        <input type="text" id="tournament-title" />
        <label for="location">Location</label>
        <input type="text" id="location" />
        <label for="filter-by-active">Active/Inactive</label>
        <select name="active" v-model="Tournament.active">
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
        </select>
    </form>
</div>
</template>

<script>
import tournamentService from "../services/TournamentService.js";

export default {
    name: "browse",
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