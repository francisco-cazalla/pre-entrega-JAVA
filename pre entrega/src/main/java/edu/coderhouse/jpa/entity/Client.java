package edu.coderhouse.jpa.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CLIENT")
public class Client {

 public Client() {}

 public Client(String name, String lastname, int dni) {
  this.name = name;
  this.lastname = lastname;
  this.dni = dni;
 }

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 @Column(name = "NAME")
 @Getter
 @Setter
 private String name;

 @Column(name = "LASTNAME")
 @Getter
 @Setter
 private String lastname;

 @Column(name = "DNI")
 @Getter
 @Setter
 private int dni;


}
