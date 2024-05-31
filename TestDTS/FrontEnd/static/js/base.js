const btnExecute = document.querySelector('.btnExecute');
const btnCreatedData = document.querySelector(".btnCreatedData");
const btnDelete= document.querySelector(".btnDelete");
const listData = document.querySelector('.list-data');
const resultData = document.querySelector('.result-data');

let arrayData = [];

const baseUrl = 'http://192.168.60.4:8081';
function showFailed(information) {
    Swal.fire({
        title: information,
        icon: 'error',
        showCancelButton: false
    })
}
btnExecute.addEventListener('click', function() {
    const selectedAlgorithm = document.getElementById('category-select').value;
    if(arrayData.length === 0){
        showFailed("Hãy tạo chuỗi trước khi thực hiện sắp xếp")
    }
    // Xử lý logic dựa trên lựa chọn thuật toán
    let apiUrl = '';
    if(selectedAlgorithm === ''){
        showFailed("Hãy chọn thuật toán sắp xếp")
    }
    else if (selectedAlgorithm === 'bubbleSort') {
        apiUrl = baseUrl + `/api/bubbleSort`;
    } else if (selectedAlgorithm === 'binarySort') {
        apiUrl = baseUrl + `/api/binarySort`;
    }
    else if(selectedAlgorithm === 'mergeSort'){
        apiUrl = baseUrl + `/api/mergeSort`;
    }else if(selectedAlgorithm === 'insertionSort'){
        apiUrl = baseUrl + `/api/insertionSort`;
    }else if(selectedAlgorithm === 'quickSort'){
        apiUrl = baseUrl + `/api/quickSort`;
    }
    console.log(apiUrl)
    console.log("request ", arrayData)
    // Gửi yêu cầu API
    fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(arrayData)
    })
    .then(response => response.json())
    .then(data => {
        console.log("resultData", data)
        displayData(data, resultData);
    })
    .catch(error => console.error('Error:', error));
});

btnCreatedData.addEventListener('click', function(){
    let apiUrlCrated = baseUrl + `/api/randomString`;
    fetch(apiUrlCrated, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
    })
    .then(response => response.json())
    .then(data => {
        // Hiển thị kết quả
        arrayData = data;
        console.log("data ", arrayData)
        displayData(data, listData); // Gọi hàm hiển thị dữ liệu

    })
    .catch(error => console.error('Error:', error));
})

btnDelete.addEventListener('click', function(){
    resultData.innerHTML = '';
})

function displayData(data, listHtml) {
    listHtml.innerHTML = ''; // Xóa nội dung hiện có của listData
    let i = 0;
    data.forEach(content => {
        const cell = document.createElement('div');
        cell.textContent = `${++i}: ${content}`; // Hiển thị số thứ tự và dữ liệu
        listHtml.appendChild(cell); // Thêm ô vào listData
    });
}