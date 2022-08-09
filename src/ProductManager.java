import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> listOfProduct;
    public ProductManager() {
        this.listOfProduct = new ArrayList<>();
    }
    public int addProduct(Product p){
        this.listOfProduct.add(p);
        return this.listOfProduct.size();
    }
    public int count(){
        return this.listOfProduct.size();
    }
    public Product getProduct(int index){
        if (index < 0 || index > this.count()){
            return null;
        } return this.listOfProduct.get(index);
    }
    public boolean removeProduct(int id){
        int index = -1;
        for (int i = 0; i < count(); i++) {
            if (this.listOfProduct.get(i).getId() == id){
                index = i;
                break;
            }
        }
        if (index != -1){
            this.listOfProduct.remove(index);
                return true;
            }
        return false;
    }
    public boolean editProduct(int id,Product p ){
        int index = -1;
        for (int i = 0; i < count(); i++) {
            if (this.listOfProduct.get(i).getId() == id){
                index = i;
                break;
            }
        }
        if (index != -1){
            this.listOfProduct.set(index,p);
            return true;
        }
        return false;
    }

}
