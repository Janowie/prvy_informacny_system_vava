package entity;


import javax.persistence.*;

@Entity
@Table(name = "blah_pokusy")
public class blah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "meno")
    private String meno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public blah(String meno) {
        this.meno = meno;
    }
}
