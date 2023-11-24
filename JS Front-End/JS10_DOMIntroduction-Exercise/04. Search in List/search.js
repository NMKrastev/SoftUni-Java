function search() {

    function clearSearchResults() {
        let searchResults = document.querySelectorAll('.search-results');
        searchResults.forEach(result => result.classList.remove('search-results'));

        let townList = document.getElementById('towns');

        for (let i = 0; i < townList.children.length; i++) {
            townList.children[i].style.textDecoration = 'none';
            townList.children[i].style.fontWeight = 'normal';
        }

        document.getElementById('result').textContent = '';
    }

    let searchInput = document.getElementById('searchText').value.trim().toLowerCase();

    let townList = document.getElementById('towns');
    let result = document.getElementById('result');

    let matches = 0;

    for (let i = 0; i < townList.children.length; i++) {
        let townItem = townList.children[i];
        let townName = townItem.textContent.toLowerCase();

        if (townName.includes(searchInput)) {
            townList.children[i].style.textDecoration = 'underline';
            townList.children[i].style.fontWeight = 'bold';
            matches++;
        }
    }

    result.textContent = `${matches} matches found`;
}
