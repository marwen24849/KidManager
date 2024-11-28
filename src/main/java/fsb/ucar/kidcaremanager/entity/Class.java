package fsb.ucar.kidcaremanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "classe")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomClasse;

    @Column(nullable = false)
    private String niveau;

    private String horaire;

    @ManyToMany(mappedBy = "classes")
    private List<Cours> cours;

    @ManyToMany(mappedBy = "classes")
    private List<Evaluation> evaluations;

    @OneToMany
    private List<User> users;

    @OneToOne
    private Emploi emploi;
}
