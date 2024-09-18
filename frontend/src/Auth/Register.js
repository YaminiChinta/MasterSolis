import React, { useState } from "react";

const Register = () => {

    const [formData, setFormData] = useState({
        first_name: '',
        last_name: '',
        phone_number: '',
        email: '',
        username: '',
        password: '',
        rePassword: '',
      });
      const [errorOccurred, setErrorOccurred] = useState(false);
      const [curred, setcurred] = useState(false);
    
      const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
          ...formData,
          [name]: value,
        });
      };
      
    //   const handleSubmit = async (e) => {
    //     e.preventDefault();
    //     try {
    //       const response = await axios.post('http://127.0.0.1:8000//', formData, {
    //         headers: {
    //           'Content-Type': 'application/json'
    //         }
    //       });
    //       setcurred(true)
    //     } catch (error) {
    //       setErrorOccurred(true)
    //     }
    //   };
    const handleSubmit = {};

    return (
        <div className="container">
          <div className="row justify-content-center m-5">
            <div className="col-md-6 alireza p-4 ">
              <form className="m-2" onSubmit={handleSubmit}>
                <div className="form-group">
                  <input type="text" name="first_name" value={formData.first_name} onChange={handleChange} className="form-control hover" placeholder="First Name" />
                </div>
                <div className="form-group">
                  <input type="text" name="last_name" value={formData.last_name} onChange={handleChange} className="form-control" placeholder="Last Name" />
                </div>
                <div className="form-group">
                  <input type="text" name="phone_number" value={formData.phone_number} onChange={handleChange} className="form-control" placeholder="Phone Number" />
                </div>
                <div className="form-group">
                  <input type="email" name="email" value={formData.email} onChange={handleChange} className="form-control" placeholder="Email" />
                </div>
                <div className="form-group">
                  <input type="password" name="password" value={formData.password} onChange={handleChange} className="form-control" placeholder="Password" />
                </div>
                <div className="form-group">
                  <input type="password" name="password" value={formData.rePassword} onChange={handleChange} className="form-control" placeholder="rePassword" />
                </div>
                <button onClick={handleSubmit} type="submit" className="btn btn-primary">Register</button>
              </form>
            </div>
          </div>
        </div>
    );
};

export default Register;