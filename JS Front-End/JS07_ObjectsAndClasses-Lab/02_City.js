 function printKeyAndValue(city) {

    const {name, area, population, country, postCode} = city;

     for (const element of Object.entries(city)) {
         const [key, value] = element;
         console.log(`${key} -> ${value}`);
     }
    
    /*console.log(`name -> ${name}`);
    console.log(`area -> ${area}`);
    console.log(`population -> ${population}`);
    console.log(`country -> ${country}`);
    console.log(`postCode -> ${postCode}`);*/

 }

 printKeyAndValue({
     name: "Sofia",
     area: 492,
     population: 1238438,
     country: "Bulgaria",
     postCode: "1000"
 });