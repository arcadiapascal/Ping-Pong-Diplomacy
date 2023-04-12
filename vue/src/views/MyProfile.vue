<template>
    <div class="my-profile">
        <router-link :to="{ name: 'EditProfile' }">Edit Profile</router-link>
        <router-view />
        <profile-details />
    </div>
</template>

<script>
import ProfileDetails from "../components/ProfileDetails.vue"

export default {
    name: "myProfile",
    components: {
        ProfileDetails    }
}
</script>