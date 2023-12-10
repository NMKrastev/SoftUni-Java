function validate() {

    document.getElementById('email').addEventListener('change', onChange);

    function onChange (e) {
        const element = e.currentTarget;
        let regex = /^[a-z]+@[a-z]+\.[a-z]+$/g;

        if (!regex.test(element.value)) {
            element.classList.add('error');
        } else {
            element.classList.remove('error');
        }
    }
}