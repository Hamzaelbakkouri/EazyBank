package SERVICE;

import DAO.CurrentAccountIPLM;
import DTO.CurrentAccount;
import INTERFACES.CurrentAccountDAO;

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
}
