
<template>
  <div>
      <h2>User Profile</h2>
       <h1>{{$store.state.currentUser}} user profile</h1> 
      <router-link v-bind:to="{name:'createTournament'}"><button>Create</button></router-link>

  </div>
</template>

<script>
export default {
data() {
      return {
        currentuser: this.$store.state.currentUser
      };
},
}
</script>

<style>

</style>