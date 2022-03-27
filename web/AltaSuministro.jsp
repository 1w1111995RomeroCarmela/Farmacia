<%-- 
    Document   : AltaSuministro
    Created on : 31/10/2021, 16:15:19
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
                            <a href="#"><span class="fa fa-bar-chart-o mr-3"> </span> Presupuestos </a>
                        </li>
                        <li class="active">                            
                            <a href="ListadoTodosPresupuestos"><span class="  mr-3 fa fa-chevron-right  text-center "></span>  Reportes  </a>
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




                <h3 class="mb-3 d-flex justify-content-center">Registrar un suministro</h3>
                <form action="AltaSuministros" method="POST" name="miForm"  onsubmit="return validar_nombre()" >

                    <div class="form-group">
                        <!-------------------- -->
                        <div class="row">

                            <div class="col-sm-4 col-md-4 ">
                                <label for="exampleFormControlInput1">Nombre</label>
                                <input type="text" class="form-control marcoError" name="txtNombre" id="nombre"
                                       placeholder="Nombre del suministro" onkeypress="return validarTexto(event)" /><br />
                            </div>

                            <div class="col-sm-4 col-md-4 ">
                                <label for="exampleFormControlInput1">Precio</label>
                                <input type="text" class="form-control marcoError" name="txtPrecio" 
                                       placeholder="Ingrese el precio"  onkeypress="return soloNumeros(event)" /><br />
                            </div>
                            <div class="col-sm-4 col-md-4 ">
                                <label for="exampleFormControlInput1">Stock</label>
                                <input type="text" class="form-control" id="stock" name="txtStock"
                                       placeholder="Ingrese Stock"  onkeypress="return soloNumeros(event)" /><br />
                            </div>
                        </div>

                        <!------------------>






                        <!------------ -->
                        <div class="row">
                            <div class="col-sm-4 ">

                                <label for="cboTipoSuministro">Tipo de suministro</label>
                                <select class="form-control" id="cboSucursal" name="cboTipoSuministro">                                            

                                    <c:forEach items ="${requestScope.lstTipoSuministro}" var ="ts">
                                        <option value ="${ts.idTipoSuministro}">
                                            ${ts.descripcion}
                                        </option>
                                    </c:forEach>>
                                </select>

                            </div>
                            <div class="col-sm-4 ">

                                <label for="cboSucursal">Sucursal</label>
                                <select class="form-control" id="cboSucursal" name="cboSucursal">                                            

                                    <c:forEach items ="${requestScope.lstSucursal}" var ="suc">
                                        <option value ="${suc.idSucursal}">
                                            ${suc.nombre}
                                        </option>
                                    </c:forEach>>
                                </select>

                            </div>
                            <div class="col-sm-4 ">
                                <!-- COMBOBOX-->
                                <label for="cboObraSocial">Obra Social</label>
                                <select class="form-control" id="cboObraSocial" name="cboObraSocial">                                            

                                    <c:forEach items ="${requestScope.lstObraSocial}" var ="obraS">
                                        <option value ="${obraS.idObraSocial}">
                                            ${obraS.nombre}
                                        </option>
                                    </c:forEach>>
                                </select>

                            </div>

                        </div>  
                        <!------------ -->
                        <div class="row mt-3">                            

                            <div class="col-sm-4 col-md-4 ">
                                <label for="exampleFormControlInput1">Descuento</label>
                                <input type="text" class="form-control" id="Descuento" name="txtDescuento"
                                       placeholder="Ingresá Descuento" onkeypress="return soloNumeros(event)" /><br />
                            </div>  
                            <div class="col-sm-4 col-md-4 ">
                                <label for="cboTipoSuministro"></label>
                                <div class="form-check "> 
                                    <input class="form-check-inpu  custom-checkboxt" type="checkbox" value="" id="chkVentaLibre"  name="chkVentaLibre">
                                    <label class="form-check-labe " style="margin-top: 10px" for="defaultCheck1"> <p style="margin-left: 15px">¿Es de venta libre? </p></label>                                    
                                </div>
                            </div>                            
                            <div class="col-sm-4 "> 
                                <br>   
                                <button type="submit" class="form-control btn btn-primary btn-block" id="registrar">
                                    Registrar
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script>
            function validar_nombre() {
                stock = document.miForm.txtStock.value;
                descuento = document.miForm.txtDescuento.value;
                precio = document.miForm.txtPrecio.value;
                nombre = document.miForm.txtNombre.value;

                if (stock.length == 0 || descuento.length == 0 || precio.length==0 || nombre.length == 0) {
                    alertify.alert("ERROR", "ingrese todos los datos ").set('input', 'Ok');
                    return false;
                } else {
                    alertify.success("Suministro ingresado");
                }
                return true;
            }
            function validarTexto(e) {
                tecla = e.keyCode;
                teclado = String.fromCharCode(tecla);
                if ((teclado < 'A' || teclado > 'z') && teclado != " ") {
                    return false;
                }
            }
            function soloNumeros(e) {
                tecla = e.keyCode;
                teclado = String.fromCharCode(tecla);

                numeros = "0123456789";
                especiales = "8-37-38-46-190-188";
                tecladoEspecial = false;

                for (var i in especiales) {
                    if (tecla == especiales[i]) {
                        teclado_especial = true;
                    }
                }
                if (numeros.indexOf(teclado) == -1 && !tecladoEspecial) {
                    return false;
                }
            }

           
            



        </script>  

        <script src="sidebar-05/js/jquery.min.js"></script>
        <script src="sidebar-05/js/popper.js"></script>
        <script src="sidebar-05/js/bootstrap.min.js"></script>
        <script src="sidebar-05/js/main.js"></script>
        <script src="sidebar-05/css/alertify.min.js" type="text/javascript"></script>
    </body>
</html>