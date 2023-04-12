<template>
    <div class="edit-profile">
      <h1>Edit Profile</h1>
      <edit-profile />
      <profile-details />
    </div>
</template>

<script>
import EditProfile from '../components/EditProfile.vue';
import ProfileDetails from '../components/ProfileDetials.vue';

export default {
    name: 'editProfile',
    components: {
        EditProfile,
        ProfileDetails
    }

}
</script>

