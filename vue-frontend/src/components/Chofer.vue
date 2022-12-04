<template>
    Input Token Generated:<input id="input_token" type="text" v-model="token" v-if="!requestComplete" />
    <button id="id_button_choferes" @click="getChoferes" v-if="!requestComplete">
        Get choferes
    </button>

    <div class="container" v-if="choferes.length > 0">
        <h1 class="text-center mb-3"> Lista de Choferes</h1>

        <table class="table table-striped table-bordered">
            <thead>
                <th>Chofer ID</th>
                <th>Chofer Nombre</th>
                <th>Chofer Apellido</th>
                <th>Chofer Documento</th>
            </thead>
            <tbody>
                <tr v-for="chofer in choferes" v-bind:key="chofer.id">
                    <td> {{ chofer.id }} </td>
                    <td> {{ chofer.nombre }} </td>
                    <td> {{ chofer.apellido }} </td>
                    <td> {{ chofer.documento }} </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>
<script>

import ChoferService from '@/services/ChoferService';

export default {
    name: '',
    data() {
        return {
            choferes: [],
            token: '',
            requestComplete: false
        }
    },
    methods: {

        async getChoferes() {
            try {
                // Obtener un token llamando al método "getTokens" importado

                // Llamar al método "getCamiones" del servicio de camión, pasando el token como un parámetro
                this.choferes = await ChoferService.getChoferes(this.token);
                this.requestComplete = true;
            } catch (error) {
                console.error(error);
            }
        }
    },
    // created(){
    //      this.getCamiones()
    // }

}

</script>

<style>

</style>