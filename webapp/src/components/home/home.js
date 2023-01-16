import React from "react";
import Logo from "../navbar/pngegg.png";

export default function home() {
  return (
    <div className="container">
      <div className="row">
        <div className="col md-6 offset-md-1 border rounded p-2 mt-2 ">
          <h1>Jive</h1>
          <p>
            Welcome to Jive, the ultimate web app for bands on the go! With
            Jive, you can stay connected and organized with your bandmates like
            never before. Our app allows you to easily schedule and manage
            practices, gigs, and shows, all in one place. No more endless text
            threads or cluttered email chains - Jive keeps all your important
            information in one convenient location. But Jive is a complete
            communication platform. You can share videos, sheet music, and other
            multimedia content with your bandmates, and even have real-time
            conversations through our built-in chat feature. So why wait? Sign
            up for Jive today and take control of your band's communication and
            organization. With Jive, you'll never miss a beat.
          </p>
          <h5>Contributors</h5>
          <p>
            <a href="https://github.com/Emory-Miller" target="_blank">
              Emory Miller
            </a>
          </p>
          <p>
            <a href="https://github.com/cdiazgranados" target="_blank">
              Carolina Diazgranados
            </a>
          </p>
          <p>
            <a href="https://github.com/DanJCasey" target="_blank">
              Dan Casey
            </a>
          </p>
          <h5>More details</h5>

          <p>
            Final project for{" "}
            <a href="https://www.zipcodewilmington.com" target="_blank">
              {" "}
              Zip Code Wilmington
            </a>{" "}
            built utilizing React, Java, and Spring Boot. <br></br>
            <a
              href="https://github.com/Tucuman-Jive/jive-springboot"
              target="_blank"
            >
              Source code
            </a>
          </p>
        </div>
        <div className="col md-6">
          <a href="https://jive.co.za/" target="_blank">
            <img src={Logo}></img>
          </a>
        </div>
      </div>
    </div>
  );
}
