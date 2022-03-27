<%-- 
    Document   : index2
    Created on : 12/11/2021, 03:27:16
    Author     : carme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <title>Farmacia</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./sidebar-05/css/style.css">
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
            <div id="content" class="p-4 p-md-5 pt-5 img" style="background-image: url('https://laboratoriossyrch.com/wp-content/uploads/2016/02/Perfumes-para-farmacias-fondo-pharma.jpg')">
            <div id="content" class="p-4 p-md-5 pt-5 justify-content-md-center">
                <h1 class="mb-4  colorLetra1 ">LABORATORIO DE COMPUTACIÓN IV</h1>
                <h2 class="mb-4 colorLetra2">Tema 3 - 2w1 - Romero Luna Carmela</h2>
                
            </div>
        </div>

            
        <script src="sidebar-05/js/jquery.min.js"></script>
        <script src="sidebar-05/js/popper.js"></script>
        <script src="sidebar-05/js/bootstrap.min.js"></script>
        <script src="sidebar-05/js/main.js"></script>
    </body>
</html>