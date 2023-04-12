<template>
  <section>
      <h2>My Tournaments</h2>
      <div class="my-tournaments">
          <tournament />
          <ul for="tournament in Tournaments">
            <li>{{Tournament.name}}</li>
          </ul>
      </div>
  </section>
</template>

<script>
import Tournament from './Tournament.vue';
import TournamentService from "../services/TournamentService.js";


export default {
    name: 'my-tournaments',
    components: {
      Tournament
      },
      data() {
      return {
        Tournaments: []              
      }
      
},
methods:{
  listTournaments(){
    TournamentService.getTournamentList.then(response=>{
      if(response === 200){
        this.Tournaments = response.data
      }
    }).catch(error => {
          if (error.response.status === 404) {
            this.$router.push("/404");
          } else {
            console.error(error);
          }
        });
  }
}
}
</script>

<style>

</style>