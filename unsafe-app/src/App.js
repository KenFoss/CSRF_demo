import logo from './logo.svg';
import './App.css';
import React, { useEffect } from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

function Home() {

  useEffect(() => {
    
    // let fetchToken = async () => {
    //   let response = await fetch('http://localhost:8090/get-token', {
    //     method:'GET',
    //     credentials:'include'
    //   })
    //   console.log("Resposne Cookies");
    //   console.log(response.headers);

    //   response = await response.json()
    //   console.log("Fetched cookie");
    //   console.log(response)
    // }

    let fetchLogin = async () => {
      let response = await fetch('http://localhost:8090/login-test', {
        method:'GET'
      })
      console.log("Resposne Cookies");
      console.log(response.headers);

      response = await response.json()
      console.log("Fetched cookie");
      console.log(response)
    }

    try{
      fetchLogin();
    } catch (e) {
      console.log(e);
    }
    
  },[])

  const postData = () => {
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
  }


  return (
    <div>
      <h1>Welcome to A Sketchy App</h1>
      <button onClick={() => postData()}>post locally</button>
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
