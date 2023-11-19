function getTowns(arr) {



    for (const currentTown of arr) {

        let [town, latitude, longitude] = currentTown.split(' | ')

        let townInfo = {
            town,
            latitude:Number(latitude).toFixed(2),
            longitude:Number(longitude).toFixed(2),
        };

        console.log(townInfo);
    }
}

getTowns(['Sofia | 42.696552 | 23.32601', 'Beijing | 39.913818 | 116.363625'])