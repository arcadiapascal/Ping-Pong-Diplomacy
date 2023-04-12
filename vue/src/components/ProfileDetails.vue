
<template>
  <div>
      <h2>User Profile</h2>
       <h1>{{$store.state.user.id}} user profile</h1> 
      <router-link v-bind:to="{name:'createTournament'}"><button>Create</button></router-link>

  </div>
</template>

<script>
export default {
data() {
      return {
        currentuser: this.$store.state.user
      };
},
}
</script>

<style>

</style>