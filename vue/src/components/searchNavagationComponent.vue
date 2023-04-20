<template>
  <div>
    <!-- <time-till-next-tournament/> -->
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
// import timeTillNextTournament from '../components/timeTillNextTournament.vue'

export default {
  components: {
    TournamentAndHostComponent,
    StatsComponent,
    // timeTillNextTournament
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
  margin-top: 2rem;
}

button {
  display: inline-block;
  padding: 1rem 2rem;
  border: none;
  border-radius: 0.25rem;
  text-align: center;
  text-decoration: none;
  font-size: 1rem;
  font-weight: bold;
  color: #fff;
  background-color: #00ADEE;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  transition: background-color 0.3s ease-in-out;
  cursor: pointer;
}

button:hover {
  background-color: #4d565e;
}
</style>