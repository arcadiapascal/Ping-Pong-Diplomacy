<template>
  <div class="display-users">
      <tbody>
        <tr v-for="user in users" :key="user.id" class="user">
          <td>{{ user.id }}</td>
          <td>{{ user.name }}</td>
          <td>{{ user.email }}</td>
        </tr>
  </div>
</template>

<script>
import ContestService from '../services/ContestService.js';

export default {
  name: 'display-users',
  data() {
    return {
      users: []
    }
  },
  created(){
    ContestService.getUsers().then(response => {
      this.users = response.data;
    })
  }
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