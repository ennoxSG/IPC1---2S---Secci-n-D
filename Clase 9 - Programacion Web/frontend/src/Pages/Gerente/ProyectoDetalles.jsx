import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

const ProyectoDetalles = () => {
    const { codigo } = useParams(); // Obtener el código del proyecto desde la URL
    const [proyecto, setProyecto] = useState(null);
    const [empleados, setEmpleados] = useState([]);
    const [actividades, setActividades] = useState([]);

    useEffect(() => {
        const fetchProyectoDetalles = async () => {
            try {
                const response = await fetch(`http://localhost:5000/proyectos/${codigo}`);
                if (!response.ok) {
                    throw new Error('Error al obtener los detalles del proyecto');
                }
                const data = await response.json();
                setProyecto(data);
                setEmpleados(data.empleados);
                setActividades(data.actividades);
            } catch (error) {
                console.error(error);
            }
        };

        fetchProyectoDetalles();
    }, [codigo]);

    if (!proyecto) {
        return <p>Cargando...</p>;
    }

    return (
        <div>
            <h2>Detalles del Proyecto: {proyecto.nombre}</h2>
            <h3>Empleados Asignados</h3>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                    </tr>
                </thead>
                <tbody>
                    {empleados.map((empleado) => (
                        <tr key={empleado.codigo}>
                            <td>{empleado.codigo}</td>
                            <td>{empleado.nombre}</td>
                        </tr>
                    ))}
                </tbody>
            </table>

            <h3>Lista de Actividades</h3>
            <ul>
                {actividades.map((actividad, index) => (
                    <li key={index}>{actividad}</li>
                ))}
            </ul>
        </div>
    );
};

export default ProyectoDetalles;
