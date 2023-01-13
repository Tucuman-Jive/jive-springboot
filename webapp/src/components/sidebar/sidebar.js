import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

export default function Sidebar() {
  // const [channels, setChannels] = useState([]);

  const [membership, setMembership] = useState([]);

  const [dms, setDms] = useState([]);

  // useEffect(() => {
  //   loadChannels();
  // }, []);

  useEffect(() => {
    loadMembership();
  }, []);

  useEffect(() => {
    loadDms();
  }, []);

  const loadDms = async () => {
    const result = await axios.get("http://localhost:8080/members/dms/user/1");
    setDms(result.data);
  };

  const loadMembership = async () => {
    const result = await axios.get(
      "http://localhost:8080/members/channels/user/1"
    );
    setMembership(result.data);
  };

  // const loadChannels = async () => {
  //   const result = await axios.get("http://localhost:8080/channels/all");
  //   setChannels(result.data);
  // };

  return (
    <Container>
      <Col>
        <h1>Gigs</h1>
        {membership.map((membership) => (
          <Link className="nav-link" to={`messages/${membership.channel.id}`}>
            {membership.channel.name}
          </Link>
        ))}
        <h1>Solos</h1>
        {dms.map((membership) => (
          <Link className="nav-link" to={`messages/${membership.channel.id}`}>
            {membership.channel.name}
          </Link>
        ))}
      </Col>
      <Col></Col>
      <Col></Col>
    </Container>
  );
}
