package br.com.cwi.treinamento.worldcupapi.domain;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "MATCH")
public class Match {

    private static final String SEQUENCE = "MATCH_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "ID_MATCH")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_WORLD_CUP")
    private WorldCup worldCup;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "teamId", column = @Column(name = "ID_TEAM_A")),
            @AttributeOverride(name = "score", column = @Column(name = "GOALS_TEAM_A"))
    })
    private TeamScore homeTeam;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "teamId", column = @Column(name = "ID_TEAM_B")),
            @AttributeOverride(name = "score", column = @Column(name = "GOALS_TEAM_B"))
    })
    private TeamScore awayTeam;

    @Column(name = "SCHEDULE", nullable = true)
    private LocalDateTime schedule;
}
