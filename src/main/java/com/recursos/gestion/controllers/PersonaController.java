package com.recursos.gestion.controllers;

import com.recursos.gestion.entities.Persona;
import com.recursos.gestion.services.PersonaService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="api/v1/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    private JSONObject ErrorResponse = new JSONObject();
    public PersonaController() {
        //this.personaService = personaService;
    }
    @SuppressWarnings("unchecked")
    @GetMapping(value="/getall",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findAll());
        }catch(Exception ex1) {
            ex1.printStackTrace();
            ErrorResponse.put("Error: ", "Error encontrado en : " + ex1.getMessage().toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse);
        }

    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    personaService.findById(id)
            );
        }catch(Exception ex1) {
            ex1.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    "{\"ERROR\":\"Error, intente nuevamente\"}"
            );
        }

    }
    @SuppressWarnings("unchecked")
    @PostMapping(value="/save",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody Persona entity,@RequestHeader(name="Authorization", required = false) String authorizationHeader){

        Persona entidad = entity;

        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.personaService.save(entidad));
        }catch(Exception ex1) {
            ex1.printStackTrace();
            ErrorResponse.put("Error: ", "Error encontrado en : " + ex1.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse);
        }
    }

}
