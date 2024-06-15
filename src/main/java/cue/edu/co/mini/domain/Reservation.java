package cue.edu.co.mini.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private String name;
    private Double price;
    private String description;
    @ManyToOne
    @JoinColumn(name= "idUser")
    private User user;
    @ManyToOne
    @JoinColumn(name= "idVehicle")
    private Vehicle vehicle;
    private LocalDateTime reservationInit;
    private LocalDateTime reservationFinal;
}
