<template>
    <div class="edit">
        <h2>Edit Tournament</h2>
        <edit-form />
      
    </div>
</template>

<script>
import EditForm from "../components/EditForm.vue"


export default {
    name: 'editTournament',
    components: {
        EditForm
    }
}
</script>