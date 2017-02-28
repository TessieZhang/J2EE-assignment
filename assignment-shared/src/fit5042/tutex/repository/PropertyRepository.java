package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Sale;
import fit5042.tutex.repository.entities.Users;
import fit5042.tutex.repository.entities.Car;
import fit5042.tutex.repository.entities.VINRecord;
import java.util.List;
import javax.ejb.Remote;

/**
 * @autor Zhaoying Zhang
 */
@Remote
public interface PropertyRepository {

    public void addCar(VINRecord car) throws Exception;
    
    public void addCar(Car car) throws Exception;

    public List<VINRecord> getAllCar() throws Exception;
    
    public List<Car> getSearchCar() throws Exception;
    
    public VINRecord searchById(String id) throws Exception;
    
    public Car searchByIdCar(int id) throws Exception;
    
    public List<Car> searchByMake(String make) throws Exception;
    
    public List<Car> searchByType(String type) throws Exception;
    
    public List<Car> searchByModel(String model) throws Exception;
    
    public Car searchByMM(String make,String model);
    
    public boolean validationVin(String vin);
    
    public void removeCar(String VIN) throws Exception;
    
    public void editCar(Car car) throws Exception;
    
    public void editVIN(VINRecord VIN) throws Exception;
    
    public List<Car> searchInfour(String q,String w,String e,int r);
    
    public List<Car> SearchByAllItems(String make1,String model1,String type1,int no);
    
    public Users searchCus(int Id,String lname,String fname,String mail);
    
    public void makeSale(String date,String carsInSale,Users customer, int salesmanId, String payStatus);
    
    public Users searchCus(String username);
    
    public List<Users> getAllSalesMan();
    
    public List<Users> getAllCus();
    
    public void removeCus(int tempid);
    
    public void updateCus1(Users temp);
    
    public Users searchCusId(int id);
    
    public List<Sale> getAllOrder();
    
    public Sale searchById(int id) throws Exception;
    
    public void updateOrder(Sale sale);
    
    public boolean validatePayStatus(int id);
     
    public List<Sale> searchByName(int id) throws Exception;
     
}
