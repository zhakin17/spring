package kz.zhakins.app.model;


import javax.persistence.*;

/**
 * Created by samatzhakin on 14.06.17.
 */
@Entity
@Table(name = "categoryProduct")
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private  String name;

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
}
