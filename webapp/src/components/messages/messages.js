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

  const { id } = useParams();

  const messagesUrl = `http://localhost:8080/messages/all/channel/${id}`;
  const userUrl = "http://localhost:8080/users/2";
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
  }, [messages]);

  // useEffect(() => {
  //   loadUser();
  // }, []);

  // useEffect(() => {
  //   loadChannel();
  // }, []);

  const messagesEndRef = useRef(null);

  const scrollToBottom = () => {
    messagesEndRef.current.scrollIntoView({ behavior: "smooth" });
  };

  useEffect(() => {
    scrollToBottom();
  }, []);

  const renderMessages = messages.map((message) => {
    if (message.userEntity.id === user.id)
      return (
        // <Container>
        //   <Row>
        //     <Col></Col>
        //     <Col>
        <div className="message_right">
          <strong>{message.message}</strong>
          <p>me</p>
          <br />
        </div>
        //     </Col>
        //   </Row>
        // </Container>
      );
    return (
      //  <Container>
      //    <Row>
      //       <Col>
      <div className="message_left">
        <strong>{message.message}</strong>
        <p>{message.userEntity.userName}</p>
        <br />
      </div>
      //     </Col>
      //    <Col></Col>
      //   </Row>
      //   </Container>
    );
  });

  return (
    <div>
      {renderMessages}
      <MessageBox user={user} channel={channel} />
      <div ref={messagesEndRef} />
    </div>
  );
}
