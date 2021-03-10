package laborator4.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import laborator4.domain.Pupil;

public class RepositoryPupils {
    private ArrayList<Pupil> pupils;

    public RepositoryPupils(ArrayList<Pupil> pupils) {
        this.pupils = pupils;
    }

    public RepositoryPupils() {
        this.pupils = new ArrayList<Pupil>();
    }

    public ArrayList<Pupil> getPupils() {
        return pupils;
    }

    public void setPupils(ArrayList<Pupil> pupils) {
        this.pupils = pupils;
    }

    public void addPupil(Pupil pupil) {
        this.pupils.add(pupil);
    }

    public Pupil pupilAtIndex(int index) {
        return pupils.get(index);
    }

    public boolean findPupil(int id) {
        for (Pupil p : this.pupils)
            if (p.getId() == id)
                return true;
        return false;
    }

    public Pupil getPupilById(int id) {
        for (Pupil pupil : this.pupils)
            if (pupil.getId() == id)
                return pupil;
        return new Pupil();
    }

    public boolean delete(int id) {
        if (getPupilById(id).getLastName() ==null)
            return false;
        else {
            this.pupils.remove(getPupilById(id));
            return true;
        }
    }

    public boolean upgrade(Pupil pupil) {
        for (Pupil p : this.pupils)
            if (p.equals(pupil)) {
                p.setBirthDate(pupil.getBirthDate());
                // p.setSubjects(p.getSubjects());
                return true;
            }
        return false;
    }

    public void readFromFile() {
        try {
            BufferedReader file =
                    new BufferedReader(
                            new FileReader(
                                    "C:\\Users\\emili\\IdeaProjects" +
                                            "\\MapLaboratoare\\src\\laborator4\\files\\pupils"));
            String line;
            while ((line = file.readLine()) != null) {
                String[] args = line.split(",");
                int id = Integer.parseInt(args[0]);
                String lastName = args[1];
                String firstName = args[2];
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(args[3]);
                Pupil pupil = new Pupil(id, firstName, lastName, date);
                if (!findPupil(id))
                    addPupil(pupil);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}
