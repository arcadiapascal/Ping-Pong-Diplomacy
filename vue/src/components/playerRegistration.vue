<template>
  <div  id="player-reg">

   <form id="form-1" @submit.prevent="secondForm" v-if="this.$route.params.id == 1">
        <label  for="playerName">Player Name:</label>
        <input type="text" id="confirmPassword" v-model="player.name" required /><br>        
        <label for="email">Email:</label>
        <input type="text" id="confirmPassword" v-model="player.Email" required /><br>
        <button type="submit">Next</button>
      </form>

      <form id="form-2" @submit.prevent="thirdForm" v-if="this.$route.params.id == 2">
      <div>
      <label for="playerCity">City:</label>
        <input type="text" id="confirmPassword" v-model="player.city" required /><br>
      </div>
      <div>
      <label for="playerState">State:</label>
        <input type="text" id="confirmPassword" v-model="player.state" required /><br>
      </div>
      <button type="submit">Next</button>
      </form>

      <div>
          <form id="form-3" @submit.prevent="submitPlayer" v-if="this.$route.params.id == 3">
        <label for="rightLeftHanded">Right or Left Hand:</label>
        <input type="text" id="confirmPassword" v-model="player.rightOrLeftHanded" required /><br>
        <button type="submit">Create Account</button>
        </form>
  </div>
  </div>
</template>

<script>
import ProfileService from "../services/ProfileService.js";

export default {
    name: "player-registration",
    data() {
      return {
       id: "",
       player:{
         id:0,
         userid: "",
         username:"",
         name:"",
         email:"",
         city:"",
         state:"",
         rightOrLeftHanded:"",
       }
      }
      
      
},

methods: {
            secondForm(){
                
                this.$router.push(`/register/2`);
            },
            thirdForm(){ 
                this.$router.push(`/register/3`);
            },
            submitPlayer(){
              
              this.$store.user.forEach(element => {
                this.userid = element;
              });
              ProfileService.createPlayer(this.player).then(response => {
                if(response.status === 201){
                  this.$router.push(`/`);
                }
              }).catch(error => {
          if (error.response.status === 404) {
            this.$router.push("/404");
          } else {
            console.error(error);
          }
        });
               
            },
            getUserId(){
              
            }
          
        }
}
</script>

<style>
#player-reg {
  text-align: center;
  margin: 25px;
  
}

input {
  margin: 10px;
}

</style>