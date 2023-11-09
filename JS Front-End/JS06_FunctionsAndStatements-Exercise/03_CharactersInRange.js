function charsInRange(charOne, charTwo) {

    let result = '';

    let start = Math.min(charOne.charCodeAt(), charTwo.charCodeAt());
    let end = Math.max(charOne.charCodeAt(), charTwo.charCodeAt());

    for (let current = start + 1; current < end; current++) {
        result += `${String.fromCharCode(current)} `;
    }

    console.log(result.trim());
}

charsInRange('a', 'k');