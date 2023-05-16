package ai.tech.domain.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public enum Status {
    TO_DO("TO DO"),
    IN_PROGRESS("IN PROGRESS"),
    DONE("DONE");

    private final String status;

    @JsonValue
    public String getStatus() {
        return status;
    }
}
