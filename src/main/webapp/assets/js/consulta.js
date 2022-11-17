function getProposta(e) {

  const id = e.target.id.slice(-2)

  // fetch(`http://localhost:8080/atos-java-servlet/relatorio?id=${id}`)
  // window.location.href = `http://localhost:8080/atos-java-servlet/relatorio?id=${id}`
  window.open(`http://localhost:8080/atos-java-servlet/relatorio?id=${id}`, '_blank')
}

function proposalDelete(e) {

  const id = e.target.id.slice(-2)

  fetch("http://localhost:8080/atos-java-servlet/deletar", {
    method: "POST",
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    body: `id=${id}`
  })
  setTimeout(() => {
    location.reload()
  }, 1000)
}

function atualizarProposta(e) {

  const id = e.target.id.slice(-2)

  const atualizares = document.getElementsByClassName("atualizar")
  let atualizar
  for (let i = 0; i < atualizares.length; i++) {
    if (atualizares[i].id.slice(-2) === id) {
      atualizar = atualizares[i]
    }
  }
  const nome = document.getElementById(`nome_${id}`)
  const qtd = document.getElementById(`qtd_${id}`)
  const sobremesa = document.getElementById(`sobremesa_${id}`)

  if (atualizar.hasAttribute('toUpdate')) {

    nome.removeAttribute('readonly')
    qtd.removeAttribute('readonly')
    sobremesa.removeAttribute('readonly')
  }

  if (nome.hasAttribute('readonly') && qtd.hasAttribute('readonly') && sobremesa.hasAttribute('readonly')) {


    // fetch("http://localhost:500", {
    fetch("http://localhost:8080/atos-java-servlet/atualizar", {
      method: "POST",
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      body: `id=${id}&nome=${nome.value}&quantidade=${qtd.value}&sobremesa=${sobremesa.value}`
    })
    setTimeout(() => {
      location.reload()
    }, 1000)

    atualizar.style.backgroundColor = "rgb(6, 162, 6)"
    atualizar.setAttribute('toUpdate', "")

  } else {

    atualizar.style.backgroundColor = "#046da7"

    nome.style.backgroundColor = "#ccc"
    qtd.style.backgroundColor = "#ccc"
    sobremesa.style.backgroundColor = "#ccc"

    nome.addEventListener('change', () => {
      nome.setAttribute('readonly', "")
      nome.style.backgroundColor = "#fff"
    })

    qtd.addEventListener('change', () => {
      qtd.setAttribute('readonly', "")
      qtd.style.backgroundColor = "#fff"
    })

    sobremesa.addEventListener('change', () => {
      sobremesa.setAttribute('readonly', "")
      sobremesa.style.backgroundColor = "#fff"
    })

    atualizar.removeAttribute('toUpdate')

  }

}