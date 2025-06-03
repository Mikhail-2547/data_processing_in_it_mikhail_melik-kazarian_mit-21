<template>
    
    <h3 class="green">{{ isEditing ? "Edit Album" : "Add new Album" }}</h3>
    <form @submit.prevent="isEditing ? updateAlbum() : addAlbum()">
        <input class="input" v-model="currentAlbum.title" placeholder="Title" required />
        <input class="input" v-model="currentAlbum.author" placeholder="Author" required />
        <input class="input" v-model="currentAlbum.imageUrl" placeholder="Image URL" required />
        <button type="submit">{{ isEditing ? "Update" : "Add" }}</button>
        <button type="button" v-if="isEditing" @click="cancelEdit">Cancel</button>
    </form>

    <div class="albums">
        <div class="album" v-for="album in albums" :key="album.id">
            <img class="album-img" :src="album.imageUrl" alt="ALBUM_IMAGE" width="180" height="180" />
            <div class="album-info">
                <h2 class="green">{{ album.title }}</h2>
                <h3 class="grey">Author: {{ album.author }}</h3>
            </div>
            <div class="buttons">
                <button class="edit"   @click="editAlbum(album)">Edit</button>
                <button class="delete" @click="deleteAlbum(album.id)">Delete</button>
            </div>
        </div>
    </div>
</template>

<script setup>
    import { ref, onMounted } from 'vue';

    const albums = ref([]);
    const fetchAlbums = async () => {
        try {
            const response = await fetch('/albums');
            albums.value = await response.json();
        } catch (error) {
            console.error("Data receiving error: ", error);
        }
    };
    const currentAlbum = ref({ id: null, title: "", author: "", imageUrl:""});
    const isEditing = ref(false);

    const addAlbum = async () => {
        try {
            const response = await fetch('/albums/save_album', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(currentAlbum.value)
            });
            if (response.ok) {
                fetchAlbums();
                resetForm();
            }
        } catch (error) {
            console.error("Adding error: ", error);
        }
    };
    const editAlbum = (album) => {
        currentAlbum.value = { ...album };
        isEditing.value = true;
    };
    const updateAlbum = async () => {
        try {
            const response = await fetch(`/albums/update_album`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(currentAlbum.value),
            });
            if (response.ok) {
                fetchAlbums();
                resetForm();
            }
        } catch (error) {
            console.error("Updating error: ", error);
        }
    };
    const deleteAlbum = async (id) => {
        try {
            const response = await fetch(`/albums/delete_album/${id}`, { method: 'DELETE' });
            if (response.ok) fetchAlbums();
        } catch (error) {
            console.error("Deleting error: ", error);
        }
    };

    const resetForm = () => {
        currentAlbum.value = { id: null, title: "", author: "", imageUrl:""};
        isEditing.value = false;
    };

    const cancelEdit = () => {
        resetForm();
    };
    onMounted(fetchAlbums);
</script>
<style scoped>
.albums {
    margin: 1rem;
    padding: 1rem;
    display:flex;
    flex-wrap:wrap;
    border: 1px solid rgba(0,255,250,0.2);
}
.album {
    display: flex;
    border: 2px solid rgba(0,255,250,0.2);
    background-color: #000a0a;
    border-radius: 1rem;
    height: 250px;
    width: 450px;
    padding: 2rem;
    margin: 1rem;
}
.album-img {
    margin: auto 0;
    border-radius: 5px;
    border: 1px solid rgba(255,255,255,0.2);
    padding:1rem;
}
.album-info {
    display:flex;
    margin: auto 0;
    flex-direction:column;
    justify-content: center;
    text-align:center;
    width:100%;
    height:100%;
    margin-left: 2rem;
    /*border-radius: 5px;*/
    /*border: 1px solid rgba(255,255,255,0.2);*/
}
.buttons {
    display:flex;
    flex-direction:column;
}
.buttons *
{
    height:2rem;
    width:3.4rem;
    position:relative;
    cursor: pointer;
}
.edit {
    border-radius: 5px;
    border: 1px solid rgba(0,255,0,1);
    background-color: rgba(255,255,255,0.1);
    color: #00ff00;
}
.delete {
    margin-top:2.5rem;
    border-radius: 5px;
    border: 1px solid rgba(255,0,0,1);
    background-color: rgba(255,255,255,0.1);
    color: #ff0000;
}
.input {
    background-color: #1f1f1f;
    color: #ffffff;
    border:none;
}
form {
    border: 1px solid rgba(255,255,255,0.1);
    width:568px;
}

</style>
