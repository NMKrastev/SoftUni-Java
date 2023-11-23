function extractText() {

    let items = document.getElementsByTagName('li');

    let result = [];

    for (const el of Array.from(items)) {
        result.push(el.textContent);
    }

    const textArea = document.getElementById('result');
    textArea.textContent = result.join('\n')
}