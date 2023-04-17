<template>
  <div class="pingpong-facts">
    <div class="fact-container">
      <h2>{{ fact }}</h2>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      facts: [
        "Ping pong is also known as table tennis",
        "Ping pong was invented in England in the 1800s",
        "The International Table Tennis Federation was founded in 1926",
        "Ping pong was introduced as an Olympic sport in 1988",
        "The world's largest ping pong tournament had over 8,000 players",
        "The fastest recorded ping pong serve was 70 mph"
      ],
      fact: ""
    };
  },
  mounted() {
    this.generateFact();
    setInterval(this.generateFact, 7000);
  },
  methods: {
    generateFact() {
      const randomIndex = Math.floor(Math.random() * this.facts.length);
      this.fact = this.facts[randomIndex];
    }
  }
};
</script>

<style scoped>
.pingpong-facts {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 50px;
  background-color: #c4d8e2;
  padding: 20px;
  border-radius: 10px;
}

.fact-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background-color: white;
  height: 50px; /* Updated height */
  width: 800px;
  border-radius: 10px;
}

h2 {
  font-size: 24px;
  text-align: center;
  padding: 20px;
}
</style>