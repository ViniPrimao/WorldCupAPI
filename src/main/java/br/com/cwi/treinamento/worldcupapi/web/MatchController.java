package br.com.cwi.treinamento.worldcupapi.web;

import java.net.URI;
import java.util.AbstractMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cwi.treinamento.worldcupapi.domain.Match;
import br.com.cwi.treinamento.worldcupapi.error.NotFoundException;
import br.com.cwi.treinamento.worldcupapi.repository.MatchRepository;

@RequestMapping("/match")
@RestController
public class MatchController {

    @Autowired
    private MatchRepository repository;

    @GetMapping
    public List<Match> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Match getById(@PathVariable("id") final Long id) {

        final Match match = repository.findById(id);

        if (match == null) {
            throw new NotFoundException("Jogo não encontrado.");
        }

        return match;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody final Match match) {

        final Match createdMatch = repository.save(match);

        final URI uri = UriComponentsBuilder.fromUriString("/match/{id}")
                .buildAndExpand(createdMatch.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public Match update(@PathVariable("id") final Long id, @RequestBody final Match match) {

        final Match persistentMatch = repository.findById(id);

        if (persistentMatch == null) {
            throw new NotFoundException("Jogo não encontrado.");
        }

        persistentMatch.setWorldCup(match.getWorldCup());
        persistentMatch.setHomeTeam(match.getHomeTeam());
        persistentMatch.setAwayTeam(match.getAwayTeam());
        persistentMatch.setSchedule(match.getSchedule());
        return repository.save(persistentMatch);
    }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {

        final Match match = repository.findById(id);

        if (match == null) {
            throw new NotFoundException("Jogo não encontrado.");
        }

        repository.delete(match);
    }


}
