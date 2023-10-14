import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface authentification {
    boolean verifyPersonalId (String empId , String[] Idlist) ;
    boolean verifyName(String name , String[] nameList) ;

}
class GlobalAuthentification implements authentification{



    @Override
    public boolean verifyPersonalId(String empId, String[] Idlist) {
        for(String id : Idlist){
            if (id.equals(empId)) {
                return true ;
            }
        }
        return false ;


    }

    @Override
    public boolean verifyName(String name , String[] nameList) {
        for(String name1 : nameList){
            if (name1.equals(name)) {
                return true ;
            }
        }
        return false ;




    }
}
class EngineerAuth implements authentification{

    @Override
    public boolean verifyPersonalId(String empId, String[] Idlist) {
        return false;
    }

    @Override
    public boolean verifyName(String name, String[] nameList) {
        return false;
    }
    public boolean verifyEngineer( String name , String password, HashMap<String,String> map ){
        for(Map.Entry<String , String> entry : map.entrySet()){
            String key = entry.getKey() ;
            String  value = entry.getValue() ;
            if((name == key ) && ( password == value)) {
                return true ;
            }



        }
        return false ;
    }

}
class Product {
    private int qte ;
    private String name ;
    private String Id ;
    public void setDetails(){
        Scanner input = new Scanner(System.in) ;
        System.out.println("Enter Product Name ");
        String name = input.next() ;
        this.name = name ;
        System.out.println("Enter Product ID ");
        String Id = input.next() ;
        this.Id = Id ;
        System.out.println("Enter Product Quantity ");
        int qte = input.nextInt() ;
        this.qte = qte ;

    }
    public void displayDetail(){
        System.out.println("Name : " + this.name);
        System.out.println("ID : " + this.Id);
        System.out.println("Quantity : " + this.qte);

    }
    public String getId(){return this.Id ; }
    public String getName(){return this.name ; }
    public boolean isExist(String productId , ArrayList<Product> productList){
        //Looping a list of product

        for(Product product : productList){
            if (product.getId().equals(productId)) {
                return true ;
            }
        }
        return false ;


    }

}
class Personnel extends Product{
    private String empId ;
    private String name ;
    private String service ;

    public Personnel(){
        this.name = "John" ;
        this.empId = "0000000" ;
        this.service = "maintenance" ;

    }
    public Personnel(String name , String empId , String service ){
        this.name = name ;
        this.empId = empId ;
        this.service = service ;


    }
    public void  setDetails(){
        Scanner input = new Scanner(System.in) ;
        System.out.println("Enter Your Name ");
        String name = input.next() ;
        this.name = name ;
        System.out.println("Enter Your Employee ID ");
        String empId = input.next() ;
        this.empId = empId ;
        System.out.println("Enter Your Service ");
        String service = input.next() ;
        this.service = service ;


    }

    public String getId() {
        return empId;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getService() {
        return service;
    }

    public void displayDetail(){
        System.out.println("Name : " + this.name);
        System.out.println("Employee ID : " + this.empId);
        System.out.println("Service : " + this.service);

    }
    public void checkProduct(ArrayList<Product> productList){
        Scanner input = new Scanner(System.in) ;
        System.out.println("Enter a product Id ");
        String productId = input.next() ;

        if (super.isExist(productId , productList)){
            System.out.println("Product Exist");
        }else{
            System.out.println("Product Not Exist");
        }

    }
    public void ReadDetails(){
        super.displayDetail();
    }



}
class Engineer extends  Personnel{
     private String Password ;
    @Override
    public void setDetails() {
        super.setDetails();
        Scanner input = new Scanner(System.in) ;
        System.out.println("Enter your Password ");
        String password =  input.next() ;

    }

    public String getPassword() {
        return Password;
    }

    @Override
    public String getName() {
        return super.getName();
    }
    public String getService(){
        return super.getService() ;

     }
     //TODO Create a Crud System for product (by engineer)
     //Update Product List using id index and (requires Search for Product )
    public void updateProduct(String product , Product newProduct , ArrayList<Product> productList){
        for (Product item : productList){
            if (item.getName() == product) {
                item = newProduct ;
                break ;
            }

        }





    }
    //Delete Specific Product From Table

    //Add Product
}
public class Main {
    public static void main(String[] args) {
    /*    int i = 0 ;

        ArrayList<Product> productList = new ArrayList<>();
        while (true) {
            productList.add(new Product()) ;
            productList.get(i).setDetails();
            productList.get(i).displayDetail();

            Scanner input = new Scanner(System.in) ;
            System.out.println("Want to continue  YES / No ");
            char result = input.next().charAt(0) ;
            char  finalChar = Character.toUpperCase(result) ;

            if(Character.compare(finalChar, 'N') == 0){
                break ;
            }
            else {
                i++ ;
            }



        }

*/
        Personnel employee = new Personnel() ;

        GlobalAuthentification Auth = new GlobalAuthentification() ;
        String[] Idlist = {"0000000" , "0000001" , "0000002" , "0000003" , "0000004" , "0000005" , "0000006" , "0000007" , "0000008" , "0000009" } ;
        String[] nameList = {"John" , "Doe" , "Jane" , "Doe" , "Jack" , "Doe" , "Jill" , "Doe" , "James" , "Doe" } ;

        //Test instance for authentification for personal


        HashMap<String , String > EngineerMap = new HashMap<>() ;
        EngineerMap.put("Ahmed" , "Azerty") ;
        EngineerMap.put("Youssef" , "4et2sq02ah") ;

        EngineerAuth AuthEng = new EngineerAuth() ;
        boolean result = AuthEng.verifyEngineer("Youssef" , "4et2sq02ah" , EngineerMap);
        System.out.println(result);










    }
}