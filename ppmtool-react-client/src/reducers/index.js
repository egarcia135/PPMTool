import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import projectReducer from "./projectReducer";
import backlog_Reducer from "./backlog_Reducer";


export default combineReducers ({
    errors: errorReducer,
    project: projectReducer,
    backlog: backlog_Reducer

});