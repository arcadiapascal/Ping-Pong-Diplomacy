<template>
  <div class= "nav-bar" id="nav-bar">
      <ul id="nav">
        <li class="paddle"><router-link v-bind:to="{ name: 'home' }">Home</router-link></li>
        <li class="paddle"><router-link v-bind:to="{ name: 'browse' }">Browse</router-link></li>
        <li class="paddle"><router-link v-bind:to="{ name: 'myProfile' }">My Profile</router-link></li>
        <li class="paddle" v-if="$store.state.token != ''"><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li>
        <li class="paddle" v-if="$store.state.token == ''"><router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link></li>
      </ul>    
      <div id="header">
        <h1>-TE Pong!-</h1>
      </div>
      <div id="button">
        <router-link v-bind:to="{name:'createTournament'}" class="btn btn-nav">Create Tournament</router-link>
      </div>
    </div>
</template>

<script>
export default {
    name: "nav-bar"

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Permanent+Marker&family=Poppins:wght@700&family=Quicksand&display=swap');


#nav-bar {
    height: 23vh;
    background-color: #00ADEE;
    overflow: hidden;
    display: flex;
    align-items: center;
    justify-content: space-between;
}

body {
  margin: 0px;
  font-family: 'Quicksand', sans-serif;
}

h1 {
  font-size: 40px;
  font-style: italic;
  font-family: 'Poppins', sans-serif;
  margin: 10px;
}
h2 {
  font-family: 'Poppins', sans-serif;
}
h3 {
  font-style: italic;
  font-family: 'Poppins', sans-serif;
}

#header {
  display: flex;
  flex-direction: column;
  align-items: center;
}

li {
  margin: 5px;
  color: #4D565E;
}

.btn-nav {
  background-color: #FF6359;
  margin-right: 2rem;
  margin-left: -3rem;
  

}

#nav {
  list-style-type: none;
}

.paddle:before {
  content: '🏓';
}

</style>