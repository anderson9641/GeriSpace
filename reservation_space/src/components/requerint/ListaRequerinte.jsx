
import './ListeRequerinte.css'

const ListaRequerinte = ({associations}) =>{
    
    return (
        <div className='list'>
            {/* Renderizando a lista de associações */}
            {associations && associations.length > 0 ? (
                associations.map((association) => (
                    <div key={association.cod} className="association-item">
                        <span>{association.name}</span>
                        <div className='botoes'>
                            <button>edit</button>
                            <button>view</button>
                            <button>delete</button>
                        </div>
                    </div>
                ))
            ) : (
                <p>Nenhuma associação encontrada.</p>
            )}
        </div>
    );

}

export default ListaRequerinte;