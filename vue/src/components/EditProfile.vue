<template>
    <div class="edit-profile">
        <form class="edit-profile-form" v-on:submit.prevent="updateProfile()">
            <label for="Username">Username: {{this.$store.state.user.username}}</label>
            <input type="text" v-model="Profile.username"><br>
            <label for="First Name">Player Name: {{this.$store.state.player.playerName}}</label>
            <input type="text" v-model="Profile.playerName"><br>
            <label for="Email">Email: {{this.$store.state.player.email}}</label>
            <input type="text" v-model="Profile.email"><br>
            <label for="Age">Age: {{this.$store.state.player.age}}</label>
            <input type="text" v-model="Profile.age"><br>
            <label for="City">City: {{this.$store.state.player.city}}</label>
            <input type="text" v-model="Profile.city"><br>
            <label for="State">State Abbreviation: {{this.$store.state.player.state}}</label>
            <input type="text" v-model="Profile.state"><br>
            <label for="Hand">Left Handed or Right Handed: {{this.$store.state.player.rightHandedOrLeftHanded}}</label>
            <select name="Hand" v-model="Profile.hand"><br>
                <option value="Right">Right Handed</option>
                <option value="Left">Left Handed</option>
            </select>
            <label for="Skill Level">Skill Level: {{this.$store.state.player.skillLevel}}</label>
            <select required name="Category" v-model="Profile.skillLevel"><br>
                <option value="Novice">Novice</option>
                <option value="Intermediate">Intermediate</option>
                <option value="Advanced">Advanced</option>
            </select>
            <button type="submit">Update Profile</button>
        </form>
    </div>
</template>

<script>
import ProfileService from "../services/ProfileService.js";

export default {
    data() {
      return {
        currentuser: this.$store.state.user,
        currentPlayer: this.$store.state.player,
        Profile: {
                id: "",
                username: "",
                email: "",
                playerName: "",
                age: "",
                city: "",
                state: "",
                hand: "", 
                skillLevel: ""                
            }
      }
    },
    methods: {
        updateProfile() {
            // const Profile = {
            //     username: this.username,
            //     email: this.email,
            //     playerName: this.playerName,
            //     age: this.age,
            //     city: this.city,
            //     state: this.state,
            //     hand: this.hand,
            //     skillLevel: this.skillLevel
            // };
            ProfileService.update(this.currentuser.id, this.Profile).then(response => {
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