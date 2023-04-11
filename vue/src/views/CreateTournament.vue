<template>
    <div class="create">
        <h1>Create A Tournament</h1>
        <create-form />
        <bracket />
        <player-list />
    </div>
</template>

<script>
import CreateForm from "../components/CreateForm.vue"
import Bracket from "../components/Bracket.vue"
import PlayerList from "../components/PlayerList.vue"

export default {
    name: 'createTournament',
    components: {
        CreateForm,
        Bracket,
        PlayerList
    }
}
</script>