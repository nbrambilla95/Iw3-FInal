import axios from 'axios'

const ORDEN_API_BASE_URL = 'http://localhost:8080/api/v1/ordenes'



class OrdenService {
    async getOrdenes(token) {
      try {
  
        const response = await axios.get(ORDEN_API_BASE_URL, {
          headers: {
             'Authorization': `Bearer ${token}`
          }
        });
  
        return response.data;
      } catch (error) {
        throw error;
      }
    }
    async getOrdenesById(id, token) {
      try {
  
        const response = await axios.get(`${ORDEN_API_BASE_URL}/${id}`, {
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
  
  export default new OrdenService();