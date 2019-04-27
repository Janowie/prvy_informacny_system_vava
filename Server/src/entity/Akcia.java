package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "akcie")
public class Akcia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "akcia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UcastNaAkcii> ucastiNaAkcii;

    @Column(name = "nazov")
    private String nazov;

    @Column(name = "popis")
    private String popis;

    @OneToOne
    @JoinColumn(name = "id_zodpovednej_osoby")
    private Clen zodpovednaOsoba;


    public Akcia() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<UcastNaAkcii> getUcastiNaAkcii() {
        return ucastiNaAkcii;
    }

    public void setUcastiNaAkcii(List<UcastNaAkcii> ucastiNaAkcii) {
        this.ucastiNaAkcii = ucastiNaAkcii;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public Clen getZodpovednaOsoba() {
        return zodpovednaOsoba;
    }

    public void setZodpovednaOsoba(Clen zodpovednaOsoba) {
        this.zodpovednaOsoba = zodpovednaOsoba;
    }

    @Override
    public String toString() {
        return "Akcia{" +
                "id=" + id +
                ", ucastiNaAkcii=" + ucastiNaAkcii +
                ", nazov='" + nazov + '\'' +
                ", popis='" + popis + '\'' +
                ", zodpovednaOsoba=" + zodpovednaOsoba.getMeno() + " " + zodpovednaOsoba.getPriezvisko() +
                '}';
    }
}
