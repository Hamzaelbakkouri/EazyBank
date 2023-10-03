package SERVICE;

import DAO.SavingAccountIMPL;
import DTO.SavingAccount;
import INTERFACES.SavingAccountDAO;
import INTERFACES.statut;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
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

    public Map<String, Optional<SavingAccount>> getAllSavingAcc() {
        Map<String, Optional<SavingAccount>> CurrentAccount = new HashMap<>();
        try {
            SavingAccountDAO SavingAccountdao = new SavingAccountIMPL();
            CurrentAccount = SavingAccountdao.getAll();
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return CurrentAccount;
    }

    public Map<String, Optional<SavingAccount>> getByStatut(statut stats) {
        Map<String, Optional<SavingAccount>> CurrentAccount = new HashMap<>();
        try {
            SavingAccountDAO SavingAccountdao = new SavingAccountIMPL();
            CurrentAccount = SavingAccountdao.showByStatus(stats);
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return CurrentAccount;
    }

    public Map<String, Optional<SavingAccount>> getByCreationDate(LocalDate date) {
        Map<String, Optional<SavingAccount>> CurrentAccount = new HashMap<>();
        try {
            SavingAccountDAO SavingAccountdao = new SavingAccountIMPL();
            CurrentAccount = SavingAccountdao.showByCreationDate(date);
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return CurrentAccount;
    }

    public Map<String, Optional<SavingAccount>> SearchByClient(String client_code) {
        Map<String, Optional<SavingAccount>> CurrentAccount = new HashMap<>();
        try {
            SavingAccountDAO SavingAccountdao = new SavingAccountIMPL();
            CurrentAccount = SavingAccountdao.SearchByClient(client_code);
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return CurrentAccount;
    }

    public Boolean deleteAcc(String AccNum) {
        boolean CurrentAccount = false;
        try {
            SavingAccountDAO SavingAccountdao = new SavingAccountIMPL();
            CurrentAccount = SavingAccountdao.delete(AccNum);
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return CurrentAccount;
    }

    public String getOneAccountByOpNum(int opNum) {
        String CurrentAccount = null;
        try {
            SavingAccountDAO CurrentAccoundao = new SavingAccountIMPL();
            CurrentAccount = CurrentAccoundao.getOneAccountByOpNum(opNum);
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
//            e.printStackTrace();
        }
        return CurrentAccount;
    }

}
