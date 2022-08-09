import java.util.Scanner;

public class ProductMenu {
    Scanner scanner;
    private ProductManager pm;
    public ProductMenu() {
        this.scanner = new Scanner(System.in);
        this.pm = new ProductManager();
    }
    private int menu(){
        System.out.println("Product Menu: ");
        System.out.println("1: Add Product");
        System.out.println("2: Show Product");
        System.out.println("3: Remove Product");
        System.out.println("4: Edit Product");
        System.out.println("0: Exit");
        return readInput(0, 4);
    }
    private int readInput(int min, int max) {
        int choice;
        while (true){
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max){
                    break;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return choice;
    }
    private void addProduct(){
        System.out.println("Enter Id Product: ");
        int id = readInput(0, Integer.MAX_VALUE);
        System.out.println("Enter Name Product: ");
        String name = scanner.nextLine();
        System.out.println("Enter Price");
        int price = readInput(0, Integer.MAX_VALUE);
        Product p = new Product(id, name, price);
        this.pm.addProduct(p);
    }
    private void showProduct(){
        System.out.println("List Product");
        for (int i = 0; i < this.pm.count(); i++) {
            Product p = this.pm.getProduct(i);
            System.out.println("ID: " + p.getId() + " " + "Name: " + p.getName() + " " + "Price: " + p.getPrice());
        }
    }
    private void removeProduct2(){
        System.out.println("Enter id Remove");
        int id = Integer.parseInt(scanner.nextLine());
        if (this.pm.removeProduct(id)){
            System.out.println("OK");
        } else {
            System.out.println("No OK");
        }

    }
    private void editProduc2(){
        System.out.println("enter id wan edit:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Name Product: ");
        String name = scanner.nextLine();
        System.out.println("Enter Price");
        int price = readInput(0, Integer.MAX_VALUE);
        Product p = new Product(id, name, price);
        this.pm.editProduct(id,p);

    }
    public void begin(){
        while (true){
            int choice = menu();
            switch (choice){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addProduct();
                    break;
                case 2:
                    showProduct();
                    break;
                case 3:
                    removeProduct2();
                    break;
                case 4:
                    editProduc2();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
