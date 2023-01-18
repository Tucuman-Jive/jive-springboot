import axios from "axios";
import React, { useEffect, useState, useRef } from "react";
import "./messages.css";
import "../messageBox/messagebox";
import DefaultImg from "./music-svgrepo-com.svg";
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
import { common } from "@mui/material/colors";
import UserButton from "../userbutton/userbutton";

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
    messagesEndRef.current.scrollIntoView({ behavior: "smooth" });
  };

  useEffect(() => {
    scrollToBottom();
  }, [messages]);

  const refreshPage = () => {
    window.location.reload();
  };

  const renderMessages = messages.map((message) => {
    if (message.userEntity.id === user.id)
      return (
        <Container>
          <Row>
            <Col></Col>
            <Col>
              <div
                key={message.id}
                className="col-md-6 border rounded p-3 mt-2 shadow bg-white"
                style={{
                  width: "100%",
                  // height: "70vh",
                  float: "right",
                  position: "relative",
                }}
              >
                <Container>
                  <Row className="float-end">
                    <Col md="auto">
                      <div
                        className="float-end"
                        style={{
                          width: "100%",
                          // height: "70vh",
                          position: "relative",
                        }}
                      >
                        <p className="text-primary m-0" align="right">
                          <font size="2">me</font>
                        </p>
                        <strong className="text-dark text-right m-0">
                          {message.message}
                        </strong>
                      </div>
                    </Col>
                    <Col md="auto">
                      <div className="float-end">
                        <img
                          src={DefaultImg}
                          width="60"
                          height="60"
                          class="d-inline-block align-top"
                          alt="default logo"
                        />
                      </div>
                    </Col>
                  </Row>
                </Container>
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
              key={message.id}
              className="col-md-6  border rounded p-3 mt-2 shadow bg-white"
              style={{
                width: "100%",
                // height: "70vh",
                float: "left",
                position: "relative",
              }}
            >
              <Container>
                <Row>
                  <Col md="auto">
                    <div>
                      <img
                        src={DefaultImg}
                        width="60"
                        height="60"
                        class="d-inline-block align-top"
                        alt="default logo"
                      />
                    </div>
                  </Col>
                  <Col>
                    <p className="text-primary m-0">
                      <font size="2">{message.userEntity.userName}</font>
                    </p>
                    <strong>{message.message}</strong>
                  </Col>
                </Row>
              </Container>
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
        <Row>
          <Col>
            <h2 className="m-0 p-1">{channel.name}</h2>
            <p className="m-0 p-1">{channel.description}</p>
          </Col>
          <Col>
            <div className="float-end m-3">
              <UserButton channel={channel} />
            </div>
          </Col>
        </Row>
        <div
          className="border rounded bg-dark bg-opacity-10"
          style={{
            overflow: "auto",
            width: "100%",
            height: "70vh",
            // float: "left",
            right: "8px",
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
