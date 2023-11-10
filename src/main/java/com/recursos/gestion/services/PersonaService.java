package com.recursos.gestion.services;

import com.recursos.gestion.entities.Persona;
import com.recursos.gestion.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements BaseService<Persona>{
    private PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }
    @Override
    public List<Persona> findAll() throws Exception {
        // TODO Auto-generated method stub
        try {
            List<Persona> entities = this.personaRepository.findAll();
            return entities;
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Persona findById(Long id) throws Exception {
        // TODO Auto-generated method stub
        try {
            Optional<Persona> entityOptional = this.personaRepository.findById(id);
            return entityOptional.get();
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Persona save(Persona entity) throws Exception {
        // TODO Auto-generated method stub
        try {
            entity = this.personaRepository.save(entity);
            return entity;
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Persona update(Long id, Persona entity) throws Exception {
        // TODO Auto-generated method stub
        try {
            Optional<Persona> entityOptional = this.personaRepository.findById(id);
            Persona persona = entityOptional.get();
            persona = personaRepository.save(persona);
            return persona;
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        try {
            if(this.personaRepository.existsById(id)) {
                this.personaRepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
