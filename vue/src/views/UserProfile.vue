<template>
    <div class="user-profile">
        <h2>User Profile</h2>
        <profile-details />
    </div>
</template>

<script>
import ProfileDetails from "../components/ProfileDetails.vue";

export default {
    name: 'userProfile',
    components: {
        ProfileDetails    }
}
</script>