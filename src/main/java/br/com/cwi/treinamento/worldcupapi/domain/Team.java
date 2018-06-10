package br.com.cwi.treinamento.worldcupapi.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TEAM")
public class Team {

    private static final String SEQUENCE = "TEAM_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "ID_TEAM")
    private Long id;

    @Column(name = "CODE", length = 3, unique = true, nullable = false)
    private String code;

    @Column(name = "NAME", length = 30, nullable = false)
    private String name;
}
