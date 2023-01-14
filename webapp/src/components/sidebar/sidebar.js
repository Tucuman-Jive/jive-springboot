import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { Sidebar, Menu, MenuItem, SubMenu } from "react-pro-sidebar";

const Bar = () => {
  const [membership, setMembership] = useState([]);

  const [dms, setDms] = useState([]);

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
    console.log(result.data);
    setMembership(result.data);
  };

  return (
    <div style={{ display: "flex", height: "100%" }}>
      <Sidebar style={{ height: "100vh" }}>
        <Menu>
          <SubMenu label="Gigs">
            {membership.map((membership) => (
              <MenuItem>
                <Link
                  className="nav-link"
                  to={`messages/${membership.channel.id}`}
                >
                  {membership.channel.name}
                </Link>
              </MenuItem>
            ))}
          </SubMenu>
          <SubMenu label="Solo Messages">
            {dms.map((membership) => (
              <MenuItem>
                <Link
                  className="nav-link"
                  to={`messages/${membership.channel.id}`}
                >
                  {membership.channel.name}
                </Link>
              </MenuItem>
            ))}
          </SubMenu>
        </Menu>
      </Sidebar>
    </div>
  );

  // return (
  //   <Container>
  //     <Col>
  //       <h1>Gigs</h1>
  //       {membership.map((membership) => (
  //         <Link className="nav-link" to={`messages/${membership.channel.id}`}>
  //           {membership.channel.name}
  //         </Link>
  //       ))}
  //       <h1>Solos</h1>
  //       {dms.map((membership) => (
  //         <Link className="nav-link" to={`messages/${membership.channel.id}`}>
  //           {membership.channel.name}
  //         </Link>
  //       ))}
  //     </Col>
  //     <Col></Col>
  //     <Col></Col>
  //   </Container>
  // );
};

export default Bar;
