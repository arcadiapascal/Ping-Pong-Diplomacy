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
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@600&family=Quicksand:wght@300;400&display=swap');

:root {
  --primary-color: #00ADEE;
  --complement-1-color: #4D565E;
  --complement-2-color: #71D96F;
  --complement-3-color: #FF6359;
  --secondary-1-color: #DAE8F2;
  --secondary-2-color: #2B4F60;
  --secondary-3-color: #AB64EF;
  --secondary-4-color: #FDD441;
  --secondary-5-color: #556268;
  --secondary-6-color: #999DA0;
}

.top-nav {
  height: 23vh;
}

#nav-bar {
  background-color: var(--primary-color);
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
  font-family: 'Poppins';
  margin: 10px;
}

h2 {
  font-family: 'Quicksand';
}

h3 {
  font-family: 'Poppins';
}

h4 {
  font-family: 'Quicksand';
}

h5 {
  font-family: 'Poppins';
}

h6 {
  font-family: 'Quicksand';
}

p {
  font-family: 'Poppins';
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
  background-color: var(--complement-3-color);
  margin: 1rem;
}

#nav {
  list-style-type: none;
}

.paddle:before {
  content: '🏓';
}

</style>