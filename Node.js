const express = require('express');
const app = express();
const cors = require('cors');

app.use(cors());

// su código para configurar las rutas y los endpoints aquí

const puerto = 3000;

app.listen(puerto, () => {
  console.log(`Servidor corriendo en el puerto ${puerto}`);
});
