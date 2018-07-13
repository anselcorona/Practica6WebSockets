'use strict';

$("#adelante").on("click", function () {

    var direccion = document.getElementById('adelante');

    console.log("entro uff");

    $(document).ready(function () {

        $.ajax({

            url: direccion.dataset.ruta, success: function (data) {
                $('#contenido').html(data);
            }
        });
    });
});

$("#atras").on("click", function () {

    var direccion = document.getElementById('atras');

    console.log("entro uff");

    $(document).ready(function () {

        $.ajax({
            url: direccion.dataset.ruta, success: function (data) {
                $('#contenido').html(data);
            }
        });
    });
});