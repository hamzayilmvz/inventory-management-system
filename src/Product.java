import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int price;
    private int stockQuantity;
    ProductStatus status;

    public Product(int id, String name, int price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        if(stockQuantity <= 0){
            this.stockQuantity = 0;
            this.status=ProductStatus.OUT_OF_STOCK;
        }
        else {
            this.stockQuantity = stockQuantity;
            this.status=ProductStatus.AVAILABLE;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", status=" + status +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
        if (stockQuantity <= 0) {
            this.status = ProductStatus.OUT_OF_STOCK;
        } else if (this.status != ProductStatus.DISCONTINUED) {
            this.status = ProductStatus.AVAILABLE;
        }
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
}
