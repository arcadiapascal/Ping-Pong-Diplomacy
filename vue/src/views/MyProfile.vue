<template>
    <div class="my-profile">
        <h1>My Profile</h1>
        <edit-profile />
        <profile-details />
    </div>
</template>

<script>
import EditProfile from "../components/EditProfile.vue"
import ProfileDetails from "../components/ProfileDetails.vue"

export default {
    name: "myProfile",
    components: {
        EditProfile,
        ProfileDetails
    }
}
</script>