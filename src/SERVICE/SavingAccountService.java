package SERVICE;

import DAO.CurrentAccountIPLM;
import DAO.SavingAccountIMPL;
import DTO.CurrentAccount;
import DTO.SavingAccount;
import INTERFACES.CurrentAccountDAO;
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

    public Optional<SavingAccount> updateSavingAccount(SavingAccount savingaccount) {
        Optional<SavingAccount> savAccount = Optional.empty();
        try {
            SavingAccountDAO Savingaccount = new SavingAccountIMPL();
            savAccount = Savingaccount.update(savingaccount);
            savAccount = Optional.of(savAccount.get());
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return savAccount;
    }
}
