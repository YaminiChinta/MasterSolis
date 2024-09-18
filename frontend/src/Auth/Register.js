import React, { useState } from "react";
import "./login.css";
import { Link } from "react-router-dom";

const Register = () => {

    return (
      <div className="col-md-12 mainContainer">
      <div>
          <h1>Sign Up</h1>
          <p className="textField">please enter details to continue</p>
      </div>
      <form>
          <div className="form-group">
              <label for="inputEmailorPhnNum" className="labelStyle">First Name : </label>
              <input type="email" className="form-control emailtextField" id="inputEmailorPhnNum" placeholder="Enter email"/>
          </div>
          <div className="form-group">
              <label for="inputEmailorPhnNum" className="labelStyle">Last Name : </label>
              <input type="email" className="form-control emailtextField" id="inputEmailorPhnNum" placeholder="Enter email"/>
          </div>
          <div className="form-group">
              <label for="inputEmailorPhnNum" className="labelStyle">Mobile Number : </label>
              <input type="email" className="form-control emailtextField" id="inputEmailorPhnNum" placeholder="Enter email"/>
          </div>
          <div className="form-group">
              <label for="inputEmailorPhnNum" className="labelStyle">Email : </label>
              <input type="email" className="form-control emailtextField" id="inputEmailorPhnNum" placeholder="Enter email"/>
          </div>
          <div className="form-group">
              <label for="inputEmailorPhnNum" className="labelStyle">Password : </label>
              <input type="password" className="form-control passwordField" id="exampleInputPassword1" placeholder="Password"/>
          </div>
          <div className="form-group">
              <label for="exampleInputPassword" className="labelStyle1">Confirm Password : </label>
              <input type="password" className="form-control passwordField" id="exampleInputPassword1" placeholder="Password"/>
          </div>
          <p className="accountStyle">Already have an account <Link>Login</Link></p>
          <button type="submit" className="btn btn-primary buttonStyle">Sign Up</button>
      </form>
  </div>
    );
};

export default Register;