<template>
    <div class="browse">
        <browse />
        <search />
    </div>
</template>

<script>
import Browse from '../components/Browse.vue';
import Search from '../components/Search.vue';

export default {
    name: 'browse',
    components: {
        Browse,
        Search
    }
}
</script>