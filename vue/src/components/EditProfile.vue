<template>
    <div class="edit-profile">
        <h2>{{$store.state.user}}</h2>
        <form class="edit-profile-form" v-on:submit.prevent>
            <label for="Username">Username</label>
            <input type="text" v-model="Profile.username"><br>
            <label for="First Name">First Name</label>
            <input type="text" v-model="Profile.firstName"><br>
            <label for="Last Name">Last Name</label>
            <input type="text" v-model="Profile.lastName"><br>
            <label for="Location">Location</label>
            <input type="text" v-model="Profile.location"><br>
            <label for="Skill Level">Skill Level</label>
            <select required name="category" v-model="Profile.skillLevel">
                <option value="Novice">Novice</option>
                <option value="Intermediate">Intermediate</option>
                <option value="Advanced">Advanced</option>
            </select>
            <button type="submit" v-on:click="updateProfile()">Update Profile</button>
        </form>
    </div>
</template>

<script>
import ProfileService from "../services/ProfileService.js";

export default {
    data() {
      return {
        currentuser: this.$store.state.user
      }
    },
    methods: {
        updateProfile() {
            const updatedProfile = {
                id: this.id,
                username: this.username,
                firstName: this.firstName,
                lastName: this.lastName,
                location: this.location,
                skillLevel: this.skillLevel                
            };
            ProfileService.update(this.currentuser.id, updatedProfile).then(response => {
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