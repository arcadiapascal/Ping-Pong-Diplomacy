<template>
  <div  id="player-reg">

   <form @submit.prevent="secondForm" v-if="this.$route.params.id == 1">
        <label  for="playerName">Player Name</label>
        <input type="text" id="confirmPassword" v-model="player.playerName" required />
        <button type="submit">Next</button>        
      <label for="email">Email</label>
        <input type="text" id="confirmPassword" v-model="player.email" required />
      </form>

      <form @submit.prevent="submitPlayer" v-if="this.$route.params.id == 2">
      <div>
      <label for="playerCity">City:</label>
        <input type="text" id="confirmPassword" v-model="player.city" required /><br>
      </div>
      <div>
      <label for="playerState">State</label>
        <input type="text" id="confirmPassword" v-model="player.stateAbbrev" required />
      </div>
      <button type="submit">Create Account</button>
      </form>

      <div>
          <form @submit.prevent="submitPlayer" v-if="this.$route.params.id == 3">
        <label for="rightLeftHanded">Right or Left {{this.$store.state.user.id}}</label>
        <input type="text" id="confirmPassword" v-model="player.rightLeftHanded" required />
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
         userId:"",
         playerName:"",
         name:"",
         email:"",
         city:"",
         stateAbbrev:"",
         
      
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
              this.player.userId = this.$store.state.user.id
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