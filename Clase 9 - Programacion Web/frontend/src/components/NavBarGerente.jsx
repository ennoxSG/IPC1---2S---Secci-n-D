import React from 'react'; // Importamos React para poder usar JSX y crear componentes
import { Link, useNavigate  } from 'react-router-dom';  // Importa Link para la navegación


const NavbarGerente = () => {

    const navigate = useNavigate(); // Usar el hook useNavigate

    const handleLogout = () => {
        // Redirigir a la página de login
        navigate('/login');

    };
    return (
        // Componente de navegación de Bootstrap
        <nav className="navbar navbar-expand-lg navbar-light fixed-top" style={{ backgroundColor: '#e3f2fd' }}>
            {/* 'navbar': Clase que define el componente como una barra de navegación de Bootstrap
                'navbar-expand-lg': La barra se expande y muestra todos los enlaces a partir de pantallas grandes
                'navbar-light': Aplica un esquema de colores claros para el texto y los elementos de la barra
                'fixed-top': Fija la barra en la parte superior de la ventana, permaneciendo visible al hacer scroll */}

            <div className="container-fluid"> {/* Contenedor fluido que ocupa todo el ancho disponible */}
                <a className="navbar-brand" href="#">COESYS</a>
                {/* 'navbar-brand': Estilo para el logotipo o nombre de la marca en la barra de navegación */}

                <div className="collapse navbar-collapse" id="navbarNav"> {/* Contenido que se colapsa/expande en pantallas pequeñas */}
                    <ul className="navbar-nav"> {/* Lista de enlaces de navegación */}
                        <li className="nav-item active"> {/* Elemento de la lista para el enlace activo */}
                            {/*<a className="nav-link" href="#">Gerentes</a> */}
                            <Link className="nav-link" to="/gerente/proyectos">Proyectos</Link>
                            {/* 'nav-link': Estilo para los enlaces de navegación */}
                        </li>
                        <li className="nav-item">
                            {/*<a className="nav-link" href="#">Empleados</a> */}
                            <Link className="nav-link" to="/gerente/reportes">Reportes</Link>
                        </li>
                    </ul>
                    <button className="btn btn-danger ms-auto" onClick={handleLogout}>Logout</button> {/* Alineado a la derecha */}
                </div>
            </div>
        </nav>
    );
};

export default NavbarGerente; // Exportamos el componente Navbar para usarlo en otras partes de la aplicación
