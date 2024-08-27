import axios from "axios";

const baseUrlApi = "http://127.0.0.1:8080/";


  const getAssociation = async () => {
    //const response =
    try {
      const response = await axios.get(baseUrlApi + "association")
      return response.data
    } catch (error) {
      console.error("erro ao buscar associações",error)
      return []
    }
    
};
  
export default {getAssociation};
