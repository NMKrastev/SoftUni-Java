function toggle() {

    let toggleButton = document.getElementsByClassName("button")[0];


    let extraContent = document.getElementById('extra');


    if (extraContent.style.display === 'none') {
        extraContent.style.display = 'block';
        toggleButton.textContent = 'Less';
    } else {
        extraContent.style.display = 'none';
        toggleButton.textContent = 'More'
    }

}