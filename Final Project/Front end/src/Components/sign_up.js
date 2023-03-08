import React, { Component } from 'react';
import {Link} from 'react-router-dom';
import axios from 'axios';
import './CSS/sign_up.css';
class SignUpPage extends Component{
    state={"firstName":"",
                    "lastName":"",
                    "dateOfBirth":"",
                    "mobileNumber":"",
                    "emailId":"",
                    "password":""
                    
            }
    handleSubmit=()=>{
        console.log(this.state);
        axios({
            method: 'post',
            url: 'http://localhost:8080/user',
            data: this.state, 
            headers: {
            'Content-Type': 'application/json'
            }, 
          })
    }
    
    render(){
    return(
        <div id="wrapper">
            <h1 id="title">SIGN UP</h1>
            <div id="form">
            <form autoComplete='off' onSubmit={this.handleSubmit}>
                <label id="label">First Name</label><br/>
                <input id="inputarea" type="text" onChange={(e)=>this.setState({"firstName":e.target.value})} pattern="[A-Za-z]" required></input><br/><br/>
                <label id="label">Last Name</label><br/>
                <input id="inputarea" type="text"  onChange={(e)=>this.setState({"lastName":e.target.value})} pattern="[A-Za-z]" required></input><br/><br/>
                <label id="label">Birthday</label><br/>
                <input id="inputarea" style={{paddingRight:"6%",width:"90%"}} type="date"  onChange={(e)=>this.setState({"dateOfBirth":e.target.value})} required></input><br/><br/>
                <label id="label">Mobile Number</label><br/>
                <input id="inputarea" type="tel" maxLength={10} onChange={(e)=>this.setState({"mobileNumber":e.target.value})} pattern="[0-9]" required></input><br/><br/>
                <label id="label">Email-ID</label><br/>
                <input id="inputarea" type="email"  onChange={(e)=>this.setState({"emailId":e.target.value})} required></input><br/><br/>
                <label id="label">Create a new Password</label><br/>
                <input id="inputarea" type="password" onChange={(e)=>this.setState({"password":e.target.value})} required></input><br/><br/>
                <div style={{display:'inline-block'}}>
                <p id="label" style={{fontSize:"80%",marginTop:0}}>Already have an account? </p>
                <Link to="/"><p id="label" style={{fontSize:"80%"}}>Sign in</p></Link>
                </div>

                <button id="inputarea" style={{float:"right", width:"30%",height:"50px",display:"inline-block"}}>Next</button><br/><br/>
            </form><br/><br/>
            </div>
        </div>
    )
    }
}
export default SignUpPage;