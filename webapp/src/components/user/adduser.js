import React from "react";

export default function home() {
  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m4">Login User</h2>
          <div className="mb-3">
            <label htmlFor="Name" className="form-label">
              username
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Enter your username"
              name="name"
            />
          </div>
          <button type="submit" className="btn btn-outline-primary">
            Submit
          </button>
        </div>
      </div>
    </div>
  );
}
