package ai.tech.domain.model;

import ai.tech.domain.enums.Status;
import lombok.Data;

@Data
public class Todo {
    private String todo;
    private Status status;
}
