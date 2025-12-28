import java.time.LocalDate;
import java.util.Objects;

public class Sale {
    private Product product;
    private int quantity;
    private LocalDate date;
    private int unitPrice;

    public Sale(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = product.getPrice();
        this.date = LocalDate.now();
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return quantity == sale.quantity && Objects.equals(product, sale.product) && Objects.equals(date, sale.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity, date);
    }

    public int getQuantity() {
        return quantity;
    }


    public LocalDate getDate() {
        return date;
    }


}
