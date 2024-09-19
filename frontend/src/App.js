import './App.css';
import Login from './Auth/login';
import Signup from "./Auth/Register";
import {BrowserRouter,Routes, Route} from 'react-router-dom';
import Home from './Common/Home';
import Courses from './Components/Courses';
import Internships from './Components/Internships';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Routes>
        <Route
        path="/register"
        element={<Signup/>}
        />
        <Route
        path="/login"
        element={<Login/>}
        />
        <Route
        path="/home"
        element={<Home/>}
        />
        <Route
        path="/Courses"
        element={<Courses/>}
        />
        <Route
        path="/Internships"
        element={<Internships/>}
        />
      </Routes>
      </BrowserRouter>
     
    </div>
  );
}

export default App;
