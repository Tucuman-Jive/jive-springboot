import React, { useState, useEffect } from "react";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import { useParams } from "react-router-dom";
import axios from "axios";
import Dropdown from "react-bootstrap/Dropdown";
import ListGroup from "react-bootstrap/ListGroup";

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
  const [members, setMembers] = useState([]);
  const [notMembers, setNotMembers] = useState([]);
  const [eOption, setEOption] = useState("");
  const [optionValue, setOptionValue] = useState("");

  const userId = 1;

  const { id } = useParams();

  const getMembersURL =
    "http://localhost:8080/members/all/channel/" + channel.id;

  const addMemberURL =
    "http://localhost:8080/members/add/users/" +
    eOption.value +
    "/channels/" +
    channel.id;

  const options = {
    url: addMemberURL,
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json;charset=UTF-8",
    },
    data: {},
  };

  const postNewMember = () =>
    axios(options).then((response) => {
      console.log(response.status);
    });

  const loadMembers = async () => {
    const result = await axios.get(getMembersURL);
    setMembers(result.data);
  };

  const getNotMembersURL =
    "http://localhost:8080/members/all/notchannel/" + channel.id;

  const loadNotMembers = async () => {
    const result = await axios.get(getNotMembersURL);
    setNotMembers(result.data);
  };

  useEffect(() => {
    loadMembers();
  }, [channel, eOption]);

  useEffect(() => {
    loadNotMembers();
  }, [channel, eOption]);

  const handleSubmit = (e) => {
    e.preventDefault();

    setEOption(document.getElementById("dropdown"));

    console.log(eOption.value);
    postNewMember();

    setShow(false);

    loadMembers();
    loadNotMembers();

    // refreshPage();
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
        Gig Members
      </Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Gig Members</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <ListGroup>
            {members.map((member) => (
              <div key={member.userEntity.id}>
                <ListGroup.Item>{member.userEntity.userName}</ListGroup.Item>
              </div>
            ))}
          </ListGroup>
        </Modal.Body>
        <Modal.Footer>
          <select class="form-select" id="dropdown">
            <option selected defaultValue="">
              Select new Member
            </option>
            {notMembers.map((notMember) => (
              <option value={notMember.id}>{notMember.userName}</option>
            ))}
          </select>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={handleSubmit}>
            Add Member
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default UserButton;
