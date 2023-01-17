import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import axios from "axios";

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

export default function ViewUsers() {
  const [users, setUsers] = useState([]);
  const [show, setShow] = useState(false);

  const refreshPage = () => {
    window.location.reload();
  };

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8080/users/all");

    setUsers(result.data);
  };

  useEffect(() => {
    loadUsers();
  }, []);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  return (
    <>
      <Link
        className="text-light"
        style={{ textDecoration: "none" }}
        onClick={handleShow}
      >
        <div>
          <h2 className="m-0">Band: The Algorhythmics</h2>(
          {Object.keys(users).length} members)
        </div>
      </Link>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Band members</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          {users.map((user) => (
            <p>{user.userName}</p>
          ))}
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}
