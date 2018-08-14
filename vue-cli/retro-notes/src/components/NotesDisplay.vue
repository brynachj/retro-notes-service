<template>
    <div id="notesList">
        <ol>
            <li v-for="note in notes" v-bind:key="note.id">
                <Note :note="note"></Note>
            </li>
        </ol>
    </div>
</template>

<script>
import Note from './Note.vue';

export default {
  name: 'NotesDisplay',
  props: {
      notes: Array
  },
  components: {
      Note
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
