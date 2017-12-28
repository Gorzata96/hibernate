import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue (
            strategy = GenerationType.AUTO
    )
    private int id;
    private String productName;
    private Integer unitsOnStock;

    @ManyToOne
    private Supplier supplier;

    @OneToMany
    @JoinColumn(name = "TRANSACTIONS_FK")
    private List<TransactionP> productTransactions = new LinkedList<>();

    @ManyToOne
    private Category category;

    public Product(){
    }

    public Product(String productName, int unitsOnStock){
        this.productName = productName;
        this.unitsOnStock = unitsOnStock;
    }

    public Product(String productName, int unitsOnStock, Supplier supplier){
        this.productName = productName;
        this.unitsOnStock = unitsOnStock;
        this.supplier = supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
