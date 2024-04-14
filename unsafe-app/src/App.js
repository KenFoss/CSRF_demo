import logo from './logo.svg';
import './App.css';
import React, { useEffect, useState } from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

function Home() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [csrfToken, setCsrfToken] = useState('');

  // Fetch the mock authenication session id

  useEffect(() => {

    // Adds a session token (test-session-id) to browser cookies, mocks the JSON web token in a typical setup

    let fetchLogin = async () => {
      let response = await fetch('http://localhost:8090/login-test', {
        method:'GET',
        credentials:'include'
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


  // Fetch the csrf token and set it for use in the application

  useEffect(() => {
    let fetchCSRF = async () => {
      let response = await fetch('http://localhost:8090/get-token', {
        method:'GET',
        credentials:'include'
      })

      response = await response.json()

      setCsrfToken(response['token!']);
    }
    try{
      if(isAuthenticated) {
        fetchCSRF();
      }
    } catch (e) {
      console.log(e);
    }
  }, [isAuthenticated])

  useEffect( () => {
    console.log(csrfToken)
  }, [csrfToken])


  const postData = () => {
    let fetchData = async () => {
      let response = await fetch('http://localhost:8090/post-example', {
        method:'POST',
        credentials:'include',
        body: "data"
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
