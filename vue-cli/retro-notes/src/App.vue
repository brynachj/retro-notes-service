<template>
  <div id="app">
    <NotesTitle msg="Welcome to Retro-Notes"></NotesTitle>
    <NotesDisplay :notes="notes"></NotesDisplay>
    <NoteInput></NoteInput>
  </div>
</template>

<script>
import NotesTitle from './components/NotesTitle.vue'
import NotesDisplay from './components/NotesDisplay.vue'
import NoteInput from './components/NoteInput.vue'
import axios from 'axios';

export default {
  name: 'app',
  data: function() {
    return {
      notes:[]
    }
  },
  components: {
    NotesTitle,
    NotesDisplay,
    NoteInput
  },
  methods: {
    fetchNotes() {
      const url = 'http://localhost:8080/api/notes';

      axios.get(url)
        .then(response => {
          this.notes = response.data;
        })
    }
  },
  created() {
    this.fetchNotes()
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center; 
  margin-top: 0px;
}
</style>
