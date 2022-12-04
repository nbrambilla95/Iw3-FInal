import axios from 'axios'

const CHOFER_API_BASE_URL = 'http://localhost:8080/api/v1/choferes'

class ChoferService {
  async getChoferes(token) {
    try {

      const response = await axios.get(CHOFER_API_BASE_URL, {
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

export default new ChoferService();