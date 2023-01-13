import "./App.css";
import Messages from "./components/messages/messages";
import "bootstrap/dist/css/bootstrap.css";
import Sidebar from "./components/sidebar/sidebar";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {
  return (
    <div>
      <Sidebar />
      <Routes>
        <Route path="/messages/:id" element={<Messages />} />
      </Routes>
    </div>
  );
}

export default App;
