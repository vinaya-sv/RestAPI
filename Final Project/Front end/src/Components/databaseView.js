import React,{ useEffect,useState} from "react";
import './CSS/dataBaseView.css';
import axios from "axios";
function DataBaseView(){
    const [content, addContent]=useState([]);
    const [deleteEmailId,addDeleteEmailId]=useState("");
    const [editId, addEditId]=useState("");
    const [editContent, addEditContent]=useState({"firstName":"",
    "lastName":"",
    "dateOfBirth":"0001-01-01",
    "mobileNumber":"",
    "emailId":""});
    const [editError, setEditError]=useState("");
    useEffect(()=>{
    axios.get('http://localhost:8080/user')
    .then(function (response) {
        // console.log(response.data);
        addContent(response.data);
    });

    })
    const handleDelete=()=>{
        axios.delete(`http://localhost:8080/user/${deleteEmailId}`)
        .then((response)=>console.log(response));
    }

    const handleFormChange=(event)=>{
        const {id,value}=event.target;
        addEditContent({...editContent,[id]:value});
    }

    const handleEdit=()=>{
        // console.log(editContent);
        if(editId!=""){
            axios.put('http://localhost:8080/user',editContent)
            }
    }

    return(
        <div>
            <table>
                <tr>
                    <th>User ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Date of Birth</th>
                    <th>Mobile Number</th>
                    <th>Email ID</th>
                    <th>Password</th>
                </tr>
                {content.map((value)=>(
                    <tr>
                        <td>{value.userId}</td>
                        <td>{value.firstName}</td>
                        <td>{value.lastName}</td>
                        <td>{value.dateOfBirth}</td>
                        <td>{value.mobileNumber}</td>
                        <td>{value.emailId}</td>
                        <td>{value.password}</td>
                    </tr>
                ))}
                    
            </table>
            <table>
            Delete User<br/><br/>
            <div id="deleteUser">
                <label id="delete-label">User ID:</label><input id="delete-input" type="text" onChange={(event)=>{addDeleteEmailId(event.target.value)}}></input>
                <input id="delete-button" type="button" value="DELETE" onClick={handleDelete}></input>
            </div>
            </table>

            <table>
            Edit User <br/><br/>
            <div id="editUser">
                <label id="edit-label">User ID:</label><input id="edit-input" type="text" onChange={(event)=>{
                    addEditId(event.target.value);
                    if(editId){
                        axios.get(`http://localhost:8080/user/${editId}`)
                        .then(function(response){
                            console.log(response.data)
                            if(response.data){
                                addEditContent(response.data);
                                setEditError("");
                            }
                            else{
                                addEditContent({"firstName":"",
                                "lastName":"",
                                "dateOfBirth":"0001-01-01",
                                "mobileNumber":"",
                                "emailId":""});
                                setEditError("Account doesn't exists");
                            }

                        });
                    }
                }}></input><span style={{color:"#ad0404",marginLeft:"2%"}}>{editError}</span>
                <input id="edit-button" type="button" value="EDIT" onClick={handleEdit}></input><br/>
                <table style={{border:"none"}}>
                    <tr>
                        <td><label>First Name: </label></td>
                        <td><input id="firstName" type="text" value={editContent.firstName} onChange={handleFormChange} required></input></td>
                    </tr>
                    <tr>
                        <td><label>Last Name: </label></td>
                        <td><input id="lastName" type="text" value={editContent.lastName} onChange={handleFormChange} required></input></td>
                    </tr>
                    <tr>
                        <td><label>Birth Day: </label></td>
                        <td><input id="dateOfBirth" type="date" value={editContent.dateOfBirth.substring(0,10)} onChange={handleFormChange}></input></td>
                    </tr>
                    <tr>
                        <td><label>Mobile Number: </label></td>
                        <td><input id="mobileNumber" type="text" value={editContent.mobileNumber} onChange={handleFormChange} maxLength="10" required></input></td>
                    </tr>
                    <tr>
                        <td><label>Email ID: </label></td>
                        <td><input id="emailId" type="text" value={editContent.emailId} onChange={handleFormChange} required></input></td>
                    </tr>
                </table>
                
                <br/>
                <br/>
            </div>
        </table>
        </div>
    )
}
export default DataBaseView;