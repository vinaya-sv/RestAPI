import React, { Component } from 'react';
import './CSS/sign_in.css';
import {Link, Navigate, useNavigate} from 'react-router-dom';
import axios from 'axios';
class SignInPage extends Component{
    state={"email":"","password":"",error:""}
    render(){
    const handleSignIn=()=>{
        axios.get(`http://localhost:8080/user/signIn/${this.state.email}/${this.state.password}`)
        .then((response)=>{
            console.log(response.data);
        });
    }
    return(
        <div id="wrapper">
            <h1 id="title">SIGN IN</h1>
            <div id="form">
            <form autoComplete='off'>
                <label id="label">Email</label><br/>
                <input id="inputarea" type="email" onChange={(event)=>this.setState({"email":event.target.value})}></input><br/><br/>
                <label id="label">Password</label><br/>
                <input id="inputarea" type="password" onChange={(event)=>this.setState({"password":event.target.value})}></input><br/><br/><br/>
                {this.state.error}
                <div style={{display:'inline-block'}}>
                <p id="label" style={{fontSize:"80%",marginTop:0}}>Don't have an account? </p>
                <Link to="/sign-up"><p id="label" style={{fontSize:"80%"}}>Create an account</p></Link>
                </div>
                <input type="button" id="inputarea" style={{float:"right", width:"30%",height:"50px",display:"inline-block"}} onClick={handleSignIn} value="next"></input><br/><br/><br/>               
            </form>
            
            </div>
    
        </div>
    )
    }
}
export default SignInPage;