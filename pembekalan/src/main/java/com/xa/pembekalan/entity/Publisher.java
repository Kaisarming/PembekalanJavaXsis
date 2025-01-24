package com.xa.pembekalan.entity;

import java.util.List;

import groovy.transform.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "publishers")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Publisher extends BaseEntity {

    public Publisher(String name, String address) {
        // super();
        this.name = name;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String name;

    private String address;

    /*
     * Properti mappedBy digunakan untuk menunjukkan bahwa relasi ini dimiliki oleh
     * entitas lain. Dalam contoh ini, mappedBy = "publisher" berarti bahwa entitas
     * Book memiliki properti publisher yang mengelola relasi ini. Dengan kata lain,
     * properti publisher di entitas Book adalah pemilik relasi.
     * 
     * Properti cascade digunakan untuk menentukan operasi yang akan diterapkan
     * secara otomatis ke entitas terkait. CascadeType.REMOVE berarti bahwa ketika
     * entitas Publisher dihapus, semua entitas Book yang terkait juga akan dihapus
     * secara otomatis. Ini adalah cara untuk mengaktifkan ON DELETE CASCADE pada
     * level aplikasi.
     */
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.REMOVE)
    private List<Book> books;
}
