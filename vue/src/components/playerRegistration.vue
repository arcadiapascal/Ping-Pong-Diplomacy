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
                  this.$router.push(`/home`);
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
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 40px 0;
}

#player-reg form {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 20px 0;
}

#player-reg label {
  font-size: 14px;
  font-weight: bold;
  margin-bottom: 10px;
}

#player-reg input[type="text"] {
  padding: 10px;
  border-radius: 4px;
  border: 1px solid #dadce0;
  width: 350px;
  font-size: 16px;
  margin-bottom: 20px;
}

#player-reg button[type="submit"] {
  padding: 10px 20px;
  border-radius: 4px;
  border: none;
  background-color: #1a73e8;
  color: #fff;
  font-size: 16px;
  font-weight: bold;
  cursor: pointer;
}

#player-reg button[type="submit"]:hover {
  background-color: #0d47a1;
}

#player-reg div {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 20px;
}

#player-reg div label {
  margin-right: 10px;
}

@media only screen and (max-width: 600px) {
  #player-reg input[type="text"] {
    width: 100%;
  }
}
</style>