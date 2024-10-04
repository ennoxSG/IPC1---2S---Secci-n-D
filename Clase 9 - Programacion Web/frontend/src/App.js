import './App.css';
import { AppRouter } from './Rutas/approuter';
import 'bootstrap/dist/css/bootstrap.min.css';   //Importar estilos de react
import '@fortawesome/fontawesome-free/css/all.min.css';   //Importar estilos de fontawesome (Iconos)

function App() {
  return (
    <div > 
        <AppRouter/>
    </div>
  );
}

export default App;
