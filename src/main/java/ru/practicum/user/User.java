package ru.practicum.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;


@Entity
@Table(name = "users", schema = "public")
@Getter @Setter @ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Setter
    @Column(name = "last_name")
    private String lastName;

    @Setter
    private String email;

    @Column(name = "registration_date")
    private Instant registrationDate = Instant.now();

    @Setter
    @Enumerated(EnumType.STRING)
    private UserState state;

}
