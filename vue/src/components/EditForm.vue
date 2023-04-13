<template>
  <div>
      <form class="edit-tournament-form" v-on:submit.prevent="addTournament">
          <label for="Tournament Name">Tournament Name</label>
          <input  type="text" v-model="Tournament.name"><br>
           <label for="Tournament Location">Location</label>
           <input class="author-input" type="text" v-model="Tournament.location"><br>
           <label for="Tournament Address">Address</label>
           <input type="text" v-model="Tournament.address"><br>
           <label for="Tournament Date">Date</label>
           <input  type="datetime-local" v-model="Tournament.date"><br>
           <label for="Tournament Skill Level">Skill Level</label>
             <!-- <select name="Tournament_Skill_Level" id="skill_level"> -->
            <select required name="category" v-model="Tournament.skillLevel">
              <option value="Novice">Novice</option>
              <option value="Intermediate">Intermediate</option>
              <option value="Advanced">Advanced</option>
            </select>
           <label for=" Tournament Registration Deadline">Registration Deadline</label>
           <input  type="date" v-model="Tournament.registrationDeadline"><br>
           <label for=" Tournament Registration Deadline">Description</label>
           <input  type="text" v-model="Tournament.description"><br>
           <input type="submit" value="Submit">
       </form>
      </div>
</template>

<script>
import TournamentService from "../services/TournamentService.js";

export default {
    data() {
      return {
        currentUser: this.$store.state.user,
        Tournament: {
            id: 0,
            hostId: this.currentUser.id,
            name: "",
            location:"",
            address:"",
            date:"",
            skillLevel:"",
            registrationDeadline:"",
            description: "",
            active: true,
            players: []
        },
        
      }
      
},
methods: {
          editTournament() {
            const updatedTournament = {
              hostId: this.hostId,
              name: this.name,
              location: this.location,
              address: this.address,
              date: this.date,
              skillLevel: this.skillLevel,
              registrationDeadline: this.registrationDeadline,
              description: this.description,
              active: this.active,
              players: this.players
            };
            TournamentService.update(this.Tournament.id, updatedTournament).then(response => {
              if(response.status === 200) {
                this.$router.push('/');
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