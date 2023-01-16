import axios from "axios";
import React, { useEffect, useState, useRef } from "react";
import "./messages.css";
import "../messageBox/messagebox";
import MessageBox from "../messageBox/messagebox";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import {
  BrowserRouter as Router,
  Link,
  Route,
  Routes,
  useParams,
} from "react-router-dom";

export default function Messages() {
  const [messages, setMessages] = useState([]);
  const [user, setUser] = useState([]);
  const [channel, setChannel] = useState([]);

  const userId = 1;

  const { id } = useParams();

  const messagesUrl = `http://localhost:8080/messages/all/channel/${id}`;
  const userUrl = "http://localhost:8080/users/" + userId;
  const channelUrl = `http://localhost:8080/channels/${id}`;

  const loadMessages = async () => {
    const result = await axios.get(messagesUrl);

    setMessages(result.data);
  };

  const loadUser = async () => {
    const result = await axios.get(userUrl);
    setUser(result.data);
  };

  const loadChannel = async () => {
    const result = await axios.get(channelUrl);
    setChannel(result.data);
  };

  useEffect(() => {
    loadMessages();
    loadChannel();
    loadUser();
    scrollToBottom();
  }, [useParams()]);

  const messagesEndRef = useRef(null);

  const scrollToBottom = () => {
    messagesEndRef.current.scrollIntoView({ behavior: "auto" });
  };

  useEffect(() => {
    scrollToBottom();
  }, [useParams()]);

  const renderMessages = messages.map((message) => {
    if (message.userEntity.id === user.id)
      return (
        <Container>
          <Row>
            <Col></Col>
            <Col>
              <div
                className="col-md-6 offset-md-1 border rounded p-4 mt-2 shadow"
                style={{
                  width: "100%",
                  height: "flex",
                  float: "right",
                  position: "relative",
                  // padding: "10px",
                }}
                key={message.id}
              >
                <strong>{message.message}</strong>
                <p className="text-primary" align="right">
                  me
                </p>
              </div>
            </Col>
          </Row>
        </Container>
      );
    return (
      <Container>
        <Row>
          <Col>
            <div
              className="col-md-6 offset-md-1 border rounded p-4 mt-2 shadow"
              key={message.id}
              style={{
                flex: "1",
                width: "100%",
                // height: "10vh",
                float: "left",
                position: "relative",
                // padding: "10px",
              }}
            >
              <strong>{message.message}</strong>
              <p className="text-primary">{message.userEntity.userName}</p>
            </div>
          </Col>
          <Col></Col>
        </Row>
      </Container>
    );
  });

  return (
    <div className="container">
      <div className="row">
        <h2>{channel.name}</h2>
        <p>{channel.description}</p>
        <div
          style={{
            overflow: "auto",
            width: "85%",
            height: "70vh",
            float: "left",
            position: "relative",
            padding: "10px",
          }}
        >
          {renderMessages}
          <div ref={messagesEndRef} />
        </div>

        <MessageBox user={user} channel={channel} />
      </div>
    </div>
  );
}
