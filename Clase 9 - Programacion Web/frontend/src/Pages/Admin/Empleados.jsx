import React, {useState, useEffect} from 'react';
import Navbar from '../../components/NavBar';
import '../styles/admin.css';

const Empleado = () => {

    const [empleados, setEmpleados] = useState([]); 

    useEffect(() => {
        const fetchEmpleados = async () => {

            try{
                const response = await fetch('http://localhost:5000/empleados');

                const data = await response.json(); 
                setEmpleados(data); 
            } catch (error){
                console.log("Error al hacer la peticion"); 
            }
        }

        fetchEmpleados(); 

    }, [])

    const handleEdit = (codigo) => {
        console.log(`Editando empleado con código: ${codigo}`);
    };

    const handleDelete = (codigo) => {
        console.log(`Eliminando empleado con código: ${codigo}`);
    };

    const handleCargar = async (event) => {
        console.log("Aui")
        const file = event.target.files[0]; 
        if(file){
            const reader = new FileReader(); 
            reader.onload = async (e) => {
                try {
                    const jsonData = JSON.parse(e.target.result); //Archivos a enviar al backend
                    const response = await fetch("http://localhost:5000/empleados/upload", {
                        method: "POST",
                        headers: {
                            'Content-Type' : 'application/json'
                        },
                        body: JSON.stringify(jsonData)
                    });

                    if(response.ok){
                        console.log("Datos cargados correctamente")
                        const result = await response.json(); 
                        alert(result.mensaje)

                        setEmpleados((prevEmpleados) => [...prevEmpleados, ...result.empleados]);
                    }else{
                        console.error("Datos no se cargaron en el backend")
                    }

                } catch (error){
                    console.error("Error al hacer la peticion: " , error)
                }

            }
            reader.readAsText(file);

        }else {
            console.log("No se encuentra el archivo")
        }
    };

    return (
        <div>
            <Navbar />
            <div className='conteiner-admin'>
                <h2>Lista de Empleados</h2>

                <div className="button-group" style={{ marginBottom: '20px' }}>
                    <label className="btn btn-primary"> 
                        Cargar
                        <input 
                            type="file"
                            accept='.json'
                            style={{display: 'none'}}
                            onChange={handleCargar}
                        />
                    </label>
                </div>

                <table className="table table-striped w-80">
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Nombre</th>
                            <th>contraseña</th>
                            <th>Edad</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        {empleados.map((user) => (
                            <tr key={user.codigo}>
                                <td>{user.codigo}</td>
                                <td>{user.nombre}</td>
                                <td>{user.contraseña}</td>
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
