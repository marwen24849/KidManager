package fsb.ucar.kidcaremanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "presence")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Presence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private Boolean present;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User utilisateur;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours;
}
