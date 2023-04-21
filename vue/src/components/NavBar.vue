<template>
  <div class="nav-bar" id="nav-bar">
    <div id="header">
      <router-link :to="{ name: 'home' }">
        <img src="../Assets/logo.png" alt="logo" />
      </router-link>
    </div>
    <div id="nav">
      <ul>
        <li class="paddle"><router-link v-bind:to="{ name: 'home' }">Home</router-link></li>
        <li class="paddle"><router-link v-bind:to="{ name: 'browse' }">Browse</router-link></li>
        <li class="paddle"><router-link v-bind:to="{ name: 'myProfile' }">My Profile</router-link></li>
      </ul>
    </div>
    <div>
      <ul id="login">
        <li class="paddle" v-if="$store.state.token != ''"><router-link v-bind:to="{ name: 'logout' }">Logout</router-link></li>
        <li class="paddle" v-if="$store.state.token == ''"><router-link v-bind:to="{ name: 'login' }">Login</router-link></li>
      </ul>
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

<style scoped>
#nav-bar {
  height: 20vh;
  background: linear-gradient(to bottom, #00ADEE, #DAE8F2);
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: space-between;
  flex-direction: row;
}

#header {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-left: 2rem;
}

#nav {
  list-style-type: none;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-grow: 1;
}

.paddle {
  margin: 5px;
  color: #4D565E;
  padding: 0 1rem;
  display: flex;
  align-items: center;
  justify-content: center;
}

.btn-nav {
  background-color: #FF6359;
}

#create-tournament {
  margin-right: 2rem;
}

/* #login li {
  margin: 0px 10px;
  color: #4D565E;
  display: inline-block;
} */

#login {
  display: block;
  font-size: 1rem;
  font-weight: bold;
  padding: 10px 15px;
  border-radius: 5px;
  text-align: center;
  text-decoration: none;
  color: white;
}

#nav li a::before{
  content: '🏓';
}

#nav li {
  margin: 0px 10px;
  color: #4D565E;
  display: inline-block;
}

#nav li a {
  display: block;
  font-size: 1.5rem;
  font-weight: bold;
  padding: 10px 15px;
  border-radius: 5px;
  text-align: center;
  text-decoration: none;
  color: white;
}

#nav li a:hover {
  background-color: #4D565E;
}

img {
  max-height: 200px;
  max-width: auto;
}

/* h1 {
  font-size: 40px;
  font-style: italic;
  font-family: 'Poppins', sans-serif;
  margin: 10px;
  text-align: left;
  flex-grow: 1;
} */

#button {
  margin-right: 2rem;
  display: flex;
  justify-content: flex-end;
}

</style>
