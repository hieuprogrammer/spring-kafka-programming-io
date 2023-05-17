package ai.tech.domain.model;

import ai.tech.domain.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Todo {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private UUID id;
    private String todo;
    private Status status;
}
