import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@SecondaryTable(name = "ADDRESS_TBL")
public class Supplier {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int id;
    private String companyName;
//    @Embedded
//    private Address address;
    @Column(table = "ADDRESS_TBL")
    private String city;
    @Column(table = "ADDRESS_TBL")
    private String street;
    @Column(table = "ADDRESS_TBL")
    private String postalcode;
    @Column(table = "ADDRESS_TBL")
    private String country;

    @OneToMany(mappedBy = "supplier")
    private Set<Product> products = new HashSet<>();

    public Supplier() {
    }

    public Supplier(String companyName, String street, String city) {
        this.companyName = companyName;
    }

    public void addProduct(Product product){
        products.add(product);
        product.setSupplier(this);
    }
}
