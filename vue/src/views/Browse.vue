<template>
<div id="browse">
    <!-- <ping-pong-game/> -->
    <search-navagation-component/>
    <!-- <bracket-generator/> -->
    <!-- <search-tournaments/> -->
    <!-- <stats-component/> -->
    <!-- <tournament-and-host-component/> -->
    <!-- <form class="browse-by-form" v-on:submit.prevent>
        <label for="tournament-title">Tournament Title</label>
        <input type="text" id="tournament-title" />
        <label for="location">Location</label>
        <input type="text" id="location" />
        <label for="filter-by-active">Active/Inactive</label> -->
        <!-- <select name="active" v-model="Tournament.active">
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
        </select>
    </form> -->
</div>
</template>

<script>
import tournamentService from "../services/TournamentService.js";
// import bracketGenerator from "../components/bracketGenerator.vue"
// import pingPongGame from "../components/pingPongGame.vue";
import searchNavagationComponent from '../components/searchNavagationComponent.vue';
// import searchTournaments from "../components/SearchTournaments.vue";
// import statsComponent from "../components/statsComponent.vue";
// import tournamentAndHostComponent from "../components/TournamentAndHostComponent.vue";

export default {
    components: {
        // bracketGenerator,
        // pingPongGame,
        searchNavagationComponent
        // searchTournaments,
        // statsComponent,
        // tournamentAndHostComponent
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