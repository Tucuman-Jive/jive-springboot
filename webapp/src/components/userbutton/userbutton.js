import React, { useState, useEffect } from "react";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import { useParams } from "react-router-dom";
import axios from "axios";
import Dropdown from "react-bootstrap/Dropdown";

const styles = {
  textbox: {
    width: "100%",
    padding: "6px 10px",
    margin: "10px 0",
    border: "1px solid black",
    borderRadius: "8px",
    boxSizing: "border-box",
    display: "block",
  },
};

function UserButton({ channel }) {
  const [name, setName] = useState("");
  const [members, setMembers] = useState([]);
  const [description, setDescription] = useState("");

  const userId = 1;

  const { id } = useParams();

  const getMembersURL =
    "http://localhost:8080/members/all/channel/" + channel.id;

  const loadMembers = async () => {
    const result = await axios.get(getMembersURL);
    setMembers(result.data);
  };

  useEffect(() => {
    loadMembers();
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();

    setShow(false);

    setDescription("");
    setName("");

    refreshPage();
  };

  const refreshPage = () => {
    window.location.reload();
  };

  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  useEffect(() => {
    const keyDownHandler = (e) => {
      if (e.key === "Enter") {
        e.preventDefault();

        handleSubmit(e);
      }
    };

    document.addEventListener("keydown", keyDownHandler);

    return () => {
      document.removeEventListener("keydown", keyDownHandler);
    };
  }, [handleSubmit]);

  return (
    <>
      <Button variant="btn btn-outline-dark" onClick={handleShow}>
        Users
      </Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Users</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          {members.map((member) => (
            <div key={member.userEntity.id}>{member.userEntity.userName}</div>
          ))}
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={handleSubmit}>
            Add User
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default UserButton;
