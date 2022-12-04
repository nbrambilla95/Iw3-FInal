<template>
  <form @submit.prevent="login" class="container" v-if="!requestComplete">
    <div class="form-row">
      <div class="form-group col-md-15">
        <label for="email">Nombre de usuario:</label>
        <input id="email" type="email" v-model="username"/>
      </div>

      <div class="form-group col-md-15">
        <label for="password" >Contraseña:</label>
        <input id="password" type="password" v-model="password" />
      </div>
      <div class="form-row">
      <div class="form-group col-md-15">
        <button type="submit" @click="getTokens" >Iniciar
          sesión</button>
      </div>
    </div>
  </div>
  </form>

  <p v-if="error" class="error-message">{{ error }}</p>
  <!-- Añadir un <label> para mostrar el token -->
  <label id="label_token" v-if="requestComplete">Token: {{ token }}</label>
</template>


<script>
import LoginService from '@/services/LoginService';


export default {
  name: 'LoginForm',
  data() {
    return {
      username: '',
      password: '',
      token: "",
      requestComplete: false,
      error: null
    };
  },
  methods: {
    async getTokens() {
      try {
        if (!this.username || !this.password) {
          this.error = 'Debes ingresar un nombre de usuario y una contraseña';
          return;
        }

        this.token = await LoginService.getTokens(this.username, this.password);

        this.requestComplete = true;

        return this.token
      } catch (error) {
        this.error = error;

        console.error(error);
      }
    }
  }
};
</script>