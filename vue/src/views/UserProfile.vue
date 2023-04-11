<template>
    <div class="user-profile">
        <h1>User Profile</h1>
        <profile-details />
    </div>
</template>

<script>
import ProfileDetails from "../components/ProfileDetails.vue";
export default {
    name: 'userProfile',
    components: {
        ProfileDetails
    }
}
</script>