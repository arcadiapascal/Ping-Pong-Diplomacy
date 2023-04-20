<template>
  <div class="my-profile">
    <div class="top-row">
      <div class="profile-details">
      <profile-details /> </div>
      <div class="player-stats">
      <player-stats /></div>
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
  background: linear-gradient(to bottom, #DAE8F2, #ffffff);
}

.top-row {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  width: 100%;
  margin-top: 2vh;
  margin-bottom: 2vh;
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
