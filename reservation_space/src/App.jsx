
import Sidebar from "./components/Sidebar/Sidebar";
import "./App.css"
import Association from "./pages/Association";
import { useState } from "react";

function App() {

  const [isOpen, setIsOpen] = useState(false);

  const toggleSidebar = () => {
    setIsOpen(!isOpen);
  };
  return (
    <>
      <div className="App">
        <Sidebar isOpen={isOpen} toggleSidebar={toggleSidebar}/>
        <div className={`content ${isOpen ? "open" : ""}`}> 
        <h1>Welcome to my website</h1>
        <h3>Essa é uma lista dos Solicitantes</h3>
          <Association />
          
        </div>
      </div>
    </>
  );
}

export default App;
