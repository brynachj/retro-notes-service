<template>
    <div class="note">
        <h1>{{note.title}}</h1>
        <p>{{note.content}}</p>
    </div>
</template>
<script>
export default {
    name: 'Note',
    props: {
        note: {
            type: Object,
            default: () => {
                return {
                    title: "error, no title",
                    content: "error, no content"
                }
            }
        }
    }
}
</script>
