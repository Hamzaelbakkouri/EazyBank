package SERVICE;

import DAO.CurrentAccountIPLM;
import DTO.CurrentAccount;
import INTERFACES.CurrentAccountDAO;
import INTERFACES.statut;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CurentAccountService {
    public Optional<CurrentAccount> insertCurrentAcc(CurrentAccount currentAccount) {
        Optional<CurrentAccount> CurrentAccount = Optional.empty();
        try {
            CurrentAccountDAO CurrentAccoundao = new CurrentAccountIPLM();
            CurrentAccount = CurrentAccoundao.insert(currentAccount);
            CurrentAccount = Optional.of(CurrentAccount.get());
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return CurrentAccount;
    }

    public Optional<CurrentAccount> getOneCurrentAccount(String clientcode) {
        Optional<CurrentAccount> CurrentAccount = Optional.empty();
        try {
            CurrentAccountDAO CurrentAccoundao = new CurrentAccountIPLM();
            CurrentAccount = CurrentAccoundao.getOne(clientcode);
            CurrentAccount = Optional.of(CurrentAccount.get());
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return CurrentAccount;
    }

    public Optional<CurrentAccount> updateCurrentAccount(CurrentAccount currentaccount) {
        Optional<CurrentAccount> CurrentAccount = Optional.empty();
        try {
            CurrentAccountDAO CurrentAccoundao = new CurrentAccountIPLM();
            CurrentAccount = CurrentAccoundao.update(currentaccount);
            CurrentAccount = Optional.of(CurrentAccount.get());
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return CurrentAccount;
    }

    public Boolean changeStatut(String accnum, statut stats) {
        Boolean CurrentAccount = false;
        try {
            CurrentAccountDAO CurrentAccoundao = new CurrentAccountIPLM();
            CurrentAccount = CurrentAccoundao.changeStatut(accnum, stats);
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return CurrentAccount;
    }
    public Map<String, Optional<CurrentAccount>> getAllAcc() {
        Map<String, Optional<CurrentAccount>> CurrentAccount = new HashMap<>();
        try {
            CurrentAccountDAO CurrentAccoundao = new CurrentAccountIPLM();
            CurrentAccount = CurrentAccoundao.getAll();
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return CurrentAccount;
    }
}
