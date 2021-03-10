package laborator4.domain;

import java.util.Objects;

public class Grade {

    private int id;
    private int idSubject;
    private int idPupil;
    private float value;

    public Grade() {
    }

    public Grade(int id, int idSubject, int idPupil, float value) {
        this.id = id;
        this.idSubject = idSubject;
        this.idPupil = idPupil;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getIdPupil() {
        return idPupil;
    }

    public void setIdPupil(int idPupil) {
        this.idPupil = idPupil;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grade)) return false;
        Grade grade = (Grade) o;
        return getId() == grade.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return id +
                ".  " + idSubject +
                "     " + idPupil +
                "     " + value;
    }
}
