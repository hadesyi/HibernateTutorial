package JPA_example;

import javax.persistence.*;
import java.io.Serializable;
import java.text.MessageFormat;

/**
 * Project: HibernateTutorial
 * FileName: Bee
 * Date: 2016-01-19
 * Time: 오전 10:58
 * Author: redfo
 * Note:
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Bee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bee_gen")
    @SequenceGenerator(name= "bee_gen",sequenceName = "bee_id_seq")
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn
    private Honey honey;

    public Bee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Honey getHoney() {
        return honey;
    }

    public void setHoney(Honey honey) {
        this.honey = honey;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}: id={1}, name={2}", new Object[]{
                getClass().getSimpleName(), id, name});
    }
}
