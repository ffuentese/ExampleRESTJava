<%-- 
    Document   : client
    Created on : 04-02-2017, 22:20:19
    Author     : Francisco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script >

            var webresource = "<%= getServletContext().getContextPath()%>/webresources";
            var countryREST = webresource + "/country";
            function getAuthPairs() {
                return {user: $("#usuario").val(), password: $("#contrasenia").val()};
            }
            function init() {
            $("#getCountryBtn").click(function () { //definiendo el evento click del boton #factorialBtn
            var auth = getAuthPairs();
                    var vBase = $("#f_base").val(); //obteniendo el valor del input #f_base
                    $.ajax(
                    {url: countryREST + "?id=" + vBase,
                            type: 'GET',
                            contentType: "application/json",
                            dataType: 'json',
                            username: auth.user,
                            password: auth.password,
                            success: function (resp) { //webservice responded successfully
                            if ($.isArray(resp) === false) {
                                    $("#f_id").text(resp.id); 
                                    $("#f_name").text(resp.name);
                                    $("#f_capital").text(resp.capital);
                            } else {
                                    $("#f_id").text(""); //... muestra el resultado obtenido en resp en el div
                                    $("#f_name").text("");
                                    $("#f_capital").text("");
                            }
                            },
                            error: function (resp) {
                                    $("#f_id").text(""); // in case there's no object with that ID will throw a text
                                    $("#f_name").text("");
                                    $("#f_capital").text("");
                                    alert(resp.responseText);
                            }
                    });
            });
            }
        </script>
    </head>
    <body>
        <h1>Countries</h1>

        <form>
            <fieldset>
                <legend>Inicio de sesión</legend>
                <label for="usuario">User</label><input type="text" name="usuario" id="usuario"/><br/>
                <label for="contrasenia">Password</label><input type="password" name="contrasenia" id="contrasenia"/><br/>

            </fieldset>
        </form>
        <form method="GET">
            <fieldset>
                <legend>Country</legend>
                <label for="f_base">Id</label><input id="f_base" name="id"  /><br/>
                <button id="getCountryBtn" type="button">Get country by ID</button>
                <br/>
                <label for="f_id">Id: </label>
                <div id="f_id"></div>
                <label for="f_name">Name: </label>
                <div id="f_name"></div>
                <label for="f_capital">Capital: </label>
                <div id="f_capital"></div>
            </fieldset>
        </form>


    </body>
    <script type="text/javascript">
        $(document).ready(init)
    </script>
</html>