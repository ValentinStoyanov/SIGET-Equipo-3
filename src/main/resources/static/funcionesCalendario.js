var hoy = new Date();

var infoMes;
var detallesReuniones;
var detallesDia = 0;

function clickInfoReuniones(ID){

    var jsonDia;

    for(j = 0; j < 31; j++){
    	if(document.getElementById(j) != null){
        	document.getElementById(j).style.border = "2px double #fffafa";
		}
	}
	
    formEnBlanco();
    detallesEnBlanco();

    var hayreu = null;
    var contador = 0;

    for(var k = 0; k < infoMes.reuniones.length; k++){
		if (ID == infoMes.reuniones[k]) {
            reunionesDia(ID,infoMes.mes,infoMes.ano);
            jsonDia = getDetallesReunionDiaC();
			hayreu = true;
		}
	}

	if(hayreu){
    	if(jsonDia == 0){
    		document.getElementById("formularioPreview").insertAdjacentHTML('beforeend',"<div><label>Actualizando...</label></div>");
    	} else {
    	   	var celda = document.getElementById(ID);
            celda.style.border = "2px double coral";
    	    for(i = 0; i < jsonDia.reuniones.length; i++){
    	       	document.getElementById("formularioPreview").insertAdjacentHTML('beforeend',"<div id='reunionYhora'><label id='reunion' "+
    	       	"onclick='mostrarInfoReunion("+jsonDia.reuniones[i].id+","+jsonDia.dia+")'>"+
    	      	jsonDia.reuniones[i].titulo+"</label>"+
    	        "<label id='horasreunion'>"+jsonDia.reuniones[i].hora+"</label><br></div>");
    	    }
    	}
	} else {
		document.getElementById("formularioPreview").insertAdjacentHTML('beforeend',"<div><label>NO HAY REUNIONES</label></div>");
	}
}

function formEnBlanco(){
var borrador = document.getElementById("formularioPreview");
    while (borrador.firstChild){
        borrador.removeChild(borrador.firstChild);
    }
}

function detallesEnBlanco(){
	//Vacía la caja de la derecha cada vez que cambia el día seleccionado
	var tituloB = document.getElementById("titureunion");
    tituloB.setAttribute("value"," ");

    var horaB = document.getElementById("horareunion");
    horaB.setAttribute("value"," ");

    var descripcionB = document.getElementById("descripcion");
    descripcionB.setAttribute("placeholder"," ");

    var asistentesB = document.getElementById("asistentes");
    asistentesB.setAttribute("placeholder"," ");

}

function mostrarInfoReunion(idReunion,diaReunion){
    var jsonMostrar = getDetallesReunionDiaC();

    var titulo = document.getElementById("titureunion");
    titulo.setAttribute("value",jsonMostrar.reuniones[idReunion-1].titulo);

    var hora = document.getElementById("horareunion");
    hora.setAttribute("value",jsonMostrar.reuniones[idReunion-1].hora);

    var descripcion = document.getElementById("descripcion");
    descripcion.setAttribute("placeholder",jsonMostrar.reuniones[idReunion-1].descripcion);

	var strasistentes = "";
    for(i = 0; i < jsonMostrar.reuniones[idReunion-1].asistentes.length; i++){
    	console.log("Los asistentes son"+jsonMostrar.reuniones[idReunion-1].asistentes[i].usuario);
		strasistentes+=jsonMostrar.reuniones[idReunion-1].asistentes[i].usuario+"\n";
    }
    
    var asistentes = document.getElementById("asistentes");
    asistentes.setAttribute("placeholder",strasistentes);
}

function getDetallesReuniones(){
    return detallesReuniones;
}

function setDetallesReuniones(data){
    detallesReuniones = data;
}

function getReunionesMes(){
    return infoMes;
}

function setReunionesMes(data){
    infoMes = data;
}

function reunionesMesHoy(){ //Recibirá un array de días en los que hay reunion
    mesActual = hoy.getMonth() + 1;
    anoActual = hoy.getFullYear();
    var info = {
        type : "PeticionReunionesMes",
        mes : mesActual,
        ano : anoActual,
        usuario : localStorage.getItem("jwt")
    };
    $.ajax({
        url : '/getCalendarioPersonalMes',
        data : JSON.stringify(info),
        async : false,
        type : "post",
        dataType: 'json',
        contentType: 'application/json',
        success : function(response) {
            setReunionesMes(response);
        },
        error : function(response) {
            console.log('Se produjo un problema en reunioesMesHoy()');
        }
    });
}

function reunionesDiaHoy(){ //Pedirá las reuniones del día de hoy, por defecto
    mesActual = hoy.getMonth() + 1;
    var info = {
        "type" : "PeticionDatosReunion",
        "dia" : hoy.getDate(),
        "mes" : mesActual,
        "ano" : hoy.getFullYear(),
        usuario : localStorage.getItem("jwt")
    };
    $.ajax({
        url : '/getDetallesReunion',
        data : JSON.stringify(info),
        async : false,
        type : "post",
        dataType: 'json',
        contentType: 'application/json',
        success : function(response) {
            setDetallesReuniones(response);
            setDetallesReunionDiaC(response);
            clickInfoReuniones(hoy.getDate());
        },
        error : function(response) {
            console.log('Se produjo un problema en reunionesDiaHoy()');
        }
    });
}

function getReunionesMesC(){
    return infoMes;
}

function setReunionesMesC(data){
    infoMes = data;
}

function reunionesMes(mesConcreto, anoConcreto){ //Recibirá las reuniones de un mes concreto
    var info = {
        type : "PeticionReunionesMes",
        mes : mesConcreto,
        ano : anoConcreto,
        usuario : localStorage.getItem("jwt")
    };
    $.ajax({
        url : '/getCalendarioPersonalMes',
        async : false,
        data : JSON.stringify(info),
        type : "post",
        dataType: 'json',
        contentType: 'application/json',
        success : function(response) {
            setReunionesMesC(response);
        },
        error : function(response) {
            console.log('Se produjo un problema en reunionesMes()');
        }
    });
}

function getDetallesReunionDiaC(){
    return detallesDia;
}

function setDetallesReunionDiaC(data){
    detallesDia = data;
}

function reunionesDia(diaConcreto, mesConcreto, anoConcreto){ //Pedirá las reuniones de un día concreto
   	var info = {
        type : "PeticionDatosReunion",
        dia : diaConcreto,
        mes : mesConcreto,
        ano : anoConcreto,
		usuario : localStorage.getItem("jwt")
    };
    $.ajax({
        url : '/getDetallesReunion',
        async : false,
        data : JSON.stringify(info),
        type : "post",
        dataType: 'json',
        contentType: 'application/json',
        success : function(response) {
            setDetallesReunionDiaC(response);
        },
        error : function(response) {
            console.log('Se produjo un problema en reunionesMes()');
        }
    });
}