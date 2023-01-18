import React, { useEffect, useState, useRef } from "react";
import Modal from "react-bootstrap/Modal";
import axios from "axios";
import {
  BrowserRouter as Router,
  Link,
  Route,
  Routes,
  useParams,
} from "react-router-dom";
import Button from "react-bootstrap/esm/Button";

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

export default function RemoveChannel() {
  const [channel, setChannel] = useState([]);
  const [show, setShow] = useState(false);

  const { id } = useParams();

  const channelUrl = `http://localhost:8080/channels/${id}`;

  const deleteChannel = async () => {
    axios.delete(channelUrl);
    console.log("deleted?");
  };

  const refreshPage = () => {
    window.location.reload();
  };

  const loadChannel = async () => {
    const result = await axios.get(channelUrl);
    setChannel(result.data);
  };

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  useEffect(() => {
    loadChannel();
  }, [useParams()]);

  return (
    <>
      <Link onClick={handleShow}>{channel.name}</Link>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Delete {channel.name} ?</Modal.Title>
        </Modal.Header>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Cancel
          </Button>
          <Button variant="danger" onClick={deleteChannel}>
            Delete Channel
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}
