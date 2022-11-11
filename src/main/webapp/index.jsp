<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Atos Catering</title>

    <link rel="stylesheet" href="./assets/css/reset.css">
    <link rel="stylesheet" href="./assets/css/styles.css">
</head>

<body>
    <div class="container">
        <header class="navbar">
            <img src="./assets/img/logo.jpg" alt="" class="logo">
            <ul class="links">
                <li><a href="./home" class="link">HOME</a></li>
                <li><a href="./cadastro" class="link">CADASTRO</a></li>
                <li><a href="./consulta" class="link">CONSULTA</a></li>
            </ul>
        </header>

        <%out.println("Chupa Cu!!!"); %>
        <%-- Comentario --%>
        <p>Data: <%=new Date()%></p>
        <%! int contador=0;%>
        <p>Visitas: <%=contador++%></p>

        <a href="home">TEST</a>

        <!-- <main id="content" class="content a0">
            <h1 id="titulo">SOLUCOES DE CATERING INOVADORAS</h1>
        </main> -->
        <footer class="rodape">
            <p class="copyright">Todos os direitos reservados &#169; - Contes desenvolvimento LTDA</p>
        </footer>
    </div>
    <script src="./assets/js/frontMsg.js"></script>
    <script src="./assets/js/index.js"></script>
</body>

</html>





<!-- <form action="./api" method="GET">
    <h1>Foda-se!!!</h1>
    <label for="name">Name</label>
    <input id="name" type="text" />
    <input value="Registrar" type="submit" />
</form> -->