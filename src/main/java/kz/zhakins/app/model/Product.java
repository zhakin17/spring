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
}
