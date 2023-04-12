<template>
    <div class="edit-profile">
        <form class="edit-profile-form" v-on:submit.prevent="editProfile">
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
        </form>
    </div>
</template>

<script>
import ProfileService from "../services/ProfileService.js";

export default {
    data() {
      return {
        Profile: {
            username: '',
            password: '',
            firstName: '',
            lastName: '',
            location: '',
            skillLevel: ''
            },
      }
    },
    methods: {
        editProfile() {
            ProfileService.update(this.Profile).then(response => {
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