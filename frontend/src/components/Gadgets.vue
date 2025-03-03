<template>
    <div v-if="gadget">
        <h2>{{ gadget.model }}</h2>
        <img :src="gadget.imageUrl" alt="GADGET_IMAGE" style="max-width: 300px;">
        <p>Type: {{ gadget.type }}</p>
        <p>Description: {{ gadget.description }}</p>
        <p>Brand: {{ gadget.Brand }}</p>
</div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
const gadget = ref(null);
onMounted(async () => {
    const response = await fetch('/gadgets');
    gadget.value = await response.json();
});
</script>