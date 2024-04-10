import logo from './logo.svg';
import './App.css';
import React, { useEffect } from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

function Home() {

  useEffect(() => {

    // Adds a session token (test-session-id) to browser cookies, mocks the JSON web token in a typical setup

    let fetchLogin = async () => {
      let response = await fetch('http://localhost:8090/login-test', {
        method:'GET'
      })
    }

    try{
      fetchLogin();
    } catch (e) {
      console.log(e);
    }
    
  },[])

  // A post request requires extra layers of protection, with such a request
  // assailants could delete user data, change passwords and perform other
  // harmful actions

  const postData = () => {
    let fetchData = async () => {
      let response = await fetch('http://localhost:8090/post-example', {
        method:'POST'
      })
    }
    fetchData();
  }


  return (
    <div>
      <h1>Welcome to A Sketchy App</h1>
      <button onClick={() => postData()}>post locally</button>
      {/* This links to the evil.html script */}
      <a href="http://localhost:3001"> This looks completely safe!</a>
    </div>
  )
}

function Post() {

  useEffect(() => {  {
    let fetchData = async () => {
      let response = await fetch('http://localhost:8090/post-example', {
        method:'POST'
      })
      console.log("Resposne Cookies");
      console.log(response.cookies);

      response = await response.json()
      console.log("Fetched cookie");
      console.log(response)
    }
    fetchData();
  }}, [])



  return(
    <div>
      <h1>Malicious Action Page</h1>
    </div>
  )
}

function App() {  

  return (
    <BrowserRouter>
      <Routes>
        <Route path = "/" element={<Home/>}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
