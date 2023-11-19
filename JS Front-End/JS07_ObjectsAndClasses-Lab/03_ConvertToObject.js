function convertToObject(json) {

    const obj = JSON.parse(json);

    for (const entry of Object.entries(obj)) {
        const [key, value] = entry;
        console.log(`${key}: ${value}`);
    }
}

convertToObject('{"name": "George", "age": 40, "town": "Sofia"}')