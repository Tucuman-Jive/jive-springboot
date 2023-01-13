import React from "react";
import Bar from "./sidebar/sidebar";
import Messages from "./messages/messages";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

export default function layout() {
  return (
    <div style={{ width: "20px" }}>
      <Row>
        <div style={{ width: "100%" }}>
          <Col>{Messages}</Col>
        </div>
      </Row>
    </div>
  );
}
