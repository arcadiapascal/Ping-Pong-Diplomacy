<template>
  <div>
     <form class="new-tournament-form" v-on:submit.prevent="addTournament">
      <div class="form-left">
        <label for="Tournament Name">Tournament Name</label>
        <input type="text" v-model="Tournament.name" /><br />
        <label for="Tournament Location">Location</label>
        <input class="author-input" type="text" v-model="Tournament.location" /><br />
        <label for="Tournament Address">Address</label>
        <input type="text" v-model="Tournament.address" /><br />
      </div>
      <div class="form-right">
        <label for="Tournament Date">Date</label>
        <input type="datetime-local" v-model="Tournament.date" /><br />
        <label for="Tournament Skill Level">Skill Level</label>
        <select required name="category" v-model="Tournament.skillLevel">
          <option value="Novice">Novice</option>
          <option value="Intermediate">Intermediate</option>
          <option value="Advanced">Advanced</option>
        </select>
           <label for=" Tournament Registration Deadline">Registration Deadline</label>
           <input  type="date" v-model="Tournament.registrationDeadline"><br>
           <!-- <label for=" Tournament Description">Description</label>
           <input  type="text" v-model="Tournament.description"><br> -->
           <input type="submit" value="Submit">
      </div>
       </form>
      </div>
</template>

<script>
import TournamentService from "../services/TournamentService.js";

export default {
    data() {
      return {
        currentUser: this.$store.state.user,
        Tournament: {
            
            name: "", 
            location:"",
            address:"",
            date:"",
            skillLevel:"",
            registrationDeadline:"",
            description: "",
            active: true,
            players: []
        },
        
      }
      
},
methods: {
          addTournament() {
                TournamentService.create(this.Tournament).then(response=> {
                    if(response.status === 201){
                        this.$router.push('/');
                    }
                }).catch(error => {
          if (error.response.status === 404) {
            this.$router.push("/404");
          } else {
            console.error(error);
          }
        });
          },
          
        }
}
</script>

<style>
.new-tournament-form {
  max-width: 900px; /* Increase the max-width to make the form wider */
  margin: 0 auto;
  display: flex; /* Add display:flex to enable flexbox layout */
  justify-content: space-between; /* Add justify-content to space the form elements */
  padding: 20px;
  background-color: #fff;
  border-radius: 4px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}

.new-tournament-form label {
  font-weight: bold;
  margin-top: 10px;
  display: block;
  width: 50%; /* Set the width of the label to 50% to align with the input fields */
}

.new-tournament-form input[type="text"],
.new-tournament-form input[type="date"],
.new-tournament-form input[type="datetime-local"],
.new-tournament-form select {
  width: 100%; /* Set the width of the input fields to 100% */
  padding: 8px;
  margin-top: 5px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  font-size: 16px;
}

.new-tournament-form .form-left { /* Add a class for the left part of the form */
  width: 48%; /* Set the width of the left part to 48% to allow for spacing */
}

.new-tournament-form .form-right { /* Add a class for the right part of the form */
  width: 48%; /* Set the width of the right part to 48% to allow for spacing */
}

.new-tournament-form input[type="submit"] {
  background-color: #00adee;
  color: #fff;
  padding: 10px 15px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  margin-top: 20px; /* Add margin to the submit button to separate it from the other fields */
}

label {
  font-weight: bold;
  margin-top: 10px;
  display: block;
}

input[type="text"],
input[type="date"],
input[type="datetime-local"],
select {
  width: 100%;
  padding: 8px;
  margin-top: 5px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  font-size: 16px;
}

input[type="submit"] {
  background-color: #00adee;
  color: #fff;
  padding: 10px 15px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

input[type="submit"]:hover {
  background-color: #2b4f60;
}

.new-tournament-form select {
  appearance: none;
  -webkit-appearance: none;
  -moz-appearance: none;
  background-color: #dae8f2;
  background-image: url("data:image/svg+xml;charset=utf-8,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24'%3E%3Cpath d='M7 10l5 5 5-5z'/%3E%3C/svg%3E");
  background-repeat: no-repeat;
  background-position: right 10px center;
  background-size: 12px;
  padding-right: 30px;
}

.new-tournament-form select::-ms-expand {
  display: none;
}

.new-tournament-form input:focus,
.new-tournament-form select:focus {
  outline: none;
  border: 1px solid #00adee;
  box-shadow: 0 0 10px #00adee80;
}

.new-tournament-form input.error,
.new-tournament-form select.error {
  border: 1px solid #ff6359;
}

.new-tournament-form label.error {
  color: #ff6359;
  font-size: 14px;
  font-weight: normal;
  margin-top: 5px;
  display: block;
}

.new-tournament-form input.error:focus,
.new-tournament-form select.error:focus {
  border: 1px solid #ff6359;
  box-shadow: 0 0 10px #ff635980;
}

.new-tournament-form input::placeholder,
.new-tournament-form select::placeholder {
  color: #556268;
}

</style>
