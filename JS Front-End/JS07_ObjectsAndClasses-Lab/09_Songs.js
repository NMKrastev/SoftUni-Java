function getSongs(arr) {

    class Song {
        constructor(type, name, time) {
            this.type = type;
            this.name = name;
            this.time = time;
        }
    }

    let songs = [];
    let numOfSongs = arr.shift();
    let typeOfSong = arr.pop();

    for (let i = 0; i < numOfSongs; i++) {
        let [type, name, time] = arr[i].split('_');
        let song = new Song(type, name, time);
        songs.push(song);
    }

    if (typeOfSong === "all") {
        songs.forEach((song) => console.log(song.name));
    } else {
        let filter = songs.filter((song) => song.type === typeOfSong);
        filter.forEach((song) => console.log(song.name));
    }
}

getSongs([3, 'favourite_DownTown_3:14', 'favourite_Kiss_4:16', 'favourite_Smooth Criminal_4:01', 'favourite']);