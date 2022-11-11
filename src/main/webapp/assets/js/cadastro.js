const checkbox = document.getElementById('sobremesa')
const button = document.getElementById('button')

button.addEventListener('click', e => {
    alert(checkbox.checked)
})