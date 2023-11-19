function storeProvision(currentStock, orderedProducts) {

    const stocks = {}

    for (let i = 0; i < currentStock.length; i += 2) {

        let product = currentStock[i];
        let quantity = Number(currentStock[i + 1]);

        if (!stocks.hasOwnProperty(product)) {
            stocks[product] = quantity;
        } else {
            stocks[product] += quantity;
        }
    }

    for (let i = 0; i < orderedProducts.length; i += 2) {

        let product = orderedProducts[i];
        let quantity = Number(orderedProducts[i + 1]);

        if (!stocks.hasOwnProperty(product)) {
            stocks[product] = quantity;
        } else {
            stocks[product] += quantity;
        }
    }

    for (const stock in stocks) {
        console.log(`${stock} -> ${stocks[stock]}`)
    }
}

storeProvision(['Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'],
    ['Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30'])