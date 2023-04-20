<template>
  <div class="edit-profile">
    <form class="edit-profile-form" v-on:submit.prevent="updateProfile()">
      <h3>Profile Details</h3>
      <label for="username">Username: {{this.$store.state.user.username}}</label><br>
      <label for="player-name">Player Name:</label>
      <input type="text" id="player-name" v-model="Profile.playerName"><br>
      <label for="email">Email:</label>
      <input type="text" id="email" v-model="Profile.email"><br>
      <label for="city">City:</label>
      <input type="text" id="city" v-model="Profile.city"><br>
      <label for="state-abbrev">State:</label>
<select id="state-abbrev" v-model="Profile.stateAbbrev">
  <option v-for="state in states" :key="state" :value="state">{{ state }}</option>
</select><br>
      <button type="submit" class="btn btn-primary">Update Profile</button>
      <div v-if="showProfileUpdatedMessage">Profile Updated</div>
    </form>
  </div>
</template>
<script>
import ProfileService from "../services/ProfileService.js";
import axios from 'axios';

export default {
  name: "EditProfile",
  props: ["id"],
  data() {
  return {
    currentuser: this.$store.state.user,
    Profile: {
      username: "",
      playerName: "",
      city: "",
      stateAbbrev: "",
      email: "",
    },
    showProfileUpdatedMessage: false,
    states: ['AL', 'AK', 'AZ', 'AR', 'CA', 'CO', 'CT', 'DE', 'FL', 'GA', 'HI', 'ID', 'IL', 'IN', 'IA', 'KS', 'KY', 'LA', 'ME', 'MD', 'MA', 'MI', 'MN', 'MS', 'MO', 'MT', 'NE', 'NV', 'NH', 'NJ', 'NM', 'NY', 'NC', 'ND', 'OH', 'OK', 'OR', 'PA', 'RI', 'SC', 'SD', 'TN', 'TX', 'UT', 'VT', 'VA', 'WA', 'WV', 'WI', 'WY']
  };
},
  methods: {
    getPlayerObject(id) {
      return axios.get(`/players/id/${id}`);
    },
    updateProfile() {
      ProfileService.update(this.currentuser.id, this.Profile)
        .then(response => {
          if(response.status === 200) {
            this.showProfileUpdatedMessage = true;
            setTimeout(() => {
              this.showProfileUpdatedMessage = false;
            }, 3000);
            this.$router.push({ name: "myProfile", params: { id: this.id } });
          }
        })
        .catch(error => {
          if (error.response.status === 404) {
            this.$router.push("/404");
          } else {
            console.error(error);
          }
        });
    }
  },
  created() {
    this.getPlayerObject(this.currentuser.id)
      .then(response => {
        this.Profile = response.data;
      })
      .catch(error => {
        if (error.response.status == 404) {
          this.$router.push({name: 'NotFound'});
        }
      });
  }
};
</script>

<style scoped>
.edit-profile {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 60vh;
  
}

.edit-profile-form {
  background-color: #fff;
  width: 33vh;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  font-family: inherit;
  padding: 20px;
}

label {
  display: block;
  margin-top: 10px;
  font-size: 1rem;
  font-weight: bold;
}

input[type="text"] {
  width: 100%;
  padding: 8px;
  border-radius: 4px;
  border: 1px solid #ccc;
  box-sizing: border-box;
  margin-top: 5px;
  margin-bottom: 10px;
  font-size: 1rem;
}

button[type="submit"] {
  display: block;
  margin: 10px auto;
  padding: 8px 16px;
  border: none;
  border-radius: 4px;
  text-align: center;
  text-decoration: none;
  font-size: 1rem;
  font-weight: bold;
  color: #fff;
  background-color: #00ADEE;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  transition: background-color 0.3s ease-in-out;
}

button[type="submit"]:hover {
  background-color: #4d565e;
}

/* added style for the success message */
.success-message {
  color: green;
  margin-top: 10px;
  font-size: 1rem;
  text-align: center;
}
</style>
