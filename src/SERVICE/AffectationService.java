package SERVICE;

import DAO.AffectationIMPL;
import DTO.Affectation;
import INTERFACES.AffectationDAO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AffectationService {
    public Optional<Affectation> insertAffectation(Affectation affectation) {
        Optional<Affectation> newaffectation = Optional.empty();
        try {
            AffectationDAO Affectationdao = new AffectationIMPL();
            newaffectation = Affectationdao.insert(affectation);
            newaffectation = Optional.of(newaffectation.get());
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return newaffectation;
    }

    public List<Map<String, String>> getEmployeeAffectations(String num) {
        List<Map<String, String>> newaffectation = null;
        try {
            AffectationDAO Affectationdao = new AffectationIMPL();
            newaffectation = Affectationdao.getEmployeeAffectations(num);
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return newaffectation;
    }
}
