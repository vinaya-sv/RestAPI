import React, { Component } from 'react';
import './CSS/home.css';
import Profile from './profile';
class Home extends Component{
    state={}
    render(){
        return(
            <div>
                <div id="navbar">
                <p id="welcome">Hai Vinaya! </p>
                <Profile/>
                </div>
            </div>
        )
    }
}
export default Home;