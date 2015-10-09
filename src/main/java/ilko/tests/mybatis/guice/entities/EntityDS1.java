package ilko.tests.mybatis.guice.entities;

import java.io.Serializable;

/**
 * Created by ILIEVI on 09.10.2015.
 */
public class EntityDS1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String firstname;

    private String lastname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityDS1 entityDS1 = (EntityDS1) o;

        return id.equals(entityDS1.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "EntityDS1{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
