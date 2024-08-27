
import Sidebar from "./components/Sidebar/Sidebar";
import "./App.css"
import Association from "./pages/Association";

function App() {
  return (
    <>
      <div className="App">
        <Sidebar />
        <div>
          <Association/>
          <h1>Welcome to my website</h1>
          <p>This is a simple sidebar example with React.</p>
        </div>
      </div>
    </>
  );
}

export default App;
