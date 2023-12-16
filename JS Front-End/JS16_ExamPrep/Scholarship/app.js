function solve() {

    const studentName = document.getElementById('student');
    const university = document.getElementById('university');
    const score = document.getElementById('score');

    const nextButton = document.getElementById('next-btn');

    nextButton.addEventListener('click', applyForScholarship);

    function applyForScholarship() {

        let isApplyValid = studentName.value !== ''
            && university.value !== '' && score.value !== '';

        if (!isApplyValid) {
            return;
        }

        let name = studentName.value;
        let uni = university.value;
        let studentScore = score.value;

        const previewList = document.getElementById('preview-list');
        const li = document.createElement('li');
        li.classList.add('application');

        const article = document.createElement('article');

        const h4 = document.createElement('h4');
        const pUniversity = document.createElement('p');
        const pScore = document.createElement('p');

        h4.textContent = name;
        pUniversity.textContent = `University: ${uni}`;
        pScore.textContent = `Score: ${studentScore}`;

        article.appendChild(h4);
        article.appendChild(pUniversity);
        article.appendChild(pScore);

        const editButton = document.createElement('button');
        editButton.textContent = 'edit';
        editButton.classList.add('action-btn');
        editButton.classList.add('edit');
        editButton.addEventListener('click', edit);

        const applyButton = document.createElement('button');
        applyButton.textContent = 'apply';
        applyButton.classList.add('action-btn');
        applyButton.classList.add('apply');
        applyButton.addEventListener('click', apply);

        li.appendChild(article);
        li.appendChild(editButton);
        li.appendChild(applyButton);
        previewList.appendChild(li);

        studentName.value = '';
        university.value = '';
        score.value = '';
        nextButton.disabled = true;

        function edit() {

            studentName.value = name;
            university.value = uni;
            score.value = studentScore;

            li.remove();
            nextButton.disabled = false;
        }

        function apply() {

            const candidatesList = document.getElementById('candidates-list');

            previewList.removeChild(li);

            li.removeChild(editButton);
            li.removeChild(applyButton);

            candidatesList.appendChild(li);

            nextButton.disabled = false;

        }
    }

}
  