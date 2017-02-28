package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Car;
import fit5042.tutex.repository.entities.Sale;
import fit5042.tutex.repository.entities.Users;
import fit5042.tutex.repository.entities.VINRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Zhaoying Zhang
 */
@Stateless
public class JPAPropertyRepositoryImpl implements PropertyRepository {
    @PersistenceContext (unitName = "CarSaleSystemPU")
        
    private EntityManager entityManager;

    @Override
    public void addCar(VINRecord car) throws Exception { 
        entityManager.persist(car);
    }
    @Override
    public void addCar(Car car) throws Exception { 
        entityManager.persist(car);
    }

    @Override
    public VINRecord searchById(String id) throws Exception {
        VINRecord car = entityManager.find(VINRecord.class, id);
        return car;
    }
    
    @Override
    public Sale searchById(int id) throws Exception {
        Sale sale = entityManager.find(Sale.class, id);
        return sale;
    }
    
    @Override
    public Car searchByIdCar(int id) throws Exception {
        Car car = entityManager.find(Car.class, id);
        return car;
    }
    
     @Override
    public List<Car> searchByType(String type) throws Exception {
        List<Car> wantedCars = new ArrayList<>();
        List<Car> cars = entityManager.createNamedQuery(Car.GET_ALL_QUERY_NAME).getResultList();
        for(Car temp:cars)
        {
            if(temp.getCarType().equals(type))
                wantedCars.add(temp);
        }
        return wantedCars;
    }
    
