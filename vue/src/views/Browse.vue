<template>
<div id="browse">
    <!-- <ping-pong-game/> -->
    <router-link class="PlayGame" v-bind:to="{ name: 'playgame' }">play game</router-link>
    <search-navagation-component/>
</div>
</template>

<script>
import tournamentService from "../services/TournamentService.js";
import searchNavagationComponent from '../components/searchNavagationComponent.vue';

export default {
    components: {
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

</style>