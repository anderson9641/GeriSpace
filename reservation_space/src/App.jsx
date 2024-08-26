
import Sidebar from "./components/Sidebar";
import "./App.css"

function App() {
  return (
    <>
      <div className="App">
        <Sidebar />
        <div>
          <h1>Welcome to my website</h1>
          <p>This is a simple sidebar example with React.</p>
        </div>
      </div>
    </>
  );
}

export default App;
