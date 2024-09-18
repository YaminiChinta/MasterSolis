import './App.css';
import Login from './Auth/login';
import Signup from "./Auth/Register";
import {BrowserRouter,Routes, Route} from 'react-router-dom';
import Home from './Common/Home';

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
      </Routes>
      </BrowserRouter>
     
    </div>
  );
}

export default App;
