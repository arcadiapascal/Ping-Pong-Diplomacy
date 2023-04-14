<template>
<div id="browse">
    <search-tournaments/>
    <form class="browse-by-form" v-on:submit.prevent>
        <label for="tournament-title">Tournament Title</label>
        <input type="text" id="tournament-title" />
        <label for="location">Location</label>
        <input type="text" id="location" />
        <label for="filter-by-active">Active/Inactive</label>
        <!-- <select name="active" v-model="Tournament.active">
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
        </select> -->
    </form>
</div>
</template>

<script>
import tournamentService from "../services/TournamentService.js";
import searchTournaments from "../components/SearchTournaments.vue";

export default {
    components: {
        searchTournaments,
    },
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