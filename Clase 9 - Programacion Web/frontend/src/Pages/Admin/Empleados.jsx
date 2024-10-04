import React from 'react';
import Navbar from '../../components/NavBar';
import '../styles/admin.css';

const Empleado = () => {

    const data = [
        { codigo: '101', nombre: 'Ana Gómez', congreseña: '123789', edad: 29 },
        { codigo: '102', nombre: 'Luis Rodríguez', congreseña: '456012', edad: 35 },
        { codigo: '103', nombre: 'Sofia Martínez', congreseña: '789456', edad: 27 },
    ];

    const handleEdit = (codigo) => {
        console.log(`Editando empleado con código: ${codigo}`);
    };

    const handleDelete = (codigo) => {
        console.log(`Eliminando empleado con código: ${codigo}`);
    };

    const handleCargar = () => {
        console.log('Cargando datos...');

    };

    const handleImportar = () => {
        console.log('Importando datos...');

    };

    return (
        <div>
            <Navbar />
            <div className='conteiner-admin'>
                <h2>Lista de Empleados</h2>

                <div className="button-group" style={{ marginBottom: '20px' }}>
                    <button onClick={handleCargar} className="btn btn-primary" style={{ marginRight: '10px' }}>
                        Cargar
                    </button>
                    <button onClick={handleImportar} className="btn btn-secondary">
                        Importar
                    </button>
                </div>

                <table className="table table-striped w-80">
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Nombre</th>
                            <th>congreseña</th>
                            <th>Edad</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        {data.map((user) => (
                            <tr key={user.codigo}>
                                <td>{user.codigo}</td>
                                <td>{user.nombre}</td>
                                <td>{user.congreseña}</td>
                                <td>{user.edad}</td>
                                <td>
                                    <button onClick={() => handleEdit(user.codigo)} className="btn btn-warning">
                                        <i className="fas fa-edit"></i> {/*Modificar*/}
                                    </button>
                                    <button onClick={() => handleDelete(user.codigo)} className="btn btn-danger" style={{ marginLeft: '10px' }}>
                                        <i className="fa-solid fa-trash"></i> {/*Eliminar*/}
                                    </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default Empleado;
