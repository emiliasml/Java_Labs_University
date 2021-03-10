package laborator4.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Pupil {
    private int id;
    private String firstName, lastName;
    private Date birthDate;

    public Pupil() {
        this.firstName = null;
        this.lastName = null;
        this.birthDate = null;
    }

    public Pupil(int id, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void switchPupils(Pupil p) {
        Pupil aux = new Pupil(p.id,
                p.getFirstName(),
                p.getLastName(),
                p.getBirthDate());
        p.setId(this.id);
        p.setFirstName(this.firstName);
        p.setLastName(this.lastName);
        p.setBirthDate(this.birthDate);
        this.id = aux.getId();
        this.firstName = aux.getFirstName();
        this.lastName = aux.getLastName();
        this.birthDate = aux.getBirthDate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pupil)) return false;
        Pupil pupil = (Pupil) o;
        return getId() == pupil.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        String theDay = new SimpleDateFormat("dd/MM/yyyy").format(birthDate);
        return id + ". " +
                lastName + "   "
                + firstName + "   " + theDay;
    }
}