<template>
    <div>
        <h1>Gadget control system</h1>

        <h3>{{ isEditing ? "Edit Gadget" : "Add new Gadget" }}</h3>
        <form @submit.prevent="isEditing ? updateGadget() : addGadget()">
            <input v-model="currentGadget.model" placeholder="Name" required />
            <input v-model="currentGadget.imageUrl" placeholder="Image URL" required />
            <input v-model="currentGadget.description" placeholder="Description" required />
            <input v-model="currentGadget.type" placeholder="Type" required />
            <input v-model="currentGadget.Brand" placeholder="Brand" required />
            <button type="submit">{{ isEditing ? "Update" : "Add" }}</button>
            <button type="button" v-if="isEditing" @click="cancelEdit">Cancel</button>
        </form>
        
        <h3>Gadget list</h3>
        <ul>
            <li v-for="gadget in gadgets" :key="gadget.id">
                <h3>{{ gadget.model }}</h3>
                <img :src="gadget.imageUrl" alt="Gadget Image" width="150" />
                <p>{{ gadget.description }}</p>
                <p>Type: {{ gadget.type }}</p>
                <p>Brand: {{ gadget.Brand }}</p>
                <button @click="editGadget(gadget)">Edit</button>
                <button @click="deleteGadget(gadget.id)">Delete</button>
            </li>
        </ul>
    </div>
</template>

<script setup>
    import { ref, onMounted } from 'vue';

    const gadgets = ref([]);
    const currentGadget = ref({ id: null, model: "", imageUrl: "", description: "", type: "", Brand: "" });
    const isEditing = ref(false);

    const fetchGadgets = async () => {
        try {
            const response = await fetch('/gadgets');
            gadgets.value = await response.json();
        } catch (error) {
            console.error("Data receiving error: ", error);
        }
    };

    const addGadget = async () => {
        try {
            const response = await fetch('/gadgets', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(currentGadget.value)
            });
            if (response.ok) {
            fetchGadgets();
            resetForm();
            }
        } catch (error) {
            console.error("Adding error: ", error);
        }
    };

    const editGadget = (gadget) => {
        currentGadget.value = { ...gadget };
        isEditing.value = true;
    };

    const updateGadget = async () => {
        try {
            const response = await fetch(`/gadgets?id=${currentGadget.value.id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(currentGadget.value),
            });
            if (response.ok) {
                fetchGadgets();
                resetForm();
            }
        } catch (error) {
            console.error("Updating error: ", error);
        }
    };

    const deleteGadget = async (id) => {
        try {
            const response = await fetch(`/gadgets?id=${id}`, { method: 'DELETE' });
            if (response.ok) fetchGadgets();
        } catch (error) {
            console.error("Deleting error: ", error);
        }
    };

    const resetForm = () => {
        currentGadget.value = { id: null, model: "", imageUrl: "", description: "", type: "", Brand: "" };
        isEditing.value = false;
    };

    const cancelEdit = () => {
        resetForm();
    };
    
    onMounted(fetchGadgets);
</script>
