package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAffectation {
    private Employee employee;
    private Agence agence;
    private LocalDate creationDate;
}
