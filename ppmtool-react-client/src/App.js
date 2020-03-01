import React from 'react';
import './App.css';
import Dashboard from './componets/Dashboard';
import Header from './componets/Layout/Header';
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddProject from './componets/Project/AddProject';
import  { Provider } from "react-redux";
import store from "./store";

function App() {
  return (
    <Provider store={store}>
    <Router>
      <div className="App">
        <Header/>
        <Route exact path="/dashboard" component={Dashboard}/>
        <Route exact path="/addProject" component={AddProject}/>
      </div>
    </Router>
    </Provider>
  );
}

export default App;
