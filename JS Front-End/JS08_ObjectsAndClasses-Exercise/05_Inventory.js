function getInventory(arr) {

    let heroes = [];

    for (const heroData of arr) {

        let[name, level, items] = heroData.split(' / ');

        let hero = {
            name,
            level:Number(level),
            items
        };

        heroes.push(hero);
    }

    heroes.sort((a, b) => a.level - b.level);

    for (const hero of heroes) {
        console.log(`Hero: ${hero.name}\nlevel => ${hero.level}\nitems => ${hero.items}`);
    }
}

getInventory([

    'Isacc / 25 / Apple, GravityGun',

    'Derek / 12 / BarrelVest, DestructionSword',

    'Hes / 1 / Desolator, Sentinel, Antara'

]);