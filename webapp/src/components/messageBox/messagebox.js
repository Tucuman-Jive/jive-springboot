import axios from "axios";
import React, { useEffect, useState, useRef } from "react";

export default function MessageBox({ user, channel }) {
  // const [user, setUser] = useState([]);
  const [message, setMessage] = useState("");
  // const [channel, setChannel] = useState([]);

  const userUrl = "http://localhost:8080/users/1";
  const postMessageUrl = "http://localhost:8080/messages/add/user/1/channel/1";
  const channelUrl = "http://localhost:8080/channels/1";

  // const loadUser = async () => {
  //   const result = await axios.get(userUrl);
  //   setUser(result.data);
  // };

  // const loadChannel = async () => {
  //   const result = await axios.get(channelUrl);
  //   setChannel(result.data);
  // };

  // useEffect(() => {
  //   loadUser();
  // }, []);

  // useEffect(() => {
  //   loadChannel();
  // }, []);

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
      <form>
        <textarea
          value={message}
          required
          onChange={(e) => setMessage(e.target.value)}
        ></textarea>
        <button onClick={handleSubmit}>Post</button>
      </form>
    );
  };

  return <div>{renderBox()}</div>;
}
