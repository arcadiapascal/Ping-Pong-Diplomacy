<template>
  <div>
    <h1>PADDLE ME?</h1>
    <div class="row">
      <div class="button-container">
        <button @click="activeComponent = 'TournamentAndHostComponent'" :class="{ active: activeComponent === 'TournamentAndHostComponent' }">Tournaments</button>
        <button @click="activeComponent = 'StatsComponent'" :class="{ active: activeComponent === 'StatsComponent' }">Players</button>
        <button @click="activeComponent = 'TeamComponent'" :class="{ active: activeComponent === 'TeamComponent' }">Teams</button>
      </div>
    </div>
    <component :is="activeComponent"/>
  </div>
</template>

<script>
import TournamentAndHostComponent from '../components/TournamentAndHostComponent.vue';
import TeamComponent from './teamComponent.vue';
import StatsComponent from '../components/statsComponent.vue'


export default {
  components: {
    TournamentAndHostComponent,
    StatsComponent,
    TeamComponent
  },
  data() {
    return {
      activeComponent: 'TournamentAndHostComponent',
    };
  },
};
</script>

<style>
.row {
  display: flex;
  flex-direction: row;
  justify-content: center;
  background-color: #eee;
}

button {
  padding: 8px 12px;
  border-radius: 4px;
  border: none;
  font-size: 16px;
  background-color: #eee;
  border-spacing: 20px;
  cursor: pointer;
}
button.active {
  background-color: #ccc;
}
</style>