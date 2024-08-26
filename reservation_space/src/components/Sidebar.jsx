import { useState } from "react";
import "./Sidebar.css"; // Vamos criar este arquivo para estilizar o componente

const Sidebar = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggleSidebar = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div className={`sidebar ${isOpen ? "open" : ""}`}>
      <div className="hamburger" onClick={toggleSidebar}>
        <div className={`line ${isOpen ? "open" : ""}`}></div>
        <div className={`line ${isOpen ? "open" : ""}`}></div>
        <div className={`line ${isOpen ? "open" : ""}`}></div>
      </div>
      <nav className="menu">
        <a href="#">Home</a>
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
