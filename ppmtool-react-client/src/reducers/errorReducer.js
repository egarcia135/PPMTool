import { GET_ERRORS } from "../actions/types";
import { bindActionCreators } from "redux";

const initialState = {};

export default function(state=initialState, acton) {
    switch(acton.type) {
        case GET_ERRORS:
        return acton.payload;

        default: 
        return state

    }

}