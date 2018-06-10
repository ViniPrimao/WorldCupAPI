package br.com.cwi.treinamento.worldcupapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import br.com.cwi.treinamento.worldcupapi.domain.Match;
import br.com.cwi.treinamento.worldcupapi.domain.MatchResult;

public interface MatchRepository extends Repository<Match, Long> {

    String MATCH_RESULT_QUERY = "SELECT TA.CODE AS \"homeTeam\", M.GOALS_TEAM_A AS \"homeScore\", TB.CODE AS \"awayTeam\", M.GOALS_TEAM_B AS \"awayScore\" " +
            "FROM MATCH M " +
            "INNER JOIN TEAM TA ON M.ID_TEAM_A = TA.ID_TEAM " +
            "INNER JOIN TEAM TB ON M.ID_TEAM_B = TB.ID_TEAM " +
            "WHERE M.ID_MATCH = ?1";

    List<Match> findAll();

    @Query(value = MATCH_RESULT_QUERY, nativeQuery = true)
    MatchResult findMatchResult(Long id);

    Match findById(Long id);

    Match save(Match match);

    void delete(Match match);
}
