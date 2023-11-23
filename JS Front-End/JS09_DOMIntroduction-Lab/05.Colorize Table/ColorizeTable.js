function colorize() {

    let items = document.getElementsByTagName('tr');

    for (let i = 0; i < items.length; i++) {
        if (i % 2 !== 0) {
            items[i].style.background = 'Teal';
        }
    }
}