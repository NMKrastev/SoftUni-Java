const baseURL = 'http://localhost:3030/jsonstore/tasks';

const endpoints = {
    update: (id) => `${baseURL}/${id}`,
    delete: (id) => `${baseURL}/${id}`,
}
const foodElement = document.getElementById("food");
const timeElement = document.getElementById("time");
const caloriesElement = document.getElementById("calories");

const list = document.getElementById('list');

const addButton = document.getElementById("add-meal");
const editButton = document.getElementById("edit-meal");
const loadButton = document.getElementById("load-meals");

function attachEvents() {
    loadButton.addEventListener('click', loadBoardEventHandler);
    addButton.addEventListener('click', (ev) => createTaskEventHandler(ev));
}

function getIdByName(task) {
    return fetch(baseURL)
        .then(res => res.json())
        .then(res => Object.entries(res).find(e => e[1].food === task)[1]._id)
}

async function loadBoardEventHandler() {
    clearAllSections();
    try {
        const res = await fetch(baseURL);
        const allTasks = await res.json();
        Object.values(allTasks)
            .forEach((task) => {
                list.innerHTML += `
                <div class="meal">
                    <h2>${task.food}</h2>
                    <h3>${task.time}</h3>
                    <h3>${task.calories}</h3>
                    <div id="meal-buttons">
                        <button class="change-meal">Change</button>
                        <button class="delete-meal">Delete</button>
                    </div>
                </div>`
                document.querySelector('.change-meal').addEventListener('click', (ev) => updateMeal(ev));
                document.querySelector('.delete-meal').addEventListener('click', (ev) => deleteMeal(ev));
            })
    } catch (err) {
        console.error(err);
    }
}

function createTaskEventHandler(ev) {
    clearAllSections();

    ev.preventDefault();
    if(foodElement.value !== '' && timeElement.value !== '' && caloriesElement.value !== '') {

    }
    const headers = {
        method: 'POST',
        body: JSON.stringify({
            food: foodElement.value,
            time: timeElement.value,
            calories: caloriesElement.value,
        })
    };

    fetch(baseURL, headers)
        .then(loadBoardEventHandler)
        .catch(console.error);

    clearAllInputs();
}

async function updateMeal(ev) {
    ev.preventDefault();
    addButton.disabled = true;
    editButton.disabled = false;
    const tr = ev.target.parentElement.parentElement;
    console.log(tr);
    const [food, time, calories] = Array.from(tr.children);
    foodElement.value = food.textContent;
    timeElement.value = time.textContent;
    caloriesElement.value = calories.textContent;

    editMeal(food.textContent);
}

function editMeal(task) {
    editButton.addEventListener('click', (e) => {
        e.preventDefault();
        const data = { food: foodElement.value, time: timeElement.value, calories: caloriesElement.value};
        getIdByName(task)
            .then((id) => fetch(endpoints.update(id), {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    food: data.food,
                    time: data.time,
                    calories: data.calories,
                    _id: id
                })
            }))
            .then(() => {
                foodElement.value = '';
                timeElement.value = '';
                caloriesElement.value = '';
            })
            .then(loadBoardEventHandler);
        addButton.disabled = false;
        editButton.disabled = true;
    })

}

function deleteMeal (ev) {
    const tr = ev.target.parentElement.parentElement;
    const task = Array.from(tr.children)[0];

    getIdByName(task.textContent)
        .then((id) => fetch(endpoints.delete(id), {
            method: 'DELETE',
            headers: { 'content-type': 'application/json' }
        }))
        .then(loadBoardEventHandler);
}

function clearAllSections() {
    document.getElementById('list').innerHTML = '';
}

function clearAllInputs() {
    foodElement.value = '';
    timeElement.value = '';
    caloriesElement.value = '';
}

attachEvents();

