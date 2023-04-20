<template>
<div id="browse">
    <search-navagation-component/>
    <!-- <time-till-next-tournament/> -->
</div>
</template>

<script>
import tournamentService from "../services/TournamentService.js";
import searchNavagationComponent from '../components/searchNavagationComponent.vue';
// import timeTillNextTournament from '../components/timeTillNextTournament.vue'

export default {
    components: {
        // timeTillNextTournament,
        searchNavagationComponent
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
.browse {
    background: linear-gradient(to bottom, #DAE8F2, #ffffff);
}
</style>