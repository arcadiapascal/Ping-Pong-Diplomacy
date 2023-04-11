<template>
    <div class="my-profile">
          
        <profile-details />
    </div>
</template>

<script>
import ProfileDetails from "../components/ProfileDetails.vue"

export default {
    name: "myProfile",
    components: {
    
        ProfileDetails
    }
}
</script>