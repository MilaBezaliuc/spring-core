package com.endava.spring.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "woman_mb")
public class Woman implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "woman", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Dance> allWomansDances = new HashSet<Dance>();

    public Woman() {
    }

    public Woman(String name) {
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

    public Set<Dance> getAllWomansDances() {
        return allWomansDances;
    }

//    public void setAllPersonsDances(Set<Dance> allPersonsDances) {
//        this.allPersonsDances = allPersonsDances;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Woman woman = (Woman) o;

        if (id != woman.id) return false;
        return name != null ? name.equals(woman.name) : woman.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Woman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
