<template>
  <div id="app">
    <div id="header">
      <h1>Paddle Me!</h1>
      <h3>Ping Pong Tournaments</h3>
    </div>
    <div id="nav-bar">
      <div id="user">
        <ul>
          <li><router-link v-bind:to="{ name: 'myProfile' }">My Profile</router-link></li>
          <li><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li>
        </ul>
      </div>
      <ul id="nav">
        <li><router-link v-bind:to="{ name: 'home' }">Home</router-link></li>
        <li><router-link v-bind:to="{ name: 'browse' }">Browse</router-link></li>
        <li><router-link v-bind:to="{ name: 'createTournament' }">Create a Tournament!</router-link></li>
      </ul>
      <div id="button">
        <router-link v-bind:to="{ name: 'createTournament' }">Create a Tournament!</router-link>
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

#nav-bar {
    background-color: #00ADEE;
    overflow: hidden;   
    display: flex;
    justify-content: space-between
    

}
body {
  margin: 0px;
}
h1 {
  font-size: 40px;
  color: #4D565E;
  font-style: italic;
  font-family: 'Permanent Marker', cursive;
}
h3 {
  color: #4D565E;
  font-style: italic;
  font-family: 'Permanent Marker', cursive;
}

#header {
    
}

ul {
  list-style-type: none;
  margin: 10px;
  padding: 0;
  
}
li {
  margin: 5px;
}

#button {
  display: flex;
  align-items:flex-end;
  margin: 20px;
  
}
#user {
  display: flex;
  align-items:flex-end;
  margin: 20px;

}
#nav {
  display: flex;
  align-items: center;
}
</style>
