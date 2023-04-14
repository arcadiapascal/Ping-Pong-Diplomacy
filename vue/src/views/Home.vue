<template>
  <div class="home">
    <h2>Home</h2>
    <p>You must be authenticated to see this</p>
    <display-users />
    <recent-tournaments />
    <my-tournaments />
  </div>
</template>

<script>
import RecentTournaments from '../components/RecentTournaments.vue';
import MyTournaments from '../components/MyTournaments.vue';
import DisplayUsers from '../components/DisplayUsers.vue';

export default {
  name: "home",
  components: {
    DisplayUsers,
    MyTournaments,
    RecentTournaments    
  }
};
</script>
