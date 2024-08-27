import { useState } from "react";
import "./Sidebar.css"; // Vamos criar este arquivo para estilizar o componente
import Api from  '../../utils/Api'




const Sidebar = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggleSidebar = () => {
    setIsOpen(!isOpen);
  };

  const allAssociation = () => {
    Api.getAssociation();
  }
 

  return (
    <div className={`sidebar ${isOpen ? "open" : ""}`}>
      <div className="hamburger" onClick={toggleSidebar}>
        <div className={`line ${isOpen ? "open" : ""}`}></div>
        <div className={`line ${isOpen ? "open" : ""}`}></div>
        <div className={`line ${isOpen ? "open" : ""}`}></div>
      </div>
      <nav className="menu">
        <a onClick={allAssociation}>Home</a>
        <a href="#">Associações</a>
        <a href="#">Espaços</a>
        <a href="#">Reservas</a>
        <a href="#">Sobre</a>
        <a href="#">Contatos</a>
      </nav>
    </div>
  );
};

export default Sidebar;
