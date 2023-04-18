<template>
    <div class="create">
        <ping-pong-game />
        <h2>Create A Tournament</h2>
        <create-form />
      
    </div>
</template>

<script>
import CreateForm from "../components/CreateForm.vue"
import PingPongGame from '../components/pingPongGame.vue'


export default {
    name: 'createTournament',
    components: {
        CreateForm,
        PingPongGame
    }
}
</script>
