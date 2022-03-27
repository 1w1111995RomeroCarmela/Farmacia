<%-- 
    Document   : ListadoDetalle
    Created on : 01/11/2021, 11:11:01
    Author     : carme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Farmacia</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./sidebar-05/css/style.css">
        <link href="sidebar-05/css/default.min.css" rel="stylesheet" type="text/css"/>
        <link href="sidebar-05/css/alertify.min.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>

        <div class="wrapper d-flex align-items-stretch">
            <nav id="sidebar">
                <div class="custom-menu">
                    <button type="button" id="sidebarCollapse" class="btn btn-primary">
                        <i class="fa fa-bars"></i>
                        <span class="sr-only">Toggle Menu</span>
                    </button>
                </div>
                <div class="p-4">
                    <h1><a href="/LC4Parcial/Inicio.jsp" class="logo">Farmacia <span> Trabajo práctico final</span></a></h1>
                    <ul class="list-unstyled components mb-5">
                        <li class="active">
                            <a href="/LC4Parcial/Inicio.jsp"><span class="fa fa-home mr-3"></span> Inicio</a>
                        </li>                       
                        <li>
                            <a href="ListadoRecetas"><span class="fa fa-check mr-3"></span> Recetas</a>
                        </li>
                        <li>
                            <a href="AltaRecetas"><span class="fa fa-briefcase  mr-3"></span> Registrar recetas</a>
                        </li>                        
                        <li>
                            <a href="ListadoSuministros"><span class="fa fa-cart-plus mr-3"></span> Suministros</a>
                        </li>
                        <li>
                            <a href="AltaSuministros"><span class="fa fa-sticky-note mr-3"></span> Registrar suministros</a>
                        </li>
                        <li>
                            <a href="ListadoClientes"><span class="fa fa-user-circle-o  mr-3"></span>  Clientes</a>
                        </li>
                        <li>                            
                            <a href="ListadoTodosPresupuestos"><span class="fa fa-bar-chart-o mr-3"> </span> Presupuestos </a>
                        </li>
                        <li class="active">                            
                            <a href="#"><span class="  mr-3 fa fa-chevron-right  text-center "></span>  Reportes  </a>
                        </li>

                        <li>                            
                            <a href="ComboProfesionales"><span class="fa fa-bar-chart-o mr-3"></span> Reporte 1</a>
                        </li>
                        <li>

                            <a href="ReporteCantidadRecetas"><span class="fa fa-area-chart mr-3"></span> Reporte 2</a>
                        </li>
                        <li>

                            <a href="ReporteClientesImporte"><span class="fa fa-pie-chart mr-3"></span> Reporte 3</a>
                        </li>
                        <li>

                            <a href="ReporteFaltanteStock"><span class="fa fa-line-chart mr-3"></span> Reporte 4</a>
                        </li>
                        <li>

                            <a href="ReporteRecetaPorSucursal"><span class="fa fa-bar-chart-o mr-3"></span> Reporte 5</a>
                        </li>
                        <li>

                            <a href="/LC4Parcial/index.jsp"><span class="fa fa-power-off mr-3"></span> Salir </a>
                        </li>


                    </ul>



                    <div class="footer">
                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            111995 Carmela Romero Luna
                        </p>
                    </div>

                </div>
            </nav>

            <!-- Page Content  -->
            <div id="content" class="p-4 p-md-5 pt-5">



                <h3 class="d-flex justify-content-center">Detalle de receta</h3>
                <div class="table-wrapper-scroll-y my-custom-scrollbar">
                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th>ID </th>
                                <th>ID Receta</th>
                                <th>Cantidad</th>
                                <th>nombSuministro</th>
                                <th>Venta Libre</th>
                                <th>Precio de lista</th>
                                <th>Precio final</th>
                                <th>Obra social</th>
                                <th>Descuento</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.lst}" var="r">
                                <tr>
                                    <td>${r.idDetalleReceta}</td>
                                    <td>${r.idReceta}</td>
                                    <td>${r.cantidad}</td>
                                    <td>${r.nombSuministro}</td>
                                    <c:if test="${s.esVentaLibre}">
                                        <td>Si</td>
                                    </c:if>
                                    <c:if test="${!s.esVentaLibre}">
                                        <td>No</td>
                                    </c:if>                              
                                    <td>${r.precOriginal}</td>
                                    <td>${r.precFinal}</td>
                                    <td>${r.obraSocial}</td>
                                    <td>${r.descCobertura}</td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>



       


        <script src="sidebar-05/js/jquery.min.js"></script>
        <script src="sidebar-05/js/popper.js"></script>
        <script src="sidebar-05/js/bootstrap.min.js"></script>
        <script src="sidebar-05/js/main.js"></script>
        <script src="sidebar-05/css/alertify.min.js" type="text/javascript"></script>

    </body>
</html>