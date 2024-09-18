import React, { useState } from "react";
import "./login.css";
import { Link } from "react-router-dom";

const Login = () => {
    return(
    <div className="col-md-12 mainContainer">
        <div>
            <h1>Login</h1>
            <p className="textField">please login to continue</p>
        </div>
        <form>
            <div className="form-group">
                <label for="inputEmailorPhnNum" className="labelStyle">Email or Phone Number : </label><br></br>
                <input type="email" className="form-control emailtextField" id="inputEmailorPhnNum" placeholder="Enter email"/>
            </div>
            <div className="form-group">
                <label for="exampleInputPassword" className="labelStyle1">Password : </label><br></br>
                <input type="password" className="form-control passwordField" id="exampleInputPassword1" placeholder="Password"/><br></br>
                <Link className="forgotPassText">Forgot Password? </Link>
            </div>
            <p className="accountStyle">Dont have account <Link>Signup</Link></p>
            <button type="submit" className="btn btn-primary buttonStyle">Log In</button>
        </form>
    </div>
    );
};

export default Login;
