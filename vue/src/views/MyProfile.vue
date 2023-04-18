<template>
    <div class="my-profile">
        <h2>My Profile</h2>
        <router-link id="editButton" :to="{ name: 'editProfile' }">Edit Profile</router-link>
        <profile-details />
        <my-tournaments />
        <player-stats />
    </div>
</template>

<script>
import ProfileDetails from "../components/ProfileDetails.vue"
import MyTournaments from "../components/MyTournaments.vue"
import PlayerStats from "../components/playerStats.vue"


export default {
    name: "myProfile",
    components: {
        ProfileDetails,
        MyTournaments,
        PlayerStats
       }
}
</script>

<style>

</style>