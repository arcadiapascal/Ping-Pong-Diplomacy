<template>
  <div class="display-users">
    <h2>Users</h2>
      <tbody>
        <tr v-for="user in users" :key="user.id" class="user">
          <td>{{ user.id }}</td>
          <td>{{ user.username }}</td>
          <td>{{ user.email }}</td>
        </tr>
      </tbody>
  </div>
</template>

<script>
import ProfileService from '../services/ProfileService.js';

export default {
  name: 'display-users',
  data() {
    return {
      users: []
    }
  },
  created(){
    ProfileService.listProfiles().then(response => {
      console.log(response.data);
      this.users = response.data;
    }).catch(error => {
      console.error(error);
    })
  },
  // methods: {
  // displayUsers() {
  //           const list = document.getElementById('users');
  //           this.users.forEach((item) => {
  //               const li = document.createElement('li');
  //               li.innerText = item;
  //               list.appendChild(li);
  //           });
  //       }
  // }
}
</script>

<style>
.topic-list {
  padding: 20px 20px;
  margin: 0 auto;
  max-width: 600px;
}
.topic {
  font-size: 24px;
  border-bottom: 1px solid #f2f2f2;
  padding: 10px 20px;
}
.topic:last-child {
  border: 0px;
}

</style>