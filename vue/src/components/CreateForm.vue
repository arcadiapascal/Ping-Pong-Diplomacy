<template>
  <div>

      <form class="new-book-form" v-on:submit.prevent="addTournament">
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
        Tournament: {
            name: "",
            location:"",
            address:"",
            date:"",
            skillLevel:"",
            registrationDeadline:"",
            description: "",
            active:true
        },
        
      }
      
},
methods: {
            addTournament(){
                TournamentService.create(this.Tournament).then(response=> {
                    if(response.status === 201){
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