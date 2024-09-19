import React from "react";
import TopNav from '../ReUsedComponents/TopNav';
import { Container } from "react-bootstrap";

const Home=()=>{
    return(
    <div>
        <TopNav/>
        <Container style={{marginTop:100}}>
            <h1>Welcome to Your Website</h1>
            <p>This is the homepage content.</p>
        </Container>
    </div>
    );
};

export default Home;