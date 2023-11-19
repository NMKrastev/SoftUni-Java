function getMeetingsInfo(arr) {
    const meetings = {};

    for (const element of arr) {

        const [day, name] = element.split(' ');

        if (!meetings.hasOwnProperty(day)) {
            meetings[day] = name;
            console.log(`Scheduled for ${day}`)
        } else {
            console.log(`Conflict on ${day}!`);
        }
    }

    for (const day in meetings) {
        console.log(`${day} -> ${meetings[day]}`);
    }
}

getMeetingsInfo(['Monday Peter', 'Wednesday Bill', 'Monday Tim', 'Friday Tim']);