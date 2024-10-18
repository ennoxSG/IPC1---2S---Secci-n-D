const express = require('express'); 


const cors = require('cors'); 
const app = express(); 
const port = 5000; 

const rutasEmpleadosAdmin = require("./Admin/RutasEmpleado")
const rutasGerentes = require("./Admin/RutasGerente")
const rutasProyectos = require("./Admin/RutasProyectos")
const {empleados, gerentes } = require("./data"); 

app.use(express.json()); 
app.use(cors()); 

app.use('/empleados', rutasEmpleadosAdmin);
app.use('/gerentes', rutasGerentes);
app.use('/proyectos', rutasProyectos);

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
            return res.json({state: true, code: empleado.codigo, nombre: empleado.nombre}); 
        }else{
            return res.json({state: false}); 
        }
    }

    if (rol === "gerente") {
        const gerente = gerentes.find(emp => emp.codigo === carnet && emp.contraseña === password);
        if(gerente){
            return res.json({state: true, code: gerente.codigo, nombre: gerente.nombre}); 
        }else{
            return res.json({state: false}); 
        }
    }

    return res.json({state: false}); 

})



app.listen(port, () =>  {
    console.log("Servidor escuchando en http://localhost:" + port); 
}); 