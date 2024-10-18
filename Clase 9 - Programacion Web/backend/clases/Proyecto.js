class Proyecto {
    constructor(codigo, nombre, gerente){
        this.codigo = codigo; 
        this.nombre = nombre; 
        this.gerente = gerente;
        this.empleados = [];
        this.actividades = []; 
    }

}

module.exports = Proyecto; 