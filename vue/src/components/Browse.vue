<template>
    <div class="browse">
        
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