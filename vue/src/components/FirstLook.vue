<template>
  <div class="container">
    <h1 class="title">Ping Pong Tournament Manager</h1>
    <div class="buttons">
      <router-link v-bind:to="{name: 'createTournament'}" class="btn btn-primary">Build a Tournament</router-link>
      <router-link to="/browse" class="btn btn-secondary">Join a Tournament</router-link>
    </div>
    <router-link :to="{ name: 'browse' }"> 
      <img src="../Assets/TE Paddles.png" alt="Ping Pong!">
    </router-link>
  </div>
</template>

<script>
export default {
  components: {},
};
</script>

<style>
img {
  margin: 2rem;
  max-height: 200px;
}
.container {
  height: 73vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background: linear-gradient(to bottom, #DAE8F2, #ffffff);
}

.title {
  color: #2b4f60;
  font-size: 3rem;
  text-align: center;
  margin-bottom: 2rem;
}

.buttons {
  display: flex;
  justify-content: center;
  align-items: center;
}

.btn {
  display: inline-block;
  padding: 1rem 2rem;
  border: none;
  border-radius: 0.25rem;
  text-align: center;
  text-decoration: none;
  font-size: 1rem;
  font-weight: bold;
  color: #fff;
  background-color: #FF6359;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  transition: background-color 0.3s ease-in-out;
}

.btn:hover {
  background-color: #4d565e;
}

.btn-primary {
  background-color: #FF6359;
  margin: 0.5rem;

}

.btn-secondary {
  background-color: #71D96F;
  margin: 0.5rem;  

}

@media screen and (max-width: 768px) {
  .title {
    font-size: 2rem;
  }

  .btn {
    font-size: 1rem;
    padding: 0.8rem 1.6rem;
  }
}
</style>