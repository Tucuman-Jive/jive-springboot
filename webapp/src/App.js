import "./App.css";
import Messages from "./components/messages/messages";
import "bootstrap/dist/css/bootstrap.css";
import Bar from "./components/sidebar/sidebar";
import Navbar from "./components/navbar/navbar";
import Layout from "./components/layout";
import Adduser from "./components/user/adduser";
import Home from "./components/Home/home";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {
  return (
    <div>
      <Navbar />
      <div style={{ display: "flex", height: "100%", alignContent: "stretch" }}>
        <Bar />
        <Layout />

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/adduser" element={<Adduser />} />
          <Route path="/messages/:id" element={<Messages />} />
        </Routes>
      </div>
    </div>
  );
}

export default App;
