import React, { Component } from 'react';

import './CSS/address.css';
class Address extends Component{
    state={gender:""}
    render(){
    return(
        <div id="wrapper">
            <h1 id="title">ADDRESS</h1>
            <div id="form">
            <form autoComplete='off'>
                <label id="label">Address line 1</label><br/>
                <input id="inputarea" type="text"></input><br/><br/>
                <label id="label">Address line 2</label><br/>
                <input id="inputarea" type="text"></input><br/><br/>
                <label id="label">City</label><br/>
                <input id="inputarea" type="text"></input><br/><br/>
                <label id="label">State</label><br/>
                <input id="inputarea" type="text"></input><br/><br/>
                <label id="label">Pin Code</label><br/>
                <input id="inputarea" type="text"></input><br/><br/><br/>
                <button id="inputarea" style={{float:"right", width:"30%",height:"50px",display:"inline-block"}}>Next</button><br/><br/><br/>
            </form><br/><br/>
            </div>
        </div>
    )
    }
}
export default Address;