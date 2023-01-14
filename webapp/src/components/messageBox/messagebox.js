import axios from "axios";
import React, { useEffect, useState, useRef } from "react";

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

  const renderBox = () => {
    return (
      <form align="center">
        <div className="input-group">
          <input
            className="form-control"
            type={"text"}
            value={message}
            required
            onChange={(e) => setMessage(e.target.value)}
          ></input>
          <button onClick={handleSubmit} className="btn btn-outline-primary ">
            Post
          </button>
        </div>
      </form>
    );
  };

  return <div>{renderBox()}</div>;
}
