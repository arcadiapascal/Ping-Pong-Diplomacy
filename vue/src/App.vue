<template>
  <div class="app">
    <nav-bar />
    <router-view />
  </div>
</template>

<script>
import NavBar from "./components/NavBar.vue";
export default {
name: 'app',
components: {
  NavBar
}
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Permanent+Marker&family=Poppins:wght@700&family=Quicksand&display=swap');

.app {
  background-color:#DAE8F2;
  height: 100vh
}

body {
  margin: 0px;
  font-family: 'Quicksand', sans-serif;
  
}

h1 {
  font-size: 40px;
  /* font-style: italic; */
  font-family: 'Poppins', sans-serif;
  margin: 10px;
}
h2 {
  font-family: 'Quicksand', sans-serif;
}
h3 {
  /* font-style: italic; */
  font-family: 'Poppins', sans-serif;
}
h4 {
  font-family: 'Quicksand', sans-serif;
}
h5 {
  font-family: 'Poppins', sans-serif;
}
h6 {
  font-family: 'Quicksand', sans-serif;
}
p {
  font-family: 'Quicksand', sans-serif;
}

</style>
