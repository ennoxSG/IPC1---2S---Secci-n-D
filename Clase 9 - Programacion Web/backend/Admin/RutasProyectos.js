const express = require('express');
const router = express.Router();
const Proyecto = require("../clases/Proyecto"); 

const { proyectos } = require("../data"); 

router.get('/', (req, res) => {
    res.json(proyectos);
})

router.post('/upload', (req, res) => {
    const nuevosProyectos = req.body; 
    
    const proyectosAAgregar = []; 

    nuevosProyectos.forEach(emp => {

        const nuevosProyecto = new Proyecto(emp.codigo, emp.nombre , emp.gerente);
        proyectosAAgregar.push(nuevosProyecto); 

    })

    if(proyectosAAgregar.length === 0){
        return res.json({mensaje: "No se añadio ningun proyecto.", proyectos: []})
    }


    proyectos.push(...proyectosAAgregar);

    res.json({
        mensaje: "proyecto añadidos con exito",
        proyecto: proyectosAAgregar
    })
})



router.get('/:codigo', (req, res) => {
    const codigoProyecto = req.params.codigo;
    const proyecto = proyectos.find(proj => proj.codigo === codigoProyecto);

    if (!proyecto) {
        return res.status(404).json({ error: 'Proyecto no encontrado' });
    }

    res.json(proyecto);
})




module.exports = router; 
