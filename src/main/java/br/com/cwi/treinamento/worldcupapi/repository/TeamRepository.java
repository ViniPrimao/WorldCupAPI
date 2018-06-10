package br.com.cwi.treinamento.worldcupapi.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.cwi.treinamento.worldcupapi.domain.Team;

public interface TeamRepository extends Repository<Team, Long> {

    List<Team> findAll();

    Team findByCode(String code);

    void save(Team team);

    void delete(Team team);
}

