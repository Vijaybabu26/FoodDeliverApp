import React from "react";
import ReactDOM from "react-dom/client";
import Dasboard from "./Component/Dashboard";
var htmlRoot = document.getElementById("root");
var rootReact = ReactDOM.createRoot(htmlRoot);

const App = () =>{
  return (
    <div className="App">
      <Dasboard/>
    </div>
  );
}

export default App;
rootReact.render(<App/>);