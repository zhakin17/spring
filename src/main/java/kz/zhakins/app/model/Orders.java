package kz.zhakins.app.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by samatzhakin on 17.06.17.
 */
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int Id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_number")
    private int orderNumber;

    //private CategoryProduct categoryProduct;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_product")
    private Product product;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_delivery")
    private Date dateOfDelivery;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    @Column(name = "date_of_return")
    private Date dateOfReturn;

    @Column(name = "summa")
    private Long Summa;

    @Column(name = "comission")
    private Float comission;


    public Orders() {
    }

    public Orders(Customer customer, Product product, Date dateOfDelivery, Date dateOfReturn, Long summa, Float comission) {
        this.customer = customer;
        this.product = product;
        this.dateOfDelivery = dateOfDelivery;
        this.dateOfReturn = dateOfReturn;
        Summa = summa;
        this.comission = comission;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public Long getSumma() {
        return Summa;
    }

    public void setSumma(Long summa) {
        Summa = summa;
    }

    public Float getComission() {
        return comission;
    }

    public void setComission(Float comission) {
        this.comission = comission;
    }
}
