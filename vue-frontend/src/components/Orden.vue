<template>

    Input Token Generated:<input id="input_token" type="text" v-model="token" v-if="!requestComplete" />
    <button id="id_button_ordenes" @click="getOrdenes" v-if="!requestCompleteOrdenes">
        Get ordenes
    </button>

    <div class="container" v-if="ordenes.length > 0">
        <h1 class="text-center"> Lista de Ordenes</h1>

        <table class="table table-striped table-bordered">
            <thead>
                <th>ID</th>
                <th>Fecha Recepcion</th>
                <th>Fecha Recepcion Pesaje Inicial</th>
                <th>Fecha Fin de Carga</th>

                <th>[Cliente]Razon social</th>
                <th>[Cliente]Contacto</th>


                <th>[Producto]Nombre</th>

                <th>[Camion]Patente</th>

                <th>[Camion]Cisternado</th>


                <th>[Chofer]Nombre</th>
                <th>[Chofer]Apellido</th>
                <th>[Chofer]Documento</th>


                <th>Estado de la orden</th>


            </thead>
            <tbody>
                <tr v-for="orden in ordenes" v-bind:key="orden.id">
                    <td> {{ orden.id }} </td>
                    <td> {{ orden.fechaRecepcion }} </td>
                    <td> {{ orden.fechaRecepcionPesajeInicial }} </td>
                    <td> {{ orden.fechaFinCarga }} </td>

                    <!-- <td> {{ orden.cliente }} </td> -->
                    <td> {{ orden.cliente.razonSocial }} </td>
                    <td> {{ orden.cliente.contacto }} </td>


                    <td> {{ orden.producto.nombre }} </td>

                    <td> {{ orden.camion.patente }} </td>
                    <td> {{ orden.camion.cisternado }} </td>


                    <td> {{ orden.chofer.nombre }} </td>
                    <td> {{ orden.chofer.apellido }} </td>
                    <td> {{ orden.chofer.documento }} </td>


                    <td> {{ orden.estado }} </td>


                </tr>
            </tbody>
        </table>

    </div>
</template>

<script>
import OrdenService from '@/services/OrdenService';

export default {
    name: '',
    data() {
        return {
            ordenes: [],
            token: '',
            requestCompleteOrdenes: false,
            requestCompleteOrdenesById: false,
            id: '',

        }
    },
    methods: {
        async getOrdenes() {
            try {
                // Obtener un token llamando al método "getTokens" importado

                // Llamar al método "getCamiones" del servicio de camión, pasando el token como un parámetro
                this.ordenes = await OrdenService.getOrdenes(this.token);
                this.requestCompleteOrdenes = true;
            } catch (error) {
                console.error(error);
            }
        },
        async getOrdenesById() {
            try {
                // Obtener un token llamando al método "getTokens" importado

                // Llamar al método "getOrdenesById" del servicio de orden, pasando el id y el token como parámetros
                this.orden = await OrdenService.getOrdenesById(this.id, this.token);
                this.requestCompleteOrdenesById = true;
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
.container {
    margin: 0 auto;
}
</style>