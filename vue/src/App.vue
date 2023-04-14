<template>
  <div id="app">
    <div id="nav">
      <h1>Paddle Me!</h1>
          <div id="links">
            <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
            <router-link v-bind:to="{ name: 'browse' }">Browse</router-link>&nbsp;|&nbsp;
            <router-link v-bind:to="{ name: 'myProfile' }">My Profile</router-link>&nbsp;|&nbsp;
            <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
          </div>
    </div>
    <router-view />
  </div>
</template>

<script>

export default {
name: 'app'
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap');

#nav {
    background-color: #00ADEE;
    overflow: hidden;   

}
body {
  margin: 0px;
}
h1 {
    color: #4D565E;
    text-align: center;
    font-style: italic;
    font-family: 'Permanent Marker', cursive;
    font-size: 40px;
}
h2 {
  text-align: center;
}

#links {
  color: #4D565E;
  margin: 20px;
  
}
</style>
