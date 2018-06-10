package br.com.cwi.treinamento.worldcupapi.domain;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "teamId")
@Embeddable
public class TeamScore {

    private Long teamId;

    private Integer score;
}
