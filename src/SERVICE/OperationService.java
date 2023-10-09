package SERVICE;

import DAO.OperationIMPL;
import DTO.CurrentAccount;
import DTO.Operation;
import DTO.SimpleOperation;
import INTERFACES.OperationDAO;

import java.sql.SQLException;
import java.util.Optional;

public class OperationService {
    public Optional<SimpleOperation> insertOperation(SimpleOperation operation) {
        Optional<SimpleOperation> Operationipml = Optional.empty();
        try {
            OperationDAO Operationdao = new OperationIMPL();
            Operationipml = Operationdao.insert(operation);
            Operationipml = Optional.of(Operationipml.get());
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return Operationipml;
    }
    public Optional<SimpleOperation> getOneOperation(int operationNum) {
        Optional<SimpleOperation> Operationipml = Optional.empty();
        try {
            OperationDAO Operationdao = new OperationIMPL();
            Operationipml = Operationdao.getOne(operationNum);
            Operationipml = Optional.of(Operationipml.get());
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return Operationipml;
    }

    public Boolean deleteOperation(int num) {
        boolean Operationipml = false;
        try {
            OperationDAO Operationdao = new OperationIMPL();
            Operationipml = Operationdao.delete(num);
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return Operationipml;
    }
}
