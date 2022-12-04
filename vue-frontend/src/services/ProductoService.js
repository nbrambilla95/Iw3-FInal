import axios from 'axios'

const PRODUCTO_API_BASE_URL = 'http://localhost:8080/api/v1/productos'

class ProductoService {
    async getProductos(token) {
      try {
  
        const response = await axios.get(PRODUCTO_API_BASE_URL, {
          headers: {
             'Authorization': `Bearer ${token}`
          }
        });
  
        return response.data;
      } catch (error) {
        throw error;
      }
    }
  }
  
  export default new ProductoService();