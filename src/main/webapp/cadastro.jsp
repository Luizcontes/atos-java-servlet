<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Atos Catering</title>

    <link rel="stylesheet" href="./assets/css/styles.css">
    <link rel="stylesheet" href="./assets/css/reset.css">
    <link rel="stylesheet" href="./assets/css/cadastro.css">
</head>

<body>
    <div class="container">
        <div>
            <header class="navbar">
                <img src="./assets/img/logo.jpg" alt="" class="logo">
                <ul class="links">
                    <li><a href="./" class="link">HOME</a></li>
                    <li><a href="./cadastro" class="link">CADASTRO</a></li>
                    <li><a href="./consulta" class="link">CONSULTA</a></li>
                </ul>
            </header>
            <main id="content" class="cadastro">
                <div>
                    <h1>CADASTRO DE PROPOSTA</h1>
                    <hr>
                </div>
                <div>
                    <form action="cadastrar" method="post" target="_blank">
                        <label class="cadastro__form--block" for="nome">Nome</label>
                        <input id='nome' class="cadastro__form--block" type="text" name="nome">
                        <label class="cadastro__form--block" for="quantidade">Quantidade de convidados</label>
                        <input id='quantidade' class="cadastro__form--block" type="number" name="quantidade">
                        <input id="sobremesa" type="checkbox" name="sobremesa">
                        <label for="sobremesa">Deseja sobremesa?</label>
                        <input disabled="true" id="button" class="cadastro__form--block button" value="Realizar cotacao"
                            type="submit">
                    </form>
                </div>
            </main>
        </div>
        <footer class="rodape">
            <p class="copyright">Todos os direitos reservados &#169; - Contes desenvolvimento LTDA</p>
        </footer>
    </div>
    <script src="./assets/js/cadastro.js"></script>
</body>

</html>