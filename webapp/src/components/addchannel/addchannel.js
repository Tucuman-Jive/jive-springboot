import React, { useState, useEffect } from "react";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";

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

function PostButton() {
  const [description, setDescription] = useState("");
  const [name, setName] = useState("");

  const userId = 1;

  const createChannelURL =
    "http://localhost:8080/channels/add/button/" + userId;

  const handleSubmit = (e) => {
    e.preventDefault();

    const payload = { name, description };

    fetch(createChannelURL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(payload),
    }).then(() => {
      console.log("New channel created");
    });

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
      <Button variant="btn btn-outline-light" onClick={handleShow}>
        New Gig
      </Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Compose a Gig!</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <form onSubmit={handleSubmit}>
            <label style={{ textAlign: "left", display: "block" }}>
              Gig Name
            </label>
            <input
              value={name}
              required
              onChange={(e) => setName(e.target.value)}
              style={styles.textbox}
            ></input>
            <label style={{ textAlign: "left", display: "block" }}>
              Add a description!
            </label>
            <input
              type="text"
              style={styles.textbox}
              value={description}
              onChange={(e) => setDescription(e.target.value)}
            />
          </form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Cancel
          </Button>
          <Button variant="primary" onClick={handleSubmit}>
            Add Channel
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default PostButton;
