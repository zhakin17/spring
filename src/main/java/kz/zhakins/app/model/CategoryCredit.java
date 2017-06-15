package kz.zhakins.app.model;

import javax.persistence.*;

/**
 * Created by samatzhakin on 14.06.17.
 */
@Entity
@Table(name="categoryCredit")
public class CategoryCredit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private  String name;

    @Column(name = "price")
    private  String price;

    public CategoryCredit() {
    }

    public CategoryCredit(String name, String price) {
        this.name = name;
        this.price = price;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
