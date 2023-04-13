<template>
    <div class="edit">
        <h1>Edit Tournament</h1>
        <edit-form />
      
        <player-list />
    </div>
</template>

<script>
import EditForm from "../components/EditForm.vue"
import PlayerList from "../components/PlayerList.vue"

export default {
    name: 'editTournament',
    components: {
        EditForm,
        PlayerList
    }
}
</script>