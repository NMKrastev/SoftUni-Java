function editElement(element, oldValue, newValue) {

    const content = element.textContent;

    element.textContent = content.replace(new RegExp(oldValue, 'g'), newValue);

}