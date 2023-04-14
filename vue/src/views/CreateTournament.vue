<template>
    <div class="create">
        <h2>Create A Tournament</h2>
        <create-form />
      
    </div>
</template>

<script>
import CreateForm from "../components/CreateForm.vue"


export default {
    name: 'createTournament',
    components: {
        CreateForm
    }
}
</script>