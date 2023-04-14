<template>
  <div>

   <form @submit.prevent="secondForm" v-if="this.$route.params.id == 1">
        <label  for="playerName">Player Name</label>
        <input type="text" id="confirmPassword" v-model="player.name" required />
        <button type="submit">Next</button>        
      <label for="email">Email</label>
        <input type="text" id="confirmPassword" v-model="player.Email" required />
      </form>

      <form @submit.prevent="thirdForm" v-if="this.$route.params.id == 2">
      <div>
      <label for="playerCity">City</label>
        <input type="text" id="confirmPassword" v-model="player.city" required />
      </div>
      <div>
      <label for="playerState">State</label>
        <input type="text" id="confirmPassword" v-model="player.state" required />
      </div>
      <button type="submit">Next</button>
      </form>

      <div>
          <form @submit.prevent="submitPlayer" v-if="this.$route.params.id == 3">
        <label for="rightLeftHanded">Right or Left</label>
        <input type="text" id="confirmPassword" v-model="player.rightOrLeftHanded" required />
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
 created() {
   this.id = this.$route.params.id;
   this.getUserId();
  },
methods: {
            secondForm(){
                
                this.$router.push(`/register/2`);
            },
            thirdForm(){ 
                this.$router.push(`/register/3`);
            },
            submitPlayer(){
                this.$router.push(`/`);
            },
            getUserId(){
              ProfileService.getUserIdByUsername(this.$store.state.userName).then(response => {
                if(response.status == 200){
                  this.userid = response.data;
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