package uz.bahodirsmind.paymentdemo.domain;

import lombok.Getter;
import lombok.Setter;
import uz.bahodirsmind.paymentdemo.payload.dto.CategoryDTO;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(generator = "categories_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "categories_id_gen", sequenceName = "seq_categories_id", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false, length = 250)
    private String name;

    public CategoryDTO mapToDTO() {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(id);
        dto.setName(name);
        return dto;
    }

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
}
