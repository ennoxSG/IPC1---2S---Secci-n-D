

export const loginAuth = async (credentials) => {
    console.log(credentials)

    if (credentials.rol === "admin") {
        if (credentials.carnet === "admin" && credentials.password === "admin") {

            const response = {
                state: true
            }
            return response
        } else {
            const response = {
                state: false
            }
            return response
        }
    }
    /*const response = await fetch('http://localhost:5000/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(credentials)
        });

        return response.json(); */
};