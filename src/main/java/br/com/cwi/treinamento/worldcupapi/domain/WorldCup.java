package br.com.cwi.treinamento.worldcupapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "WORLD_CUP")
public class WorldCup {

    private static final String SEQUENCE = "WORLD_CUP_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "ID_WORLD_CUP")
    private Long id;

    @Column(name = "EDITION", length = 4, unique = true, nullable = false)
    private Integer edition;

    @Column(name = "HOST", length = 30, nullable = false)
    private String host;
}
