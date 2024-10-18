import { Route, Routes, BrowserRouter } from 'react-router-dom';
import Login from '../Pages/login'
import Empleado from '../Pages/Admin/Empleados';
import Gerente from '../Pages/Admin/Gerentes';
import GeneralEmpleado from '../Pages/Empleado/General';
import GerenteProyectos from '../Pages/Gerente/Proyectos';
import ProyectoDetalles from '../Pages/Gerente/ProyectoDetalles';


export const AppRouter = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/login" element={<Login/>} />
                <Route path="/admin/empleado" element={<Empleado/>} />
                <Route path="/admin/gerente" element={<Gerente/>} />
                <Route path="/empleado/general" element={<GeneralEmpleado/>} />
                <Route path="/gerente/proyectos" element={<GerenteProyectos/>} />
                <Route path="/proyectos/:codigo" element={<ProyectoDetalles/>} />
                

            </Routes>
        </BrowserRouter>
    );
};