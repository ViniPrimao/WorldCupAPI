package br.com.cwi.treinamento.worldcupapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.treinamento.worldcupapi.domain.WorldCup;
import br.com.cwi.treinamento.worldcupapi.error.NotFoundException;
import br.com.cwi.treinamento.worldcupapi.repository.MatchRepository;
import br.com.cwi.treinamento.worldcupapi.repository.WorldCupRepository;

@RequestMapping("/worldcup")
@RestController
public class WorldCupController implements WorldCupApi {

    @Autowired
    private WorldCupRepository repository;

    @Autowired
    private MatchRepository matchRepository;

    @Override
    @GetMapping
    public List<WorldCup> getAll() {
        return repository.findAll();
    }

    @Override
    @GetMapping("/{edition}")
    public WorldCup getByEdition(@PathVariable Integer edition) {

        final WorldCup byEdition = repository.findByEdition(edition);

        if (byEdition == null) {
            throw new NotFoundException("Edição inválida.");
        }

        return byEdition;
    }

    @Override
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody WorldCup worldcup) {
        repository.save(worldcup);
    }
}
