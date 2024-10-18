const express = require('express');
const router = express.Router();
const Gerente = require("../clases/Gerente"); 

const {gerentes, proyectos } = require("../data"); 

router.get('/', (req, res) => {
    res.json(gerentes);
})

router.post('/upload', (req, res) => {
    const nuevosGerentes = req.body; 
    

    const gerentesAAgregar = []; 

    nuevosGerentes.forEach(emp => {

        const nuevosGerente = new Gerente(emp.codigo, emp.nombre , emp.contraseña, emp.edad);
        gerentesAAgregar.push(nuevosGerente); 

    })

    if(gerentesAAgregar.length === 0){
        return res.json({mensaje: "No se añadio ningun gerente.", gerentes: []})
    }


    gerentes.push(...gerentesAAgregar);

    res.json({
        mensaje: "gerente añadidos con exito",
        gerente: gerentesAAgregar
    })
})


router.post('/proyectos', (req, res) => {
    const {codigoGerente} = req.body; 
    if(codigoGerente){
        const proyectosGerente = proyectos.filter(proyecto => proyecto.gerente === codigoGerente)
        res.json(proyectosGerente)
    }

    res.json({mensaje: "No se especifica el codigo del gerente"})

})



module.exports = router; 
