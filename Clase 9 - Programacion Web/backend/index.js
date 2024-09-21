const express = require('express'); 
const User = require("./User"); 
const app = express(); 
const port = 5000; 

app.use(express.json()); 

let usuarios = []; 


app.get('/saludo', (req, res) => {
    res.send("Hola mundo!");

})

app.get('/saludo2', (req, res) => {
    res.json({ 
        mensaje: '¡Bienvenido a la API!',
        estado : "correcto"
     });
})

app.post('/rutaPost', (req, res) => {
    const nombre = req.body.nombre; 
    res.json({
        mensaje : "Hola " + nombre
    })
})


app.post('/Registro', (req, res) => {
    const {nombre, email} = req.body; 
    const nuevoUsuario = new User(usuarios.length + 1, nombre, email); 
    usuarios.push(nuevoUsuario); 
    res.json({
        mensaje: "Usuario añadido exitosamente"
    })
})

app.get("/Usuarios" , (req, res) => {
    res.json(usuarios); 
})

app.put("/Actualizar/:id", (req, res) => {
    const {id} = req.params; 
    const {nombre, email} = req.body; 

    const usuario = usuarios.find(user => user.id == id); 

    if( !usuario ){
        return res.status(404).json({error: "Usuario no se encontro."}); 
    }

    if (nombre){
        usuario.nombre = nombre; 
    }

    if(email){
        usuario.email = email; 
    }

    res.json(usuario); 

})



app.listen(port, () =>  {
    console.log("Servidor escuchando en http://localhost:" + port); 
}); 