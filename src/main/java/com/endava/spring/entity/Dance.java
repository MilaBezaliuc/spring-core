package com.endava.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "dance_mb")
public class Dance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "man_id")
    private Man man;

    @ManyToOne
    @JoinColumn(name = "woman_id")
    private Woman woman;

    private String style;

    public Dance(){}

    public Dance(Man man, Woman woman, String style) {
        this.man = man;
        this.woman = woman;
        this.style = style;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    public Woman getWoman() {
        return woman;
    }

    public void setWoman(Woman woman) {
        this.woman = woman;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dance dance = (Dance) o;

        if (man != null ? !man.equals(dance.man) : dance.man != null) return false;
        if (woman != null ? !woman.equals(dance.woman) : dance.woman != null) return false;
        return style != null ? style.equals(dance.style) : dance.style == null;

    }

    @Override
    public int hashCode() {
        int result = man != null ? man.hashCode() : 0;
        result = 31 * result + (woman != null ? woman.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dance{" +
                "man=" + man +
                ", woman=" + woman +
                ", style='" + style + '\'' +
                '}';
    }
}
