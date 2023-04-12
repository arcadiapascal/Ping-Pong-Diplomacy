<template>
    <div class="my-profile">
        <edit-profile />          
        <profile-details />
    </div>
</template>

<script>
import EditProfile from '../components/EditProfile.vue'
import ProfileDetails from "../components/ProfileDetails.vue"

export default {
    name: "myProfile",
    components: {
        ProfileDetails,
        EditProfile
    }
}
</script>