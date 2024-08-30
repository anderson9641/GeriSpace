
import { useState } from 'react';
import './RequerinteCreate.css'
import api from '../../utils/Api'

const RequerinteCreate = ()=>{
   

   
        const [associationName, setAssociationName] = useState('');
        const [participants, setParticipants] = useState([{ name: '', isResponsible: false }]);
    
        const handleAddParticipant = () => {
            setParticipants([...participants, { name: '', isResponsible: false }]);
        };
    
        const handleRemoveParticipant = (index) => {
            const updatedParticipants = participants.filter((_, i) => i !== index);
            setParticipants(updatedParticipants);
        };
    
        const handleParticipantChange = (index, event) => {
            const { name, value, type, checked } = event.target;
            console.log(event)
            const updatedParticipants = participants.map((participant, i) => {
                if (i === index) {
                    return {
                        ...participant,
                        [name]: type === 'checkbox' ? checked : value
                    };
                }
                return participant;
            });
    
            // Se o checkbox "isResponsible" for marcado, desmarcar os outros
            if (name === 'isResponsible' && checked) {
                updatedParticipants.forEach((participant, i) => {
                    if (i !== index) participant.isResponsible = false;
                });
            }
    
            setParticipants(updatedParticipants);
        };
    
        const handleSubmit = (event) => {
            event.preventDefault();
            api.insertEntityAndPaticipants(associationName,participants)
            //console.log({ associationName, participants });
            // Aqui você pode enviar os dados ao backend ou processá-los conforme necessário
        };
    
        return (
            <div className="form-container">
                <h2>Inserir nova entidade</h2>
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label htmlFor="associationName">Nome da entidade:</label>
                        <input
                            type="text"
                            id="associationName"
                            name="associationName"
                            value={associationName}
                            onChange={(e) => setAssociationName(e.target.value)}
                            required
                        />
                    </div>
                    <div className='ContainerParticipantes'>
                    <div className='HeaderParticipantes'>

                    <h3>Participantes</h3>
                    <button type="button" onClick={handleAddParticipant}>
                        Adicionar Participante
                    </button>
                    </div>

                    {participants.map((participant, index) => (
                        <div key={index} className="form-group">
                            <input
                                type="text"
                                name="name"
                                placeholder={`Nome do Participante ${index + 1}`}
                                value={participant.name}
                                onChange={(e) => handleParticipantChange(index, e)}
                                required
                                />
                            <label>
                                <input
                                    type="checkbox"
                                    name="isResponsible"
                                    checked={participant.isResponsible}
                                    onChange={(e) => handleParticipantChange(index, e)}
                                    />
                                Responsável
                            </label>
                            {index > 0 && (
                                <button type="button" onClick={() => handleRemoveParticipant(index)}>
                                    Remover
                                </button>
                            )}
                        </div>
                    ))}
                            </div>
                    <div className="form-group">
                        <button type="submit">Criar Associação</button>
                    </div>
                </form>
            </div>
        );
    }
    
    
    
export default RequerinteCreate;