package SERVICE;

import DAO.SavingAccountIMPL;
import DTO.SavingAccount;
import INTERFACES.SavingAccountDAO;

import java.util.Optional;

public class SavingAccountService {
    public Optional<SavingAccount> insertSavingAcc(SavingAccount Saving) {
        Optional<SavingAccount> SavingAccount = Optional.empty();
        try {
            SavingAccountDAO SavingAccoundao = new SavingAccountIMPL();
            SavingAccount = SavingAccoundao.insert(Saving);
            SavingAccount = Optional.of(SavingAccount.get());
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return SavingAccount;
    }

    public Optional<SavingAccount> getOneSavingAccount(String clientcode) {
        Optional<SavingAccount> SavingAccount = Optional.empty();
        try {
            SavingAccountDAO SavingAccoundao = new SavingAccountIMPL();
            SavingAccount = SavingAccoundao.getOne(clientcode);
            SavingAccount = Optional.of(SavingAccount.get());
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return SavingAccount;
    }
}
