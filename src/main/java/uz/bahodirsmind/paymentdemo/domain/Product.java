package uz.bahodirsmind.paymentdemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(generator = "categories_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "categories_id_gen", sequenceName = "seq_categories_id", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_product_category_id"))
    private Category category;

    @Column(name = "description", nullable = false, length = 20)
    private String description;

    @Column(name = "price", nullable = false, precision = 6, scale = 2)
    private BigDecimal price;

    @Column(name = "photo", nullable = false, length = 1048576)
    private String photo;

    public Product() {
    }

    public Product(String name, Category category, String description, BigDecimal price, String photo) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.photo = photo;
    }
}
