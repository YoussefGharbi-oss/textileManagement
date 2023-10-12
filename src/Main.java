import java.util.ArrayList;
import java.util.Scanner;
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
    public boolean isExist(String productId , ArrayList<Product> productList){
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
public class Main {
    public static void main(String[] args) {
        int i = 0 ;

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
        Personnel employee = new Personnel() ;
        employee.setDetails();

        employee.checkProduct(productList);



    }
}