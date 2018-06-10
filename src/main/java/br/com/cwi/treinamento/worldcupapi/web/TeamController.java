package br.com.cwi.treinamento.worldcupapi.web;

import static java.util.Optional.ofNullable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.treinamento.worldcupapi.domain.Team;
import br.com.cwi.treinamento.worldcupapi.error.NotFoundException;
import br.com.cwi.treinamento.worldcupapi.repository.TeamRepository;

@RequestMapping("/team")
@RestController
public class TeamController {

    @Autowired
    private TeamRepository repository;

    @GetMapping
    public List<Team> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{code}")
    public Team getByCode(@PathVariable final String code) {

        return ofNullable(repository.findByCode(code))
                .orElseThrow(() -> new NotFoundException("Time não encontrado."));
    }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final Team team) {
        repository.save(team);
    }

    @DeleteMapping("/{code}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final String code) {

        final Team team = ofNullable(repository.findByCode(code))
                .orElseThrow(() -> new NotFoundException("Time não encontrado."));

        repository.delete(team);
    }
}

