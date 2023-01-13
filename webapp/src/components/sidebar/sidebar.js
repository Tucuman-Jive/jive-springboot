import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

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
    <Container>
      <Col>
        {channels.map((channel, index) => (
          <Link className="nav-link" to={`messages/${channel.id}`}>
            {channel.name}
          </Link>
        ))}
      </Col>
      <Col></Col>
      <Col></Col>
    </Container>
  );
}
