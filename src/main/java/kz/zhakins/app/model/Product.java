package kz.zhakins.app.model;

import javax.persistence.*;

/**
 * Created by samatzhakin on 14.06.17.
 */
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int Id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String Description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "id_categoryCredit")
    private CategoryCredit CategoryCredit;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_category_product")
    private CategoryProduct categoryProduct;
    private String decription;


    @Column(name = "image")
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    @Transient

    private String base64;

    public Product() {
    }

    public Product(String name, String description, kz.zhakins.app.model.CategoryCredit categoryCredit, CategoryProduct categoryProduct, String decription, byte[] image, String base64) {
        this.name = name;
        Description = description;
        CategoryCredit = categoryCredit;
        this.categoryProduct = categoryProduct;
        this.decription = decription;
        this.image = image;
        this.base64 = base64;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public kz.zhakins.app.model.CategoryCredit getCategoryCredit() {
        return CategoryCredit;
    }

    public void setCategoryCredit(kz.zhakins.app.model.CategoryCredit categoryCredit) {
        CategoryCredit = categoryCredit;
    }

    public CategoryProduct getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(CategoryProduct categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }
}
