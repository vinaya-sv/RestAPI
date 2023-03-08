import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import SignInPage from './Components/sign_in';
import SignUpPage from './Components/sign_up';
import Address from './Components/address';
import DataBaseView from './Components/databaseView';

function App() {
  return (
    <BrowserRouter>
    <Routes>
        <Route exact path="/" element={<SignInPage/>}/>
        <Route path="/sign-up" element={<SignUpPage/>}/>
        <Route path="/address" element={<Address/>} />
        <Route path="/admin" element={<DataBaseView/>} />
    </Routes>
    </BrowserRouter>
  );
}

export default App;
