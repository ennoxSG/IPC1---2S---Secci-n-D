const express = require('express'); 
const User = require("./clases/User"); 
const Empleado = require("./clases/Empleado"); 
const cors = require('cors'); 
const app = express(); 
const port = 5000; 

app.use(express.json()); 
app.use(cors()); 

let usuarios = []; 
let empleados = []; 

app.get('/empleados', (req, res) => {
    res.json(empleados);
})

app.post('/empleados/upload', (req, res) => {
    const nuevosEmpleados = req.body; 
    if(!Array.isArray(nuevosEmpleados)){
        return res.status(400).json({error: "Los datos enviados no son validos."})
    }

    empleados = [...empleados, ...nuevosEmpleados];

    res.json({
        mensaje: "Empleados añadidos con exito",
        empleados: nuevosEmpleados
    })
})

app.post('/login', (req, res) => {
    const {rol, carnet, password} = req.body; 
    if (rol === "admin") {
        if (carnet === "admin" && password === "admin") {
            return res.json({state: true}); 
        } else {
            return res.json({state: false}); 
        }
    }

    if (rol === "empleado") {
        const empleado = empleados.find(emp => emp.codigo === carnet && emp.contraseña === password);
        if(empleado){
            return res.json({state: true}); 
        }else{
            return res.json({state: false}); 
        }
    }

    return res.json({state: false}); 

})



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