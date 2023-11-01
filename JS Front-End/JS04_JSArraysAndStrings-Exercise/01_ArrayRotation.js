function arrayRotation(arr, rotations) {

    for (let i = 0; i < rotations; i++) {
        let num = arr.shift();

        arr.push(num);
    }

    console.log(arr.join(' '));
}

arrayRotation([32, 21, 61, 1], 4);