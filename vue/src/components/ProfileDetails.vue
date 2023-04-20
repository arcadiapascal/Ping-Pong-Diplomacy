<template>
  <div class="profile-box">
    <div class ="profile-header">
      <h2 class="profile-title">Profile Details</h2>
      <h4>Username: {{$store.state.user.username}}</h4>
    </div>
    <ul class="player-details">
      <li>Name: {{player.playerName}}</li>
      <li>Email: {{player.email}}</li>
      <li>City: {{player.city}}</li>
      <li>State: {{player.stateAbbrev}}</li>
    </ul>
     <router-link id="editButton" :to="{ name: 'editProfile' }" class="btn btn-primary">Edit Profile</router-link>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      player: {},
    };
  },
  computed: {
    currentUser() {
      return this.$store.state.user;
    },
  },
  mounted() {
    this.getPlayerObject(this.currentUser.id)
      .then((response) => {
        this.player = response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods: {
    getPlayerObject(id) {
      return axios.get(`/players/id/${id}`);
    },
  },
};
</script>

<style scoped>

.profile-details {
    width: 33vh;
}

.profile-box {
  background-color: #fff;
  /* width: 33vh; */
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  font-family: inherit;
  padding: 20px;
  margin: 1vh;
  height: 27vh;
}

.profile-header{
  text-align: center;
}

.profile-title {
  margin-top: 0;
}

#editButton {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 1rem 1rem;
  border: none;
  border-radius: 0.25rem;
  text-align: center;
  text-decoration: none;
  font-size: 1rem;
  font-weight: bold;
  color: #fff;
  background-color: #00ADEE;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  transition: background-color 0.3s ease-in-out;
}

#editButton:hover {
  background-color: #4d565e;
}
</style>