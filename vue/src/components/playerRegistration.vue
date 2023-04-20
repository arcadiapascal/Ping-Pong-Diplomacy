<template>
  <div class="player-reg">
    <div class="player-reg-section">
      <form class="form" @submit.prevent="secondForm" v-if="this.$route.params.id == 1">
        <label for="playerName">Player Name:</label>
        <input type="text" id="playerName" v-model="player.playerName" required />
        <label for="email">Email:</label>
        <input type="text" id="email" v-model="player.email" required />
        <button type="submit">Next</button>
      </form>

      <form @submit.prevent="submitPlayer" v-if="this.$route.params.id == 2">
        <div>
          <label for="playerCity">City:</label>
          <input type="text" id="city" v-model="player.city" required /><br>
        </div>
        <div>
          <label for="state-abbrev">State:</label>
          <select id="state-abbrev" v-model="player.stateAbbrev">
            <option v-for="state in states" :key="state" :value="state">{{ state }}</option>
          </select><br>
        </div>
        <button type="submit">Create Account</button>
      </form>

      <form @submit.prevent="submitPlayer" v-if="this.$route.params.id == 3">
        <label for="rightLeftHanded">Right or Left {{this.$store.state.user.id}}</label>
        <input type="text" id="rightOrLeft" v-model="player.rightLeftHanded" required />
        <button type="submit">Create Account</button>
      </form>

      <div class="success-message" v-if="showSuccessMessage">
        Account created successfully!
      </div>
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
       },
       showSuccessMessage: false,
      states: ['AL', 'AK', 'AZ', 'AR', 'CA', 'CO', 'CT', 'DE', 'FL', 'GA', 'HI', 'ID', 'IL', 'IN', 'IA', 'KS', 'KY', 'LA', 'ME', 'MD', 'MA', 'MI', 'MN', 'MS', 'MO', 'MT', 'NE', 'NV', 'NH', 'NJ', 'NM', 'NY', 'NC', 'ND', 'OH', 'OK', 'OR', 'PA', 'RI', 'SC', 'SD', 'TN', 'TX', 'UT', 'VT', 'VA', 'WA', 'WV', 'WI', 'WY']
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


<style scoped>
  .player-reg {
    display: flex;
    justify-content: center;
    align-items: flex-start;
    height: 100vh;
    padding: 2rem;
    background: linear-gradient(to bottom, #DAE8F2, #ffffff);
  }

  .player-reg-section {
    background-color: #fff;
    color: #4d565e;
    width: 33vh;
    border-radius: 8px;
    box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.1);
    font-family: inherit;
    padding: 20px;
    margin: 0 auto;
    
  }

  label {
    font-size: 1.2rem;
    margin-bottom: 0.5rem;
    font-weight: bold;
    text-align: left;
  }

  input[type="text"] {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
    margin-top: 5px;
    margin-bottom: 10px;
    font-size: 1rem;
    border-radius: 0.3rem;
    border: none;
    border-bottom: 2px solid #ccc;
    box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.3);
  }

  select {
    border-radius: 0.3rem;
    border: none;
    border-bottom: 2px solid #ccc;
    box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.3);
  }

  button[type="submit"] {
display: block;
padding: 1rem 2rem;
border: none;
border-radius: 0.25rem;
text-align: center;
text-decoration: none;
font-size: 1rem;
font-weight: bold;
color: #fff;
background-color: #00adee;
box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.3);
transition: background-color 0.3s ease-in-out;
margin: 0 auto;
cursor: pointer;
}

</style>
