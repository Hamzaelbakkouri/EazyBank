package SERVICE;

import DAO.ClientIMPL;
import DAO.CurrentAccountIPLM;
import DTO.Client;
import DTO.CurrentAccount;
import INTERFACES.ClientDAO;
import INTERFACES.CurrentAccountDAO;

import java.sql.SQLException;
import java.util.Optional;

public class CurentAccountService {
    public Optional<CurrentAccount> insertCurrentAcc(CurrentAccount currentAccount) {
        Optional<CurrentAccount> CurrentAccount = Optional.empty();
        try {
            CurrentAccountDAO CurrentAccoundao = new CurrentAccountIPLM();
            CurrentAccount = CurrentAccoundao.insert(currentAccount);
            CurrentAccount = Optional.of(CurrentAccount.get());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CurrentAccount;
    }

    public Optional<CurrentAccount> getOneCurrentAccount(String clientcode) {
        Optional<CurrentAccount> CurrentAccount = Optional.empty();
        try {
            CurrentAccountDAO CurrentAccoundao = new CurrentAccountIPLM();
            CurrentAccount = CurrentAccoundao.getOne(clientcode);
            CurrentAccount = Optional.of(CurrentAccount.get());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CurrentAccount;
    }
}
