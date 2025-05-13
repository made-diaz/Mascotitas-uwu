package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MascotaDto;
import com.example.demo.model.Mascota;
import com.example.demo.model.Persona;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.PersonaRepository;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;
    @Autowired
    private PersonaRepository personaRepository;


    //Almacena
    public String almacenar(MascotaDto mascotaDto){

        if(!personaRepository.existsById(mascotaDto.getRut())){
            return "persona no existe";
        }
    

        Persona persona =
        personaRepository.findById(mascotaDto.getRut()).get();

        Mascota mascota = new Mascota();
        mascota.setNombre(mascotaDto.getNombre());
        mascota.setTipo(mascotaDto.getTipo());
        mascota.setPersona(persona);

        mascotaRepository.save(mascota);
        return "mascota guardada";
    }

    public List<Mascota> listar(){
        return mascotaRepository.findAll();
    }
}
