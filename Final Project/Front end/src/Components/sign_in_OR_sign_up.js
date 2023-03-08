import React, { Component } from 'react';
import './CSS/sign_in_OR_sign_up.css';
class SignInORSignUp extends Component{
    render(){
        return(
        <div id="wrapper">
           <div id="top-half">
           <div id="label">Sign In</div>
           </div>

           <div id="bottom-half">
           <div id="label">Sign Up</div>
           </div>
        </div>
        )
    }
}
export default SignInORSignUp;