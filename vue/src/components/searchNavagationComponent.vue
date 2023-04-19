<template>
  <div>
    <div class="row">
      <div class="button-container">
        <button v-if="activeComponent === 'StatsComponent'" @click="activeComponent = 'TournamentAndHostComponent'" :class="{ active: activeComponent === 'TournamentAndHostComponent' }">Click to see upcoming Tournaments!</button>
        <button v-if="activeComponent === 'TournamentAndHostComponent'" @click="activeComponent = 'StatsComponent'" :class="{ active: activeComponent === 'StatsComponent' }">Click to see a our top players!</button>
      </div>
    </div>
    <component :is="activeComponent"/>
  </div>
</template>

<script>
import TournamentAndHostComponent from '../components/TournamentAndHostComponent.vue';
// import TeamComponent from './teamComponent.vue';
import StatsComponent from './statsComponent.vue'


export default {
  components: {
    TournamentAndHostComponent,
    StatsComponent,
    // TeamComponent
  },
  data() {
    return {
      activeComponent: 'TournamentAndHostComponent',
    };
  },
};
</script>

<style scoped>
.row {
  display: flex;
  flex-direction: row;
  justify-content: center;
  background-color: white;
  margin-top: 2rem;
}

button {
  padding: 8px 12px;
  margin: 0.5rem;
  border-radius: 4px;
  border: none;
  font-size: 16px;
  color: white;
  font-weight: bold;
  background-color: #00ADEE;
  border-spacing: 20px;
  cursor: pointer;
  width: 2000px;
}

button:hover {
  background-color: #6f777a;
  opacity: 80%;
}
</style>