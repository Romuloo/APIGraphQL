package com.saw.apigrahql.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "DNI", nullable = false)
    private String dni;
    @Column(name = "Fname", nullable = false)
    private String fname;
    @Column(name = "Lname", nullable = false)
    private String lname;
    @OneToOne(mappedBy = "client")
    private BankAccount account;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Collection<Vehicle> vehicles;



    public Client(Long id, String dni, String fname, String lname) {
        this.id = id;
        this.dni = dni;
        this.fname = fname;
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }

}
