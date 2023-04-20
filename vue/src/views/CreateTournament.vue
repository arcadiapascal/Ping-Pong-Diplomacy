<template>
  <div class="create">
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
  background: linear-gradient(to bottom, #DAE8F2, #ffffff);
}

</style>