<template>
  <div class="container">
    <h1 class="title">Ping Pong Tournament Manager</h1>
    <div class="buttons">
      <router-link to="/createtournament" class="btn btn-primary">Build a Tournament</router-link>
      <router-link to="/browse" class="btn btn-secondary">Join a Tournament</router-link>
    </div>
  </div>
</template>

<script>
export default {
  components: {},
};
</script>

<style>
.container {
  height: 75vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #dae8f2;
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
  margin: 0.5rem;
  border: none;
  border-radius: 0.25rem;
  text-align: center;
  text-decoration: none;
  font-size: 1.2rem;
  font-weight: bold;
  color: #fff;
  background-color: #00adee;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  transition: background-color 0.3s ease-in-out;
}

.btn:hover {
  background-color: #4d565e;
}

.btn-primary {
  background-color: #00adee;
}

.btn-secondary {
  background-color: #2b4f60;
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