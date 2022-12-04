<template>
    Input Token Generated:<input id="input_token" type="text" v-model="token" v-if="!requestComplete" />
    <button id="id_button_productos" @click="getProductos" v-if="!requestComplete">
        Get productos
    </button>

    <div class="container" v-if="productos.length > 0">
        <h1 class="text-center"> Lista de Productos</h1>

        <table class="table table-striped table-bordered">
            <thead>
                <th>Producto ID</th>
                <th>Producto Nombre</th>
                <th>Producto Descripcion</th>
            </thead>
            <tbody>
                <tr v-for="producto in productos" v-bind:key="producto.id">
                    <td> {{ producto.id }} </td>
                    <td> {{ producto.nombre }} </td>
                    <td> {{ producto.descripcion }} </td>
                </tr>
            </tbody>
        </table>

    </div>
</template>

<script>
import ProductoService from '@/services/ProductoService';

export default {
    name: '',
    data() {
        return {
            productos: [],
            token: '',
            requestComplete: false,
        }
    },
    computed: {
        requestComplete() {
            return this.requestComplete;
        },
    },
    methods: {
        async getProductos() {
            try {
                // Obtener un token llamando al método "getTokens" importado

                // Llamar al método "getCamiones" del servicio de camión, pasando el token como un parámetro
                this.productos = await ProductoService.getProductos(this.token);
                this.requestComplete = true;
            } catch (error) {
                console.error(error);
            }
        }
    },
    // created(){
    //     this.getProductos()
    // }

}

</script>

<style>

</style>