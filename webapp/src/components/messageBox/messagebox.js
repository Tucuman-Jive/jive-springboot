import axios from "axios";
import React, { useEffect, useState, useRef } from "react";
import Button from "react-bootstrap/Button";

export default function MessageBox({ user, channel }) {
  const [message, setMessage] = useState("");

  const postMessageUrl =
    "http://localhost:8080/messages/add/user/" +
    user.id +
    "/channel/" +
    channel.id;

  const options = {
    url: postMessageUrl,
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json;charset=UTF-8",
    },
    data: {
      message: message,
      channel: {
        id: channel.id,
        name: channel.name,
      },
      userEntity: {
        id: user.id,
        userName: user.userName,
      },
    },
  };

  const postMessage = () =>
    axios(options).then((response) => {
      console.log(response.status);
    });

  const refreshPage = () => {
    window.location.reload();
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    postMessage();
    refreshPage();
  };

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

  const renderBox = () => {
    return (
      <form align="center">
        <div
          className="input-group"
          style={{
            padding: "10px",
            position: "absolute",
            width: "70%",
            bottom: "20px",
            top: "auto",
            left: "350px",
          }}
        >
          <input
            className="form-control"
            type={"text"}
            value={message}
            required
            onChange={(e) => setMessage(e.target.value)}
          ></input>
          <Button
            onClick={handleSubmit}
            className="btn btn-outline"
            variant="dark"
          >
            jive!
          </Button>
        </div>
      </form>
    );
  };

  return <div>{renderBox()}</div>;
}