    @Override
    public List<Sale> searchByName(int id) throws Exception { 
        List<Sale> wantedSale = new ArrayList<>();
        List<Sale> sales = entityManager.createNamedQuery(Sale.GET_ALL_QUERY_NAME).getResultList();
        for(Sale temp:sales)
        {
            if(temp.getSaleCusId().getId() == id)
                wantedSale.add(temp);
        }
        return wantedSale;
    }
    
     
    @Override
    public boolean validatePayStatus(int id){
        try {
            
            List<Sale> saleList;
            saleList = this.searchByName(id);
            for(Sale sale:saleList)
            {
            if(sale.getPayStatus().equals("pending"))
                return false;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(JPAPropertyRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
        
        
        
    }
    
    @Override
    public List<Car> searchByMake(String make) throws Exception { 
        
        List<Car> wantedCars = new ArrayList<>();
        
        List<Car> cars = entityManager.createNamedQuery(Car.GET_ALL_QUERY_NAME).getResultList();
        for(Car temp:cars)
        {
            if(temp.getManufacturer().equals(make))
                wantedCars.add(temp);
        }
        return wantedCars;
    }
    
    @Override
    public List<Car> searchByModel(String model) throws Exception {      
        
        List<Car> wantedCars = new ArrayList<>();
        List<Car> cars = entityManager.createNamedQuery(Car.GET_ALL_QUERY_NAME).getResultList();
        for(Car temp:cars)
        {
            if(temp.getModelName().equals(model))
                wantedCars.add(temp);
        }
        return wantedCars;
    }
    

    @Override
    public List<VINRecord> getAllCar() throws Exception {        
        return entityManager.createNamedQuery(VINRecord.GET_ALL_QUERY_NAME).getResultList();
    }
    
    @Override
    public List<Car> getSearchCar() throws Exception {        
        return entityManager.createNamedQuery(Car.GET_ALL_QUERY_NAME).getResultList();
    }
    
    
    @Override
    public Car searchByMM(String make,String model)
    {
        List<Car> cars = entityManager.createNamedQuery(Car.GET_ALL_QUERY_NAME).getResultList();
        for(Car temp:cars)
        {
            if(temp.getManufacturer().equals(make))
                if(temp.getModelName().equals(model))
                    return temp;
        }
        System.out.println("This car no found");
        return null;
    }
   

    @Override
    public void removeCar(String VIN) throws Exception {          
        VINRecord car = this.searchById(VIN);
      
        if (car != null) {
            entityManager.remove(car);
        }
    }

    @Override
    public void editCar(Car car) throws Exception {      
        entityManager.merge(car);
    }  
    
    @Override
    public void editVIN(VINRecord VIN) throws Exception {      
        entityManager.merge(VIN);
    } 
    
    
    @Override
    public List<Car> searchInfour(String q,String w,String e,int r) {
        List<Car> newOne = new ArrayList<>();
        List<Car> cars = entityManager.createNamedQuery(Car.GET_ALL_QUERY_NAME).getResultList();
        for(Car tc:cars)
        {
            if(tc.getManufacturer().equals(q.toUpperCase())||tc.getModelName().equals(w.toUpperCase())||tc.getCarType().equals(e.toUpperCase())||tc.getModelNo() == r)
                newOne.add(tc);
        }
        return newOne;
    }
    
    @Override
   public List<Car> SearchByAllItems(String make1,String model1,String type1,int no)
   {
       List<Car> newOne = new ArrayList<>();
       List<Car> newTwo = new ArrayList<>();
       List<Car> newThree = new ArrayList<>();
       List<Car> cars = entityManager.createNamedQuery(Car.GET_ALL_QUERY_NAME).getResultList();
       if(no != 0)
       {
           Car tempCar = entityManager.find(Car.class,no);
           newOne.add(tempCar);
           return newOne;
       }
       else
        {
            if(!make1.equals(""))
                {
                    for(Car tc:cars)
                    {
                        if(tc.getManufacturer().equals(make1.toUpperCase()))
                            newOne.add(tc);
                    }
                }
            if(!model1.equals(""))
                {
                    if(make1.equals(""))
                    {
                        for(Car tc:cars)
                        {
                            if(tc.getModelName().equals(model1.toUpperCase()))
                                newOne.add(tc);
                        }
                    }
                    else
                        for(Car tc:newOne)
                        {
                            if(tc.getModelName().equals(model1.toUpperCase()))
                                newTwo.add(tc);
                        }
                }
            if(type1 != null)
                {

                    if(make1.equals(""))
                    {
                        if(model1.equals(""))
                        {
                            for(Car tc:cars)
                            {
                                if(tc.getCarType().toUpperCase().equals(type1.toUpperCase()))
                                newOne.add(tc);
                            }
                            return newOne;
                        }
                        else
                        {
                            for(Car tc:newOne)
                                if(tc.getCarType().toUpperCase().equals(type1.toUpperCase()))
                                    newTwo.add(tc);
                            return newTwo;
                        }
                    }
                    else
                        if(model1.equals(""))
                        {
                            for(Car tc:newOne)
                            {
                                if(tc.getCarType().toUpperCase().equals(type1.toUpperCase()))
                                    newTwo.add(tc);
                                
                            }
                            return newTwo;
                        }
                        else
                        {
                            for(Car tc:newTwo)
                            {
                                if(tc.getCarType().toUpperCase().equals(type1.toUpperCase()))
                                    newThree.add(tc);
                             }
                            return newThree;
                        }
                }
            else
            {
                if(make1.equals(""))
                    if(model1.equals(""))
                        return null;
                    else
                        return newOne;
                else
                    if(model1.equals(""))
                        return newOne;
                    else
                        return newTwo;
            }
            }
        }

   @Override
    public Users searchCus(int Id,String lname,String fname,String mail)
    {
        Users tempCus = entityManager.find(Users.class, Id);
        if(tempCus.getLastName().toUpperCase().equals(lname.toUpperCase()))
            if(tempCus.getFirstName().toUpperCase().equals(fname.toUpperCase()))
                if(tempCus.getEmail().toUpperCase().equals(mail.toUpperCase()))
                      return tempCus;
                else
                    return null;
            else
                return null;
        else 
            return null;
    }
    
    @Override
    public boolean validationVin(String vin){
       if (vin.length() == 17){
           for (int i = 0; i < 17 ;i++){
               char item = vin.toUpperCase().charAt(i);
               if (item == 'O' || item == 'q' || item == 'I' )
                   return false;
           }
           return true;
       }else
           return false;
    }
    
    @Override
    public void makeSale(String date,String carsInSale,Users customer, int salesmanId, String payStatus)
    {
        List<Sale> saleList = entityManager.createNamedQuery(Sale.GET_ALL_QUERY_NAME).getResultList();
        int i = 0;
        i = saleList.size() + 1;
        Sale sale = new Sale(i,customer,date,carsInSale,salesmanId,payStatus);
        entityManager.persist(sale);
    }
    
    @Override
    public Users searchCus(String username)
    {
        List<Users> customerList = entityManager.createNamedQuery(Users.GET_ALL_QUERY_NAME).getResultList();
        for(Users temp:customerList)
        {
            if(temp.getUserName().equals(username))
                return temp;
        }
        return null;
                
    }
    
    @Override
    public Users searchCusId(int id)
    {
        List<Users> customerList = entityManager.createNamedQuery(Users.GET_ALL_QUERY_NAME).getResultList();
        for(Users temp:customerList)
        {
            if(temp.getId() == id)
                return temp;
        }
        return null;
    }
    
        @Override
    public List<Users> getAllSalesMan()
    {
        List<Users> tpList = entityManager.createNamedQuery(Users.GET_ALL_QUERY_NAME).getResultList();
        List<Users> want = new ArrayList<>();
        for(Users tcc:tpList)
        {
            if(tcc.getUserType().toUpperCase().equals("SALESMAN"))
                want.add(tcc);
        }
        return want;
    }
    
    @Override
    public List<Users> getAllCus()
    {
        List<Users> tpList = entityManager.createNamedQuery(Users.GET_ALL_QUERY_NAME).getResultList();
        List<Users> want = new ArrayList<>();
        for(Users tcc:tpList)
        {
            if(tcc.getUserType().toUpperCase().equals("CUSTOMER"))
                want.add(tcc);
        }
        return want;
    }
    
    @Override
    public List<Sale> getAllOrder()
    {
        List<Sale> saleList = entityManager.createNamedQuery(Sale.GET_ALL_QUERY_NAME).getResultList();
      
        return saleList;
    }
    
    @Override
    public void removeCus(int tempid)
    {
        List<Users> tpList = entityManager.createNamedQuery(Users.GET_ALL_QUERY_NAME).getResultList();
        List<Users> want = new ArrayList<>();
        for(Users tcc:tpList)
        {
            if(tcc.getId() == tempid)
            entityManager.remove(tcc);
        }
        
    }
    
    @Override
   public void updateCus1(Users temp)
    {
        entityManager.merge(temp);
    }

   @Override
   public void updateOrder(Sale sale)
    {
        entityManager.merge(sale);
    }
      
}
