<%@ page import="model.Proposta" %>
    <%@ page import="java.util.ArrayList" %>
        <% ArrayList<Proposta> propostas = (ArrayList<Proposta>) request.getAttribute("propostas"); %>


                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Atos Catering</title>

                    <link rel="stylesheet" href="./assets/css/styles.css">
                    <link rel="stylesheet" href="./assets/css/reset.css">
                    <link rel="stylesheet" href="./assets/css/consulta.css">
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

                            <main id="content" class="consultar">
                                <div>
                                    <h1>CONSULTAR PROPOSTA</h1>
                                    <div>
                                        <form action="consultar" method="post">
                                            <label class="consultar__form--block" for="nome">Nome</label>
                                            <input id='nome' class="consultar__form--block" type="text" name="nome">

                                            <input id="button" class="consultar__form--block button"
                                                value="Buscar cotacao" type="submit">
                                        </form>
                                    </div>
                                </div>
                            </main>
                            <hr>

                            <table class="propostas">
                                <% if ( propostas !=null ) { %>
                                    <thead>
                                        <tr>
                                            <th>Nome</th>
                                            <th>Convidados</th>
                                            <th>Sobremesa</th>
                                            <th>Preco Total</th>
                                            <th class="semBorda"></th>
                                            <th class="semBorda"></th>
                                            <th class="semBorda"></th>
                                            <th class="semBorda"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for (int i=0; i < propostas.size(); i++) { %>

                                            <tr id="table_row<%= propostas.get(i).getId() %>">
                                                <td>
                                                    <div class="update">
                                                        <input class="input" readonly type="text" id="nome_<%= propostas.get(i).getId() %>"
                                                            value="<%= propostas.get(i).getNome() %>">
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="update">
                                                        <input class="input" readonly type="text" id="qtd_<%= propostas.get(i).getId() %>"
                                                            value="<%= propostas.get(i).getQuantidade() %>">
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="update checkbox">
                                                        <input class="input" readonly type="text" id="sobremesa_<%= propostas.get(i).getId() %>"
                                                            value="<%= propostas.get(i).getSobremesa() %>">
                                                        </inp>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="update">
                                                        <input class="input" readonly type="text"
                                                            value="R$ <%= propostas.get(i).getPrecoTotal() %> ">
                                                    </div>
                                                </td>
                                                <td class="botao">
                                                    <input id="atualizar_<%= propostas.get(i).getId()%>" class="atualizar"
                                                        value="Atualizar" type="button" toUpdate
                                                        onclick="atualizarProposta(event)">
                                                </td>
                                                <td class="botao">
                                                    <input id="deletar<%= propostas.get(i).getId() %>" class="deletar"
                                                        value="Deletar" type="button" onclick="proposalDelete(event)">
                                                </td>
                                                <td class="botao">
                                                    <input id="proposta<%= propostas.get(i).getId() %>" class="proposta"
                                                        value="Proposta" type="button" onclick="getProposta(event)">
                                                </td>
                                            </tr>
                                            <% } %>
                                    </tbody>
                                    <% } %>
                            </table>
                        </div>

                        <footer class="rodape">
                            <p class="copyright">Todos os direitos reservados &#169; - Contes desenvolvimento LTDA</p>
                        </footer>
                    </div>
                    <script src="./assets/js/consulta.js"></script>
                </body>

                </html>