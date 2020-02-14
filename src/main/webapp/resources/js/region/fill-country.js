function updateDepartments() {
    var id = document.getElementById("country_list_id").value;

    $.ajax({
        url: `${pageContext.request.contextPath}/country/${"${id}"}`,
                    type: 'POST',
                    dataType: 'json',
                    success: function (json) {
                        document.getElementById('country_list_department_id').innerHTML = "";
                        $.each(json, function (key, value) {
                            $('<option></option>', {text: value}).attr('value', key).appendTo('#country_list_department_id');
                        });
                        updateMuni();
                    }
                });
            }

            function updateMuni() {
                var id = document.getElementById("country_list_department_id").value;
//                console.log("ENTRO");
                $.ajax({
                    url: `${pageContext.request.contextPath}/department/${"${id}"}`,
                                type: 'POST',
                                dataType: 'json',
                                success: function (json) {
//                        console.log("ENTRO");
                                    document.getElementById('country_list_department_municipality_id').innerHTML = "";
                                    $.each(json, function (key, value) {
//                            console.log(value);
                                        $('<option></option>', {text: value}).attr('value', key).appendTo('#country_list_department_municipality_id');
                                    });
                                }
                            });
                        }
                        function clearMunicipalities() {
                            document.getElementById('country_list_department_municipality_id').innerHTML = "";
                        }
                        function clearDepartments() {
                            document.getElementById('country_list_department_id').innerHTML = "";
                        }
                        $(document).ready(function () {
                            updateDepartments();
                            $("#country_list_id").on("change", function () {
                                clearMunicipalities();
                                clearDepartments();
                                updateDepartments();
                            });
                            $("#country_list_department_id").on("change", function () {
                                clearMunicipalities();
                                updateMuni();
                            });
                        });
