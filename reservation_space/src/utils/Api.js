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
    
}
const insertEntityAndPaticipants = async (entity, listParticipants) =>{
  const mapIsResponsibleToEnum = (isResponsible)=>{
    return isResponsible ? 'RESPONSIBLE' : 'MEMBER'
  }
  
  const data = {
    name: entity,
    participants: listParticipants.map(participant => ({
      name: participant.name,
      isResponsible : mapIsResponsibleToEnum(participant.isResponsible),
    })) 
  }

  try {
    const response = await axios.post(baseUrlApi+"association",data);
    console.log('Associação criada com sucesso', data);
  } catch (error) {
    console.error('Error ao criar a associação', error)
  }
  
}
;
  
export default {getAssociation, insertEntityAndPaticipants};
