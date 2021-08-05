package com.saw.apigrahql.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "VEHICLE")
public class Vehicle implements Serializable {

    @Id
    @Column(name="ID", nullable = false)
    private Long id;
    @Column(name = "Plate", nullable = false)
    private String plate;
    @Column(name = "Model", nullable = false)
    private String model;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "Client_ID", nullable = false,  foreignKey = @ForeignKey(name = "FK2_CLIENT_ID"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

    public Vehicle(Long id, String plate, String model, Client client){
        this.id = id;
        this.plate = plate;
        this.model = model;
        this.client = client;
    }
    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
