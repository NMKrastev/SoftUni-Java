*HTTP Basics*</br>

**In this lesson we will use Postman in order to do GET, POST and DELETE requests**</br>

1. Listing all trips should be easy using "GET" request.</br></br>
   - Use the following URL to make a "GET" request:</br>
     https://trips-48955.firebaseio.com/trips.json </br></br>

   - You should receive the following answer with status `200 OK`: </br>
   [GETResponse.json](https://github.com/NMKrastev/SoftUni-Java/blob/dev/Fundamentals/HTTPBasics/src/GETResponse.json) </br></br>

2. Let's make a "POST" request to add a new destination to our firebase database. </br></br>
   - Use the following data and change it as you see fit: 
   ```json
    {

    "description" : " October-November and February-March are the best times to see the northern lights. Dark skies yield better displays – avoid full moon. ",

    "imagePath" : "https://www.aurora-nights.co.uk/wp-content/uploads/2019/07/norway-northern-lights-1500x587_c.jpg",

    "name" : "Capture the Northern Lights on camera"

    }
    ```
   
   - Make the "POST" request to the following address: </br>
   https://trips-48955.firebaseio.com/trips.json </br></br>

   - You should receive the following answer with status `200 OK`: </br>
     [POSTResponse.json](https://github.com/NMKrastev/SoftUni-Java/blob/dev/Fundamentals/HTTPBasics/src/POSTResponse.json) </br></br>

3. Now let us remove the newly created trip using "DELETE" request.</br></br>
   - Make the "DELETE" request at: https://trips-48955.firebaseio.com/trips/{postId}.json </br>
   The `postId` can be found from the [POSTResponse.json](https://github.com/NMKrastev/SoftUni-Java/blob/dev/Fundamentals/HTTPBasics/src/POSTResponse.json) of the previous task.</br></br>
   - Replace `{postId}` in https://trips-48955.firebaseio.com/trips/{postId}.json with the `postId` that you received in the previous step. </br>
     In my case this is: 
   ```json
    {
     "name": "-NCzOrV_4L4otZl13VOB"
     }
    ```
   
   - Replaced URL should now look like this: https://trips-48955.firebaseio.com/-NCzOrV_4L4otZl13VOB.json </br></br>
   - Make the "DELETE" request in **Postman**.</br></br>
   - You should receive the following answer: </br>
     [DELETEResponse.json](https://github.com/NMKrastev/SoftUni-Java/blob/dev/Fundamentals/HTTPBasics/src/DELETERespose.json) </br></br>
   - The response should contain `null`, and the response status is `200 OK`</br></br>
   
4. Edit a trip with a "PATCH" request </br></br>
      - Change the `description`, `imagePath` and `name` of the given json as you see fit:</br>
      ```json
       {

    "description" : "Egypt welcomes you, my friend!",

    "imagePath" : "https://www.karacitours.bg/public/thumbs/767x341/egipet/egipet-4_767x341_crop_542eb8694d.jpg",

    "name" : "Pyramids of Giza, Egypt",

    "edit": "true"

    }
    ```
   
   - Make the "PATCH" request using the following URL: </br>
   https://trips-48955.firebaseio.com/trips/-MIJ0HydEYF0x6fljO55.json </br></br>

   - You should receive the following answer with status `200 OK`: </br>
     [PATCHResponse.json](https://github.com/NMKrastev/SoftUni-Java/blob/dev/Fundamentals/HTTPBasics/src/PATCHResponse.json) </br></br>