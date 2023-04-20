<template>
<div>
  <odd-bracket/>
  <tournament/>
</div>
</template>

<script>
import OddBracket from '../components/OddBracket.vue'
import Tournament from '../components/Tournament.vue'
export default {
  components: { 
      Tournament,
      OddBracket
      }
      
  

}
</script>

<style>


</style>