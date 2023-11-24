function subtract() {

    let firstNum = document.getElementById('firstNumber').value;
    let secondNum = document.getElementById('secondNumber').value;

    console.log(Number(firstNum - secondNum));

    let div = document.getElementById('result');
    div.textContent = (Number(firstNum - secondNum)).toString();
}