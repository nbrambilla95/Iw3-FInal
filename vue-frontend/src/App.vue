<template>
  <div id="App">
    <Main_navigator />
    <!-- <Camion />
    <Producto />
    <Chofer />
    <Orden />
    <Login /> -->

  </div>
</template>

<script>
import Camion from './components/Camion.vue'
import Producto from './components/Producto.vue'
import Chofer from './components/Chofer.vue'
import Orden from './components/Orden.vue'
import Login from './components/Login.vue'
import Main_navigator from './components/Main_navigator.vue'


export default {
  name: 'App',
  components: {
    Main_navigator
    // Camion,
    // Producto,
    // Chofer,
    // Orden,
    // Login
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
