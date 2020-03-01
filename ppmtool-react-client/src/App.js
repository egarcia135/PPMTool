import React from 'react';
import logo from './logo.svg';
import './App.css';
import Dashboard from './componets/Dashboard';
import Header from './componets/Layout/Header';
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddProject from './componets/Project/AddProject';

function App() {
  return (
    <Router>
      <div className="App">
        <Header/>
        <Route exact path="/dashboard" component={Dashboard}/>
        <Route exact path="/addProject" component={AddProject}/>
      </div>
    </Router>

  );
}

export default App;
