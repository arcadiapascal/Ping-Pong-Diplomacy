<template>
    <div class="my-profile">
        <h2>My Profile</h2>
        <router-link id="editButton" :to="{ name: 'editProfile' }">Edit Profile</router-link>
        <router-view />
        <profile-details />
    </div>
</template>

<script>
import ProfileDetails from "../components/ProfileDetails.vue"


export default {
    name: "myProfile",
    components: {
        ProfileDetails,
       }
}
</script>

<style>

</style>