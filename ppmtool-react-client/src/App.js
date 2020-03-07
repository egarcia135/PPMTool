import React from 'react';
import './App.css';
import Dashboard from './componets/Dashboard';
import Header from './componets/Layout/Header';
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddProject from './componets/Project/AddProject';
import  { Provider } from "react-redux";
import store from "./store";
import UpdateProject from './componets/Project/UpdateProject';
import ProjectBoard from './componets/ProjectBoard/ProjectBoard';
import AddProjectTask from './componets/ProjectBoard/ProjectTasks/AddProjectTask';
import UpdateProjectTask from './componets/ProjectBoard/ProjectTasks/UpdateProjectTask';



function App() {
  return (
    <Provider store={store}>
    <Router>
      <div className="App">
        <Header/>
        <Route exact path="/dashboard" component={Dashboard}/>
        <Route exact path="/addProject" component={AddProject}/>
        <Route exact path="/updateProject/:id" component={UpdateProject}/>
        <Route exact path="/projectBoard/:id" component={ProjectBoard}/>
        <Route exact path="/addProjectTask/:id" component={AddProjectTask}/>
        <Route exact path="/updateProjectTask/:backlog_id/:pt_id" component={UpdateProjectTask}/>
      </div>
    </Router>
    </Provider>
  );
}

export default App;
