$(document).on("click", "#btnAgregar", function () {
    resetForm();
    cboMedicos(0);
    $("#modalEspecialidad").modal("show")
})

$(document).on("click", ".btn-actualizar", function () {
    var $this = $(this),
        data = $this.data();
    $("#hIdEspecialidad").val(data.eid);
    $("#titulo").val(data.etit);
    $("#funcion").val(data.efun);
    $("#fechagraduacion").val(data.efgra);
    $("#cbomedico").empty();
    cboMedicos(data.emed);
    $("#modalEspecialidad").modal("show");
});

$(document).on("click", "#btnInsert", function () {
    var especialidad = {
        idespecialidad: $("#hIdEspecialidad").val(),
        titulo: $("#titulo").val(),
        funcion: $("#funcion").val(),
        fechagraduacion: $("#fechagraduacion").val(),
        idmedico: $("#cbomedico").val(),
    };

    $.ajax({
        type: "POST",
        url: "/especialidad/register",
        contentType: "application/json",
        data: JSON.stringify(especialidad),
        success: function (result) {
            if (result.respuesta) {
                listEspecialidades();
            }
            alert(result.mensaje);
        }
    });

    $("#modalEspecialidad").modal("hide");
});

function listEspecialidades() {
    $.ajax({
        type: "GET",
        url: "/especialidad/list",
        dataType: "json",
        success: function (result) {
            var $tbody = $("#tableEspecialidad > tbody");
            $tbody.empty();
            result.forEach(function (value) {
                $tbody.append(`<tr>
                        <td>${value.idespecialidad}</td>
                        <td>${value.titulo}</td>
                        <td>${value.funcion}</td>
                        <td>${value.fechagraduacion}</td>
                        <td>${value.medico.nommedico}</td>
                        <td>${value.medico.apemedico}</td>
                        <td><button type='button' class='btn btn-primary btn-actualizar'
                            data-eid="${value.idespecialidad}"
                            data-etit="${value.titulo}"
                            data-efun="${value.funcion}"
                            data-efgra="${value.fechagraduacion}"
                            data-emed="${value.medico.idmedico}">Actualizar
                            </button></td>
                            <td><button type='button' class='btn btn-danger btn-eliminar'
                            data-eid="${value.idespecialidad}">Eliminar
                            </button></td>
                        </tr>`);
            });
        }
    });
}

function cboMedicos(idmedico) {
    $.ajax({
        type: "GET",
        url: "/medico/list",
        dataType: "JSON",
        success: function (resultado) {
            $.each(resultado, function (index, value) {
                $("#cbomedico").append(
                    `<option value ="${value.idmedico}">${value.nommedico}</option>`
                )
            });
            if (idmedico > 0) {
                $("#cbomedico").val(idmedico)
            }
        }
    })
}

function resetForm() {
    $("#titulo, #funcion", "#fechagraduacion").val("");
    $("#hIdEspecialidad").val("0");
    $("#cbomedico").empty();
}

$(document).on("click", ".btn-eliminar", function () {
    var id = $(this).data("eid");

    if (confirm("¿Estás seguro de que quieres eliminar esta especialidad?")) {
        $.ajax({
            type: "DELETE",
            url: "/especialidad/eliminar/" + id,
            success: function (result) {
                if (result.respuesta) {
                    listEspecialidades();
                }
                alert(result.mensaje);
            }
        });
    }
});
