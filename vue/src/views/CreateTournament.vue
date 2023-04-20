<template>
  <div class="create">
    <h1>Create Your Tournament</h1>
    <h4>If you Dare</h4>
    <create-form />
    <bracket-generator /> <!-- Use 'bracket-generator' component as a Vue component -->
  </div>
</template>

<script>
import CreateForm from "../components/CreateForm.vue"
import BracketGenerator from "../components/bracketGenerator.vue" // Import the Bracket component with the correct name

export default {
  name: 'createTournament',
  components: {
    CreateForm,
    BracketGenerator // Register the Bracket component with the correct name
  }
}
</script>

<style scoped>

.create {
  height: 100vh;
  background: linear-gradient(to bottom, #DAE8F2, #ffffff);
}

h1 {
  text-align: center;
}
h4 {
  text-align: center;
}

</style>