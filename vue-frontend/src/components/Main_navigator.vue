<template>
  <div>
    <div>
      <!-- Aquí se cargará el componente seleccionado en la barra de navegación -->
      <Navbar @selectComponent="selectedComponent = $event" />
      <!-- <Camion v-if="selectedComponent === 'Camion'" />
      <Chofer v-if="selectedComponent === 'Chofer'" />
      <Orden v-if="selectedComponent === 'Orden'" /> -->

      <component :is="selectedComponent"></component>
      <footer class="footer"
        style="position: fixed; bottom: 0; background-color: #333; color: green; width: 100%; padding: 15px; text-align: center;">
        <a href="http://localhost:8080/swagger-ui/index.html" target="_blank" style="color: white; text-decoration: underline;">Link al Swagger
          UI</a>
      </footer>
    </div>
  </div>

</template>

<script>
import Navbar from './Navbar.vue';
import Camion from './Camion.vue';
import Orden from './Orden.vue';
import Chofer from './Chofer.vue';
import Login from './Login.vue';
import Producto from './Producto.vue';
import OrdenById from './OrdenById.vue';




export default {
  name: 'MainPage',
  components: {
    Navbar,
    Camion,
    Orden,
    Chofer,
    Login,
    Producto,
    OrdenById
  },
  data() {
    return {
      selectedComponent: '', // Aquí se almacenará el nombre del componente seleccionado
    };
  },
  mounted() {
    // Por defecto, se cargará el componente 1
    this.selectedComponent = 'Login';
  },
  methods: {
    // Esta función se llamará desde la barra de navegación para cambiar el componente cargado
    selectComponent(componentName) {
      this.selectedComponent = componentName;
    },
  },
};
</script>

<style>
footer {
  background-color: #333;
  color: #fff;
  font-size: 16px;
  margin: 32px 0;
  padding: 32px;
}
</style>