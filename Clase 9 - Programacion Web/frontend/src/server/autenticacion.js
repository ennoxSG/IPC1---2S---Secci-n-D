export const loginAuth = async (credentials) => {

    try{
        const response = await fetch('http://localhost:5000/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(credentials)
            });

            if (!response.ok) {
                throw new Error(`Error en la petición: ${response.statusText}`);
            }
    
            return response.json();

    }catch (error){
        console.log('Error al hacer la peticion: ', error )
        return { error: 'Error al intentar iniciar sesión' , state: false}; 
    }
    
};