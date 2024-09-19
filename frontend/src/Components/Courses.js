import React from "react";
import TopNav from '../ReUsedComponents/TopNav';
import { Container } from "react-bootstrap";

const Courses=()=>{
    return(
    <div>
        <TopNav/>
        <Container style={{marginTop:100}}>
            <h1>Welcome to Your Website</h1>
            <p>This is the Courses Page content.</p>
        </Container>
    </div>
    );
};

export default Courses;