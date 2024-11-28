package fsb.ucar.kidcaremanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "emploi")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Emploi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @OneToOne
    @JoinColumn(name = "classe_id")
    private Class classe;
}
