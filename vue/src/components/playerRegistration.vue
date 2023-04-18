<template>
  <div  id="player-reg">

   <form @submit.prevent="secondForm" v-if="this.$route.params.id == 1">
        <label  for="playerName">Player Name</label>
        <input type="text" id="playerName" v-model="player.playerName" required />       
      <label for="email">Email</label>
        <input type="text" id="email" v-model="player.email" required />
        <button type="submit">Next</button> 
      </form>

      <form @submit.prevent="submitPlayer" v-if="this.$route.params.id == 2">
      <div>
      <label for="playerCity">City:</label>
        <input type="text" id="city" v-model="player.city" required /><br>
      </div>
      <div>
  <label for="playerState">State</label>
  <select id="state" v-model="player.stateAbbrev" required>
    <option value="">Select a state</option>
    <option value="AL">AL</option>
    <option value="AK">AK</option>
    <option value="AZ">AZ</option>
    <option value="AR">AR</option>
    <option value="CA">CA</option>
    <option value="CO">CO</option>
    <option value="CT">CT</option>
    <option value="DE">DE</option>
    <option value="FL">FL</option>
    <option value="GA">GA</option>
    <option value="HI">HI</option>
    <option value="ID">ID</option>
    <option value="IL">IL</option>
    <option value="IN">IN</option>
    <option value="IA">IA</option>
    <option value="KS">KS</option>
    <option value="KY">KY</option>
    <option value="LA">LA</option>
    <option value="ME">ME</option>
    <option value="MD">MD</option>
    <option value="MA">MA</option>
    <option value="MI">MI</option>
    <option value="MN">MN</option>
    <option value="MS">MS</option>
    <option value="MO">MO</option>
    <option value="MT">MT</option>
    <option value="NE">NE</option>
    <option value="NV">NV</option>
    <option value="NH">NH</option>
    <option value="NJ">NJ</option>
    <option value="NM">NM</option>
    <option value="NY">NY</option>
    <option value="NC">NC</option>
    <option value="ND">ND</option>
    <option value="OH">OH</option>
    <option value="OK">OK</option>
    <option value="OR">OR</option>
    <option value="PA">PA</option>
    <option value="RI">RI</option>
    <option value="SC">SC</option>
    <option value="SD">SD</option>
    <option value="TN">TN</option>
    <option value="TX">TX</option>
    <option value="UT">UT</option>
    <option value="VT">VT</option>
    <option value="VA">VA</option>
    <option value="WA">WA</option>
    <option value="WV">WV</option>
    <option value="WI">WI</option>
    <option value="WY">WY</option>
  </select>
</div>
      <button type="submit">Create Account</button>
      </form>

      <div>
          <form @submit.prevent="submitPlayer" v-if="this.$route.params.id == 3">
        <label for="rightLeftHanded">Right or Left {{this.$store.state.user.id}}</label>
        <input type="text" id="rightOrLeft" v-model="player.rightLeftHanded" required />
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