<template>
  <div class="greetings">
      <h4 class="grey">KNU MIT-21</h4>
      <h3 class="grey">Subject: Data Processing in IT</h3>
      <h3 class="grey">Name: Mikhail Melik-Kazarian</h3>
    <h1 class="green">Music Albums</h1>
  </div>
</template>

<style scoped>
h1 {
  font-weight: 500;
  font-size: 2.6rem;
  position: relative;
  top: -10px;
}
.grey {
  text-decoration: none;
  transition: 0.4s;
  padding: 0 0 0 1rem;
  color: #00f0ff;
}

h3 {
  font-size: 1.2rem;
}

.greetings h1,
.greetings h3 {
  text-align: center;
}

@media (min-width: 1024px) {
  .greetings h1,
  .greetings h3 {
    text-align: left;
  }
}
</style>
