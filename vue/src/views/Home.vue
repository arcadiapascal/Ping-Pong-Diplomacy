<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <router-link :to="{ name: 'browse' }">Find A Tournament</router-link>
    <router-link :to="{ name: 'myProfile' }">My Profile</router-link>
    <router-view />
    <recent-tournaments />
    <my-tournaments />
  </div>
</template>

<script>
import RecentTournaments from '../components/RecentTournaments.vue';
import MyTournaments from '../components/MyTournaments.vue';

export default {
  name: "home",
  components: {
    MyTournaments,
    RecentTournaments
  }
};
</script>
