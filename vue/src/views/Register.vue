<template>
  <div id="register" class="text-center">
    <div class="registration form">
    <form @submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <button type="submit">Create Account</button>
      <p><router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
  </div>
  <div>
    <player-registration/>
  </div>
 
    
    </div>
</template>

<script>
import authService from '../services/AuthService';
import PlayerRegistration from "../components/playerRegistration"

export default {
  components: {
    PlayerRegistration
},
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$store.state.userName = this.username;
              this.$router.push("/register/1");
              this.registerlogin();
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
    registerlogin() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/register/1");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
 }
  },
   
 

}
</script>

<style scoped>
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
  input[type="password"] {
    font-size: 1.2rem;
    padding: 0.5rem;
    border-radius: 0.3rem;
    border: none;
    border-bottom: 2px solid #ccc;
    box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.3);
  }

  input[type="text"]:focus,
  input[type="password"]:focus {
    outline: none;
    border-bottom-color: #888;
  }

  button[type="submit"] {
    margin-top: 1rem;
    padding: 0.5rem 1.5rem;
    font-size: 1.2rem;
    color: #fff;
    background-color: #00adee;
    border: none;
    border-radius: 0.3rem;
    cursor: pointer;
    box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.3);
  }

  button[type="submit"]:hover {
    background-color: #4d565e;
  }

  #register {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 25px;
    font-size: 1.2rem;
    box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.3);
    padding: 20px;
    border-radius: 5px;
    background: linear-gradient(to bottom, #DAE8F2, #ffffff);
  }

  h1 {
    margin-bottom: 1rem;
    font-size: 2rem;
  }

  p {
    margin-top: 1rem;
    font-size: 1rem;
    color: #888;
  }

  router-link {
    color: #00adee;
  }

  router-link:hover {
    text-decoration: underline;
  }

  [role="alert"] {
    margin-bottom: 1rem;
    color: #f44336;
    font-size: 1rem;
    font-weight: bold;
  }
</style>

