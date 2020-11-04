package es.uclm.esi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value= "/tareas")
public class EjemploRestController {

 @GetMapping(value= "/saludo")
public String saludo() {
return "test";
}

}
