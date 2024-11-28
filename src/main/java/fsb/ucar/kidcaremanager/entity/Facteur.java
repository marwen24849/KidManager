package fsb.ucar.kidcaremanager.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "facteur")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Facteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private String type;

    private String valeur;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
