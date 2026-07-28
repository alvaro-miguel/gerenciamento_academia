package com.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "item_treino")
public class ItemTreino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemTreino;

    @Column(nullable = false)
    private Integer series;

    @Column(nullable = false)
    private Integer reps;

    @Column(nullable = false)
    private Integer carga;

    @ManyToOne
    @JoinColumn(name = "exercicio_id")
    private Exercicio exercicio;

    @ManyToOne
    @JoinColumn(name = "divisao_id")
    private DivisaoTreino divisaoTreino;

    public ItemTreino(){
    }

    public Long getIdItemTreino() {
        return idItemTreino;
    }

    public Integer getSeries() {
        return series;
    }

    public Integer getReps() {
        return reps;
    }

    public Integer getCarga() {
        return carga;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public DivisaoTreino getDivisaoTreino() {
        return divisaoTreino;
    }

    public void setIdItemTreino(Long idItemTreino) {
        this.idItemTreino = idItemTreino;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public void setCarga(Integer carga) {
        this.carga = carga;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public void setDivisaoTreino(DivisaoTreino divisaoTreino) {
        this.divisaoTreino = divisaoTreino;
    }
}
