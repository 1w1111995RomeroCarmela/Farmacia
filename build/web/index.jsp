<%-- 
    Document   : Login
    Created on : 13/11/2021, 18:59:42
    Author     : carme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<!-- Representa la raíz de un documento HTML o XHTML. Todos los demás elementos deben ser descendientes de este elemento. -->
<html lang="es">

    <head>

        <meta charset="utf-8">

        <title> Login </title>    

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <meta name="author" content="Videojuegos & Desarrollo">
        <meta name="description" content="Ejemplo de formulario de acceso basado en HTML5 y CSS">
        <meta name="keywords" content="login,formulariode acceso html">  
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="sidebar-05/css/login.css">
       

        </script>

    </head>

    <body>

        
        <div id="contenedor" >
 
            <div id="contenedorcentrado">
                <div id="login">
                    <form id="loginform" action="login" method="POST">
                        <label for="usuario">Usuario</label>
                        <input id="usuario" type="text" name="user" placeholder="Usuario" required>

                        <label for="password">Contraseña</label>
                        <input id="password" type="password" placeholder="Contraseña" name="pass" required>

                        <button  type="submit" title="Ingresar" name="Ingresar">Login</button>
                    </form>

                </div>
                <div id="derecho">
                    <div class="titulo">
                        Bienvenido
                    </div>
                    <hr>
                   
                </div>
            </div>
        </div>

    </body>
</html>