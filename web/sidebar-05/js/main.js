(function ($) {

    "use strict";

    var fullHeight = function () {

        $('.js-fullheight').css('height', $(window).height());
        $(window).resize(function () {
            $('.js-fullheight').css('height', $(window).height());
        });

    };
    fullHeight();

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });

})(jQuery);


//
//$.validator.setDefaults({
//    submitHandler: function () {
//       alert("¡Se registró exitosamente!");
//    }
//});
//
////VALIDACIONES
//$(document).ready(function () {
//
//    $('#miFormulario').validate({
//        rules: {
//            Cantidad: {
//                required: true,
//                number: true
//            }
//
//
//        },
//        messages: {
//            numero: {
//                required: "Por favor ingresa una cantidad",
//                number: "El dato debe ser un número"
//
//            },
//            highlight: function (element, errorClass, validClass) {
//                $(".marquito").addClass("error").removeClass("correcto");
//            },
//            unhighlight: function (element, errorClass, validClass) {
//                $(".marquito").addClass("correcto").removeClass("error");
//            }
//        }
//
//    });
//});
