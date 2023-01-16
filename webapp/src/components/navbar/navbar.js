import React from "react";
import logo from "./pngegg.png";
import PostButton from "../addchannel/addchannel";
import { Link } from "react-router-dom";

export default function navbar() {
  return (
    //position: fixed
    <div style={{ width: "100%" }}>
      <nav className="navbar navbar-expand-lg bg-dark">
        <div className="container-fluid">
          <a className="text-light navbar-brand" href="/">
            <img
              src={logo}
              width="60"
              height="60"
              class="d-inline-block align-top"
              alt="Jive Logo"
            ></img>
          </a>
          <p className="text-white" align="left"></p>
          {/* <Link
            className="btn btn-sm btn-outline-primary"
            type="button"
            to="/adduser"
          >
            Add User
          </Link> */}
          <PostButton />
          {/* <button className="btn btn-outline-light">Add User</button> */}
        </div>
      </nav>
    </div>
  );
}
