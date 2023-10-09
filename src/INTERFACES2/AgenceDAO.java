package INTERFACES2;

import DTO.Agence;
import DTO.Employee;

import java.util.List;
import java.util.Optional;

public interface AgenceDAO extends TypeDAO<Agence, String> {
    List<Agence> getAll();
    Optional<Agence> getOneByAdress(Agence agence);
    List<Agence> findByEmploye(Employee employee);
    List<Agence> contact();
}
