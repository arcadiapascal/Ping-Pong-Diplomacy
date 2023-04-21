<template>
  <div id="login">
    <form @submit.prevent="login">
      <h1 >Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign in</button>
      <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
  #login {
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 100vh;
    background: linear-gradient(to bottom, #DAE8F2, #ffffff);
    padding: 2rem;
  }

  form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100%;
    max-width: 400px;
    padding: 1rem;
    border: 1px solid #ccc;
    border-radius: 8px;
    box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.1);
    background-color: #fff;
  }

  h1 {
    font-size: 2rem;
    margin-bottom: 1.5rem;
  }

  .form-input-group {
    display: flex;
    flex-direction: column;
    margin-bottom: 1rem;
  }

  label {
    font-size: 1.2rem;
    margin-bottom: 0.5rem;
    font-weight: bold;
    text-align: left;
  }

  input[type="text"],
  input[type="username"],
  input[type="password"] {
    font-size: 1.2rem;
    padding: 0.5rem;
    width: 100%;
    margin-bottom: 0.5rem;
    box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.3);
  }
  

  button[type="submit"] {
  display: block;
  padding: 1rem 2rem;
  border: none;
  border-radius: 0.25rem;
  text-align: center;
  text-decoration: none;
  font-size: 1rem;
  font-weight: bold;
  color: #fff;
  background-color: #00adee;
  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.3);
  transition: background-color 0.3s ease-in-out;
  margin: 0 auto;
  cursor: pointer;
  }

  button[type="submit"]:hover {
    background-color: #4d565e;
  }

  p {
    margin-top: 1rem;
    font-size: 1.2rem;
    text-align: center;
  }

  a {
    color: #00adee;
    text-decoration: none;
    font-weight: bold;
  }

  a:hover {
    text-decoration: underline;
  }

  [role="alert"] {
    background-color: #f44336;
    color: #fff;
    padding: 0.5rem;
    border-radius: 4px;
    margin-bottom: 1rem;
    font-size: 1.2rem;
  }
</style>
