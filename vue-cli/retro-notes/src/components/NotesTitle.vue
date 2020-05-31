<template>
  <div class="hello">
    <h1>{{msg}}</h1>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello {
  color: rgb(2, 174, 239);
  height: 150px;
  background-color: rgb(86,40, 115);
}
h1{ 
  margin: 0;
}
</style>
