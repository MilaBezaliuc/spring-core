package com.endava.spring.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "man_mb")
public class Man implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "man", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Dance> allPersonsDances = new HashSet<Dance>();

    public Man() {
    }

    public Man(String name) {
        this.name = name;
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

    public Set<Dance> getAllPersonsDances() {
        return allPersonsDances;
    }

    public void setAllPersonsDances(Set<Dance> allPersonsDances) {
        this.allPersonsDances = allPersonsDances;
    }

    @Override
    public String toString() {
        return "Man{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
