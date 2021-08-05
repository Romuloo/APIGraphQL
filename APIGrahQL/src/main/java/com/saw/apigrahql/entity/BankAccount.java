package com.saw.apigrahql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BANK_ACCOUNT")
public class BankAccount implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "IBAN", nullable = false)
    private String iban;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="Client_ID", nullable=false, foreignKey = @ForeignKey(name = "FK1_CLIENT_ID"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;



    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                '}';
    }
}