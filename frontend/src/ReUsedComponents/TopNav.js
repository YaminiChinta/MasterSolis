import { Navbar , Container, Nav} from "react-bootstrap";
import NavDropdown from 'react-bootstrap/NavDropdown';
import logo from '../../src/images/Logo.jpg';
import Image from 'react-bootstrap/Image';
import '../Css/topNav.css'

const TopNav=()=>{
    return(
      <Container>
      <Navbar collapseOnSelect expand="lg" className="bg-body-tertiary" fixed="top">
      <Container>
        <Navbar.Brand href="#home"><Image src={logo} style={{width:70, height:45, marginBottom:-20, marginLeft:-30}}></Image></Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="Home"><b>Home</b></Nav.Link>
            <Nav.Link href="#link"><b>Our Services</b></Nav.Link>
            <Nav.Link href="#link"><b>Products</b></Nav.Link>
            <Nav.Link href="Courses"><b>Courses</b></Nav.Link>
            <Nav.Link href="Internships"><b>Internships</b></Nav.Link>
            <NavDropdown title="More" id="basic-nav-dropdown">
              <NavDropdown.Item href="#action/3.1">Events</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.2">Blogs</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.3">Resources</NavDropdown.Item>
              {/* <NavDropdown.Divider /> */}
              <NavDropdown.Item href="#action/3.4">Groups</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.4">Contact Us</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.4">My Account</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.4">SignUp</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.4">Login</NavDropdown.Item>
            </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    </Container>
    )
  }

export default TopNav;