import { useEffect,useState } from "react";
import Api from '../utils/Api'
import './Associations.css'


const Association = () =>{

    const [associations,setAssociations] = useState([]);

    useEffect(()=>{
        async function getAssociation(){
            const result = await Api.getAssociation()
            setAssociations(result)
            console.log(result)
        } 
        getAssociation()
        
    },[])

    return(
        <>
        <div className="content">

        {associations && associations.map((association) =>(
            <div key={association.cod} className="association">
                <div>{association.name}</div>
                <div>{association.participants.map((member) => (
                    <div key={member.codParticipant} className="members">
                        <div>{member.nameParticipant}</div>
                    </div>
                ))}</div>
            </div>
        )
    )} 
    </div>
        </>
    )
}
export default Association;