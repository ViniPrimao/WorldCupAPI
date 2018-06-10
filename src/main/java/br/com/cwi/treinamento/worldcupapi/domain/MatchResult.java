package br.com.cwi.treinamento.worldcupapi.domain;

public interface MatchResult {

    String getHomeTeam();

    Integer getHomeScore();

    String getAwayTeam();

    Integer getAwayScore();
}
