<template>
  <div id="app">
    <div class= "top-nav" id="nav-bar">
      <ul id="nav">
        <li class="paddle"><router-link v-bind:to="{ name: 'home' }">Home</router-link></li>
        <li class="paddle"><router-link v-bind:to="{ name: 'browse' }">Browse</router-link></li>
        <li class="paddle"><router-link v-bind:to="{ name: 'myProfile' }">My Profile</router-link></li>
        <li class="paddle"><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li>
      </ul>    
      <div id="header">
        <h1>-TE Pong!-</h1>
      </div>
      <div id="button">
        <router-link v-bind:to="{name:'createTournament'}" class="btn btn-nav">Create Tournament</router-link>
      </div>
      
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
name: 'app',
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap');

.top-nav {
  height: 17vh;
}

#nav-bar {
    background-color: #00ADEE;
    overflow: hidden;   
    display: flex;
    align-items: center;
    justify-content: space-between;
    
}
body {
  margin: 0px;
  
}
h1 {
  font-size: 40px;
  font-style: italic;
  font-family: 'Permanent Marker', cursive;
  margin: 10px;
}
h3 {
  font-style: italic;
  font-family: 'Permanent Marker', cursive;
}

#header {
  
  display: flex;
  flex-direction: column;
  align-items: center;
  
}

li {
  margin: 5px;
}

.btn-nav {
  background-color: #FF6359;
  margin: 1rem;
  

}

#nav {
  list-style-type: none;
  
  
}
.paddle:before {
  content: '🏓';
  
}
</style>
