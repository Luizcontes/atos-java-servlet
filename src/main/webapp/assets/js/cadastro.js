const nome = document.getElementById('nome')
const quantidade = document.getElementById('quantidade')
const checkbox = document.getElementById('sobremesa')
const button = document.getElementById('button')

function checkfields() {
    
    if (nome.value.length == 0 || quantidade.value.length == 0) {
        button.disabled =  true
    } else {
        button.disabled = false
    }

}

nome.addEventListener('change', e => {
    checkfields()
})

quantidade.addEventListener('change', e => {
    checkfields()
})

button.addEventListener('click', e => {
    event.preventDefault
})
