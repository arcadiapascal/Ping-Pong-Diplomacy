<template>
  <div class="my-profile">
    <div class="profile-stats-container">
      <profile-details />
      <player-stats />
    </div>
    <my-tournaments />
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

<style scoped>
.my-profile {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.profile-stats-container {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  width: 50%;
  margin-top: 2rem;
  margin-bottom: 2rem;
}

@media (max-width: 768px) {
  .profile-stats-container {
    flex-direction: column;
    align-items: center;
  }
}

@media (min-width: 769px) and (max-width: 1024px) {
  .profile-stats-container {
    width: 90%;
  }
}

@media (min-width: 1025px) {
  .profile-stats-container {
    width: 70%;
  }
}
</style>
