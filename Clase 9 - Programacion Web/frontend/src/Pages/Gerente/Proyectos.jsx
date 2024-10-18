import React, {useState, useEffect} from 'react';
import NavbarGerente from '../../components/NavBarGerente';
import '../styles/admin.css';
import Cookies from 'js-cookie'; 
import { useNavigate } from 'react-router-dom';

const GerenteProyectos = () => {

    const [nombre, setNombre] = useState(Cookies.get('nombre'));
    const [codigo, setCodigo] = useState(Cookies.get('codigo'));
    const [proyectos, setProyectos] = useState([]);
    const navigate = useNavigate(); 

    useEffect(() => {
        const fetchEmpleados = async () => {

            try{
                const response = await fetch(`http://localhost:5000/gerentes/proyectos`, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        codigoGerente: codigo,
                    })
                });
    
                if (response.ok) {
                    const result = await response.json();
                    console.log(result)
                    setProyectos(result)
                    
                    
                } else {
                    console.error("Error al actualizar el empleado");
                }
            } catch (error){
                console.log("Error al hacer la peticion")
            }
        }

        fetchEmpleados(); 

    }, [])


    const handleViewDetails = (codigo)=>  {
        navigate(`/proyectos/${codigo}`);
    }
    
    return (
        <div>
            <NavbarGerente />
            <div className='conteiner-admin '>
                <h1>Bienvenido: {nombre}</h1> 
                <h2>Tu codigo es: {codigo}</h2> 


                <h2> Lista de proyectos: </h2>
                <div className="row">
                    {proyectos.map((proyecto) => (
                        <div key={proyecto.codigo} className="col-md-4">
                            <div className="card mb-4 shadow-sm">
                                <div className="card-body">
                                    <h5 className="card-title">{proyecto.nombre}</h5>
                                    <p className="card-text">Código: {proyecto.codigo}</p>
                                    <p className="card-text">Gerente: {proyecto.gerente}</p>
                                    <button 
                                        onClick={() => handleViewDetails(proyecto.codigo)} 
                                        className="btn btn-primary">
                                        Ver Detalles
                                    </button>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>


                
            </div>
        </div>
    );
};

export default GerenteProyectos;
