const express = require('express');
const cors = require('cors');
const app = express();

app.use(cors({
  origin: 'https://wgtabackend.onrender.com',
  methods: ['GET', 'POST', 'PUT', 'DELETE'],
  allowedHeaders: ['Content-Type', 'Authorization']
}));

app.use(express.json());

// Aquí irían tus rutas de Express

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});
