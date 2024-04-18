import logo from './logo.svg';
import './App.css';
import React, { useEffect, useState } from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

function Home() {

  // Fetch the mock authenication session id

  useEffect(() => {

    // Adds a session token (test-session-id) to browser cookies, mocks the JSON web token in a typical setup

    let fetchLogin = async () => {
      let response = await fetch('http://localhost:8090/login-test', {
        method:'POST',
        credentials:'include'
      })
    }

    try{
      fetchLogin();
    } catch (e) {
      console.log(e);
    }
    
  },[])


  const postData = () => {
    let fetchData = async () => {
      let csrfToken='';

      // cookies return as a string, we need to filter for the desired token
      let cookieList = document.cookie.split('; ')
      cookieList = cookieList.filter( (x) => x.split('=')[0] == 'XSRF-TOKEN')
      // set the token for use in post requests
      if(cookieList.length != 0) {
        csrfToken = cookieList[0].split('=')[1]
      }

      let response = await fetch('http://localhost:8090/post-example', {
        method:'POST',
        credentials:'include',
        body: "data",
        headers:{
          'X-XSRF-TOKEN':csrfToken
        }
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
