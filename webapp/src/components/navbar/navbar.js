import React from "react";
import logo from "./pngegg.png";

export default function navbar() {
  return (
    //position: fixed
    <div style={{ width: "100%" }}>
      <nav className="navbar navbar-expand-lg bg-dark">
        <div className="container-fluid">
          <a className="text-light navbar-brand" href="#">
            <img
              src={logo}
              width="30"
              height="30"
              class="d-inline-block align-top"
              alt=""
            ></img>
            Jive Communication App
          </a>
          <button className="btn btn-sm btn-outline-info" type="button">
            Add User
          </button>

          {/* <button className="btn btn-outline-light">Add User</button> */}
        </div>
      </nav>
    </div>
  );
}