package br.com.cwi.treinamento.worldcupapi.repository;

import java.util.List;

import br.com.cwi.treinamento.worldcupapi.domain.WorldCup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface WorldCupRepository extends Repository<WorldCup, Long> {

    List<WorldCup> findAll();

    WorldCup findByEdition(Integer edition);

    void save(WorldCup worldcup);
}
