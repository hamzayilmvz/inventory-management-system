import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<Integer, Product> products = new HashMap<>();
    private ArrayList<Sale> sales=new ArrayList<>();
    private Map<Product, Integer> totalSoldMap=new HashMap<>();

    public void addProduct(Product product){
        if(!products.containsKey(product.getId())){
            products.put(product.getId(), product);
        }
    }

    public boolean sellProduct(int productId, int quantity){
        Product product=findProduct(productId);
        if(product==null){
            System.out.println("Product not found");
            return false;
        }
        if(product.getStatus()==ProductStatus.DISCONTINUED){
            System.out.println("Product is already discontinued");
            return false;
        }
        if(product.getStockQuantity()<quantity){
            System.out.println("Not enough stock");
            return false;
        }

        product.setStockQuantity(product.getStockQuantity()-quantity);

        if (product.getStockQuantity() == 0) {
            product.setStatus(ProductStatus.OUT_OF_STOCK);
        }

        sales.add(new Sale(product,quantity));
        System.out.println("Sale completed");
        return true;
    }

    public boolean restockProduct(int productId, int quantity){
        Product product=findProduct(productId);
        if(product==null){
            System.out.println("Product not found");
            return false;
        }
        if(product.getStatus()==ProductStatus.DISCONTINUED){
            System.out.println("Product is already discontinued product");
            return false;
        }
        product.setStockQuantity(product.getStockQuantity()+quantity);
        product.setStatus(ProductStatus.AVAILABLE);

        System.out.println("Product restocked");
        return true;
    }

    public boolean discontinueProduct(int productId) {
        Product product = findProduct(productId);
        if (product == null) {
            System.out.println("Product not found");
            return false;
        }
        product.setStatus(ProductStatus.DISCONTINUED);
        System.out.println("Product discontinued");
        return true;
    }

    public void listProducts(){
        if(products.isEmpty()){
            System.out.println("No products available");
            return;
        }
        for(Product product:products.values()){
            System.out.println(product);
        }
    }

    public void listSales(){
        if(sales.isEmpty()){
            System.out.println("No sales available");
            return;
        }
        for(Sale s:sales){
            System.out.println(s);
        }
    }

    private Product findProduct(int productId){
        return products.get(productId);
    }

    public void printSalesReport(){
            if (sales.isEmpty()) {
                System.out.println("No sales data available");
                return;
            }

        totalSoldMap.clear();

        for (Sale s : sales) {
            Product product = s.getProduct();
            int quantity = s.getQuantity();

            totalSoldMap.put(
                    product,
                    totalSoldMap.getOrDefault(product, 0) + quantity
            );
        }

        Product bestSeller = null;
        int maxSold = 0;

        for (Map.Entry<Product, Integer> entry : totalSoldMap.entrySet()) {
            if (entry.getValue() > maxSold) {
                maxSold = entry.getValue();
                bestSeller = entry.getKey();
            }
        }

        System.out.println("=== SALES REPORT ===");

        for (Map.Entry<Product, Integer> entry : totalSoldMap.entrySet()) {
            System.out.println(
                    "Product: " + entry.getKey().getName() +
                            " | Total Sold: " + entry.getValue()
            );
        }

        if (bestSeller != null) {
            System.out.println(
                    "BEST SELLER: " + bestSeller.getName() +
                            " (" + maxSold + " sold)"
            );
        }
    }
}
