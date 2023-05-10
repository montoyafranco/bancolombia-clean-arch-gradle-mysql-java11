package co.com.bancolombia.model.patient;
import lombok.*;
//import lombok.NoArgsConstructor;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Patient {
    private Long id;

    private String name;

    public Patient(String name) {
        this.name = name;
    }
}
