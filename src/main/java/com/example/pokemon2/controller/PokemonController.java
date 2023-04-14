package com.example.pokemon2.controller;

import com.example.pokemon2.entity.Pokemon;
import com.example.pokemon2.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonController {
    @Autowired
    PokemonRepository pokemonRepository;


    @PostMapping("/pokemon")
    public Pokemon create(@RequestBody Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }

    @GetMapping("/pokemons")
    public List <Pokemon> readAll(){
        return pokemonRepository.findAll();
    }
    @GetMapping("/pokemon/{name}")
    public Pokemon readByName(@PathVariable String name){
        return pokemonRepository.findByName(name);

    }
    @PutMapping("/pokemon/{id}")
    public Pokemon update(@PathVariable Long id,@RequestBody Pokemon pokemon){
        Pokemon updatePokemon = pokemonRepository.findById(id).orElse(null);
        updatePokemon.setName(pokemon.getName());
        return pokemonRepository.save(updatePokemon);
    }
    @DeleteMapping("/pokemon/{id}")
    public String delete(@PathVariable Long id){
        pokemonRepository.deleteById(id);
        return "pokemon supprimé";
    }

}
