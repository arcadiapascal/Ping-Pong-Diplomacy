<template>
    <div class="create">
        <h2>Create A Tournament</h2>
        <oddBracket/>
      
    </div>
</template>

<script>

import OddBracket from '../components/OddBracket.vue'



export default {
    name: 'createTournament',
    components: {
        OddBracket
    }
}
</script>
