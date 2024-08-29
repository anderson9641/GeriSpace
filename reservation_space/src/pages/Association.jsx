import { useEffect,useState } from "react";
import Api from '../utils/Api'
import './Associations.css'
import Lista from '../components/requerint/ListaRequerinte'
import RequerinteCreate from "./requerinte/RequirinteCreate";


const Association = ({isOpen,toggleSidebar}) =>{

    const [associations,setAssociations] = useState([]);

    useEffect(()=>{
        async function getAssociation(){
            const result = await Api.getAssociation()
            setAssociations(result)
            
        } 
        getAssociation()
        
    },[])

    return(
        <RequerinteCreate/>

           /*  <Lista  associations={associations} />      */  
       
        
         
        
    )
}
export default Association;