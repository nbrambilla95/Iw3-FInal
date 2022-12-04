import axios from 'axios'

const LOGIN_API_BASE_URL = 'http://localhost:8080/api/v1/login'

//ASI ESTA BIEN INTENTA NO TOCAR NADA!!!

class LoginService {
    async getTokens(username, password) {
      try {
        // Enviar los parámetros en la solicitud POST
        const response = await axios.post(LOGIN_API_BASE_URL, {}, {
            params: {
              username: username,
              password: password
            }
          });

        // Devolver el token generado
        console.log(response.data)

        return response.data;
      } catch (error) {
        throw error;
      }
    }
  }

export default new LoginService()