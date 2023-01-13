import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function Sidebar() {
  const [channels, setChannels] = useState([]);
  useEffect(() => {
    loadChannels();
  }, []);
  const loadChannels = async () => {
    const result = await axios.get("http://localhost:8080/channels/all");
    setChannels(result.data);
  };

  return (
    <div className="row">
      <div className="col-sm-2">
        {/* <nav className="navbar navbar-expand-lg navbar-light"> */}
        {channels.map((channel, index) => (
          <Link className="nav-link" to={`messages/${channel.id}`}>
            {channel.name}
          </Link>
        ))}
      </div>
      {/* </nav> */}
    </div>
  );
}
