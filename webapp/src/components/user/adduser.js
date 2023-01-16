import React from "react";

export default function AddUser() {
  // const [user, setUser] = useState("");
  // const [data, setData] = useState("");

  // const loadUser = async () => {};

  // const pickUser = async () => {
  //   const result = await axios.get("http://localhost:8080/users/all");
  //   setData(result.data);
  //   data.forEach((result) => {
  //     if (user == result.userName) {
  //       setUser(result);
  //     }
  //   });
  // };

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
