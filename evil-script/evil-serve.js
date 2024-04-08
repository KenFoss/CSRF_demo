const express = require('express');
const path = require('path');
const app = express();
const port = 3001;

// Serve static files from the "public" directory
// app.use(express.static('public'));

// Define a route to handle GET requests to the root URL
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'evil.html'));
});
// Start the server
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});