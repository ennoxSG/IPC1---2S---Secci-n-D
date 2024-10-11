import React, {useState, useEffect} from 'react';
import Navbar from '../../components/NavBar';
import '../styles/admin.css';

const Empleado = () => {


    const [empleados, setEmpleados] = useState([]); 
    const [showModal, setshowModal] = useState(false); 
    const [empleadoSeleccionado, setEmpleadoSeleccionado] = useState(null); 


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
        const empleado = empleados.find(emp => emp.codigo === codigo)
        setEmpleadoSeleccionado(empleado)
        setshowModal(true)

    };

    const handleDelete = (codigo) => {
        console.log(`Eliminando empleado con código: ${codigo}`);
    };


    const handleCloseModal = () =>{
        setshowModal(false); 
        setEmpleadoSeleccionado(null);
    }

    const handleSaveChanges = async () => {
        if(empleadoSeleccionado){
            try{
                const response = await fetch(`http://localhost:5000/empleados/actualizar`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        codigo: empleadoSeleccionado.codigo,
                        nombre: empleadoSeleccionado.nombre,
                        contraseña: empleadoSeleccionado.contraseña,
                        edad: empleadoSeleccionado.edad
                    })
                });
    
                if (response.ok) {
                    const result = await response.json();
                    console.log(result.mensaje);
                    
                    // Actualizar la lista de empleados en el estado
                    setEmpleados((prevEmpleados) => 
                        prevEmpleados.map(emp => 
                            emp.codigo === empleadoSeleccionado.codigo ? result.empleado : emp
                        )
                    );
                    
                    //Mostrar mensaje al actualizar 
                    alert(result.mensaje)
                    // Cerrar el modal después de guardar los cambios
                    setshowModal(false);
                } else {
                    console.error("Error al actualizar el empleado");
                }
            } catch (error){

            }

        }
    }

    const handleCargar = async (event) => {
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


            {showModal && empleadoSeleccionado && (
                <div className="modal" style={{ display: 'block', backgroundColor: 'rgba(0, 0, 0, 0.5)' }}>
                <div className="modal-content" style={{ padding: '20px', backgroundColor: '#fff', borderRadius: '10px', width: '400px', margin: '100px auto' }}>
                    <h2>Editar Empleado</h2>
                    <div>
                        <label>Código: </label>
                        <input 
                            type="text" 
                            className="form-control"
                            value={empleadoSeleccionado.codigo} 
                            readonly 
                            
                        />
                    </div>
                    <div>
                        <label>Nombre: </label>
                        <input 
                            type="text" 
                            value={empleadoSeleccionado.nombre} 
                            onChange={(e) => setEmpleadoSeleccionado({...empleadoSeleccionado, nombre: e.target.value})}
                            className="form-control"
                        />
                    </div>
                    <div>
                        <label>Contraseña: </label>
                        <input 
                            type="password" 
                            value={empleadoSeleccionado.contraseña} 
                            onChange={(e) => setEmpleadoSeleccionado({...empleadoSeleccionado, contraseña: e.target.value})}
                            className="form-control"
                        />
                    </div>
                    <div>
                        <label>Edad: </label>
                        <input 
                            type="number" 
                            value={empleadoSeleccionado.edad} 
                            onChange={(e) => setEmpleadoSeleccionado({...empleadoSeleccionado, edad: e.target.value})}
                            className="form-control"
                        />
                    </div>
                    <div className="modal-actions" style={{ marginTop: '20px' }}>
                        <button onClick={handleSaveChanges} className="btn btn-primary">Guardar</button>
                        <button onClick={handleCloseModal} className="btn btn-secondary" style={{ marginLeft: '10px' }}>Cancelar</button>
                    </div>
                </div>
            </div>
            )}
        </div>
    );
};

export default Empleado;
