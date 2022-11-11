const main = document.getElementById('content')
const titulo = document.getElementById('titulo')

let i = 0
let j;
setInterval(() => {
    j = i
    i += 1
    i = i % 7
    main.classList.replace('a' + j, 'a' + i)
    titulo.textContent = msg[i]
}, 5000)


