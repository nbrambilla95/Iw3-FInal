<template>
  <div style="display: flex; justify-content: center;" v-if="!requestComplete">
    <button id="id_button_token" @click="getTokens" class="btn btn-primary">Solicitar Token</button>

    <label for="input_username">Usuario: </label>
    <input type="text" id="input_username" v-model="username">

    <label for="input_password">Constrasenia: </label>
    <input type="password" id="input_password" v-model="password">

  </div>

  <p v-if="error" class="error-message">{{ error }}</p>


  <!-- Añadir un <label> para mostrar el token -->
  <label id="label_token" v-if="requestComplete">Token: {{ token }}</label>

</template>

<script>
import LoginService from '@/services/LoginService'

export default {
  name: '',

  data() {
    return {
      username: '',
      password: '',
      token: "",
      requestComplete: false,
      error: null

    }
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

<style>
#id_button_token {
  display: flex;
  justify-content: center;
}

#label_token {
  display: block;
  margin-top: 50px;
  border: 1px solid black;
  content: 'Token:';
}

.error-message {
  color: red;

  border: 1px solid rgb(255, 0, 0);
  display: block;
}
</style>