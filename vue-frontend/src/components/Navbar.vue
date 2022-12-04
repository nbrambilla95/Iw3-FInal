<!-- Navbar.vue -->


<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="#">Navbar</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#" id="navbarDropdown" role="button" aria-haspopup="true" aria-expanded="false"
              @click="selectComponent('Login')">
              Generate Token
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="#" id="navbarDropdown" role="button" aria-haspopup="true" aria-expanded="false"
              @click="selectComponent('Camion')">
              Camion
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="#" id="navbarDropdown" role="button" aria-haspopup="true" aria-expanded="false"
              @click="selectComponent('Chofer')">
              Chofer
            </a>
          </li>

          <li class="nav-item active">
            <a class="nav-link" href="#" id="navbarDropdown" role="button" aria-haspopup="true" aria-expanded="false"
              @click="selectComponent('Orden')">
              Orden
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="#" id="navbarDropdown" role="button" aria-haspopup="true" aria-expanded="false"
              @click="selectComponent('OrdenById')">
              Orden By ID
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="#" id="navbarDropdown" role="button" aria-haspopup="true" aria-expanded="false"
              @click="selectComponent('Producto')">
              Producto
            </a>
          </li>

        </ul>
        
      </div>
    </nav>

    <!-- llamar a los componentes aquí -->
    <!-- <Camion /> -->
    <!-- <Chofer />
    <Orden /> -->
  </div>
</template>

<!-- <template>
  <nav>
    <a @click="selectComponent('Camion')">Sección 1</a>
    <a @click="selectComponent('Orden')">Sección 2</a>
    <a @click="selectComponent('Chofer')">Sección 3</a>
  </nav>
</template> -->

<script>
import Login from '@/components/Login.vue';
import Camion from '@/components/Camion.vue';
import Chofer from '@/components/Chofer.vue';
import Orden from '@/components/Orden.vue';
import Producto from '@/components/Producto.vue';


export default {
  name: "Navbar",
  methods: {
    // Esta función emitirá un evento para que el componente padre (MainPage) cambie el componente cargado
    selectComponent(componentName) {
      this.$emit("selectComponent", componentName);
    },
  },
  components: { Login, Camion, Chofer, Orden, Producto }
};
</script>

<style>

</style>
