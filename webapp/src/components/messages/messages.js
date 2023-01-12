import axios from "axios";
import React, { useEffect, useState, useRef } from "react";
import "./messages.css";
import "../MessageBox/messagebox";
import MessageBox from "../MessageBox/messagebox";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

export default function Messages() {
  const [messages, setMessages] = useState([]);
  const [user, setUser] = useState([]);
  const [message, setMessage] = useState("");
  const [channel, setChannel] = useState([]);

  const messagesUrl = "http://localhost:8080/messages/all/channel/1";
  const userUrl = "http://localhost:8080/users/1";
  const postMessageUrl = "http://localhost:8080/messages/add/user/1/channel/1";
  const channelUrl = "http://localhost:8080/channels/1";

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
  }, []);

  useEffect(() => {
    loadUser();
  }, []);

  useEffect(() => {
    loadChannel();
  }, []);

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
        <Container>
          <Row>
            <Col></Col>
            <Col>
              <div className="message_right">
                <p>
                  <strong>{message.message}</strong>
                </p>
                <p>me!</p>
                <br />
              </div>
            </Col>
          </Row>
        </Container>
      );
    return (
      <Container>
        <Row>
          <Col></Col>
          <Col>
            <div className="message_left">
              <strong>{message.message}</strong>
              <p>{message.userEntity.userName}</p>
              <br />
            </div>
          </Col>
          <Col></Col>
        </Row>
      </Container>
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
