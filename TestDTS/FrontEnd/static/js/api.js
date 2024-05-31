export function greetPerson(name) {
    return `Hello ${name}`;
}

export function callApi(method, url){
    fetch(url, {
        method: method
        // headers: {
        //     'Content-Type': 'application/json'
        // },
    })
    .then(response => response.text())
    .then(data => {
        console.log(data)
        return data;
    })
    .catch(error => console.error('Error:', error));
}

