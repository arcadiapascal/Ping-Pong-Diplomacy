<template>
  <div id="app">
    
    <div id="nav-bar">
      <div id="user">
        <ul id="profile">
          <li class="paddle"><router-link v-bind:to="{ name: 'myProfile' }">My Profile</router-link></li>
          <li class="paddle"><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li>
        </ul>
      </div>
      <div id="header">
        <h1>Paddle Me!</h1>
        <ul id="nav">
            <li class="paddle"><router-link v-bind:to="{ name: 'home' }">Home</router-link></li>&nbsp;|&nbsp;
            <li class="paddle"><router-link v-bind:to="{ name: 'browse' }">Browse</router-link></li>
        </ul>
      </div>       
      <div id="button">
        <router-link v-bind:to="{ name: 'createTournament' }">Create a Tournament!</router-link>
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
}

li {
  margin: 5px;
}

#button {
  display: flex;
  align-items:flex-end;
  margin: 30px;
  
}
#user {
  display: flex;
  align-items:flex-end;
  margin: 20px;
}
#profile {
  list-style-type: none;
  margin: 0px;
  padding: 0;
}
#nav {
  display: flex;
  align-items: center;
  list-style-type: none;
}
.paddle:before {
  content: '🏓';
  
}
</style>
