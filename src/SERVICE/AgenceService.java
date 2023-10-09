package SERVICE;

import DTO.Agence;
import DTO.Employee;
import INTERFACES2.AgenceDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgenceService {
    private final AgenceDAO AgenceIMPL;

    public AgenceService(AgenceDAO agenceIMPL) {
        this.AgenceIMPL = agenceIMPL;
    }


    public Optional<Agence> findByCode(Agence agence) {
        Optional<Agence> theNewAgence = null;
        try {
            theNewAgence = this.AgenceIMPL.getOne(agence);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theNewAgence;
    }

    public boolean delete(Agence agence) {
        boolean theNewAgence = false;
        try {
            theNewAgence = this.AgenceIMPL.delete(agence);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theNewAgence;
    }

    public Optional<Agence> getByAdress(Agence agence) {
        Optional<Agence> theNewAgence = null;
        try {
            theNewAgence = this.AgenceIMPL.getOneByAdress(agence);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theNewAgence;
    }

    public Optional<Agence> update(Agence agence) {
        Optional<Agence> theNewAgence = null;
        try {
            theNewAgence = this.AgenceIMPL.update(agence);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theNewAgence;
    }

    public List<Agence> getByEmployee(Employee employe) {
        List<Agence> theNewAgence = new ArrayList<>();
        try {
            theNewAgence = this.AgenceIMPL.findByEmploye(employe);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theNewAgence;
    }

    public List<Agence> getAll() {
        List<Agence> theNewAgence = new ArrayList<>();
        try {
            theNewAgence = this.AgenceIMPL.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theNewAgence;
    }

    public Optional<Agence> insert(Agence agence) {
        Optional<Agence> theNewAgence = null;
        try {
            theNewAgence = this.AgenceIMPL.insert(agence);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theNewAgence;
    }

    public List<Agence> agenceContact() {
        List<Agence> theNewAgence = new ArrayList<>();
        try {
            theNewAgence = this.AgenceIMPL.contact();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theNewAgence;
    }
}
