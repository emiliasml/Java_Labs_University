package laborator4.ui.gui;

import laborator4.domain.Grade;
import laborator4.domain.Pupil;
import laborator4.domain.Subject;
import laborator4.service.ServiceGrades;
import laborator4.service.ServicePupils;
import laborator4.service.ServiceSubjects;
import laborator4.ui.Console;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ListExample {

    ListExample(ServicePupils servicePupils, ServiceSubjects serviceSubjects, ServiceGrades serviceGrades) {
        // Frame
        Frame f = new Frame("Catalog online");
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);

        // Buttons
        Button elevi = new Button("Elevi");
        Button materii = new Button("Materii");
        Button note = new Button("Note");
        Button eleviSortati = new Button("Elevi sortati dupa data nasterii");
        Button eleviOrdonatiDupaMedie = new Button("Elevi sortati dupa media generala");

        elevi.setBounds(100, 50, 50, 50);
        materii.setBounds(200, 50, 50, 50);
        note.setBounds(300, 50, 50, 50);
        eleviSortati.setBounds(100, 105, 200, 20);
        eleviOrdonatiDupaMedie.setBounds(100, 130, 200, 20);
        f.add(elevi);
        f.add(materii);
        f.add(note);
        f.add(eleviSortati);
        f.add(eleviOrdonatiDupaMedie);

        // Lists
        servicePupils.readFromFileService();
        serviceSubjects.readFromFileService();
        serviceGrades.readFromFileService();

        List lista = new List(100);
        lista.setBounds(100, 180, 250, 150);
        lista.setVisible(false);
        final TextField text = new TextField("");
        text.setBounds(100, 160, 250, 20);

        f.add(text);
        f.add(lista);

        elevi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lista.removeAll();
                text.setText(" Id      Nume      Prenume    Data nasterii");
                for (Pupil pupil : servicePupils.getAllPupils())
                    lista.add(pupil.toString());
                lista.setVisible(true);
            }
        });

        materii.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lista.removeAll();
                text.setText(" Id      Nume");
                for (Subject subject : serviceSubjects.getAllSubjects())
                    lista.add(subject.toString());
                lista.setVisible(true);
            }
        });

        note.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lista.removeAll();
                text.setText(" Id  IdMaterie  IdElev   Nota");
                for (Grade grade : serviceGrades.getAllGrades())
                    lista.add(grade.toString());
                lista.setVisible(true);
            }
        });


        eleviSortati.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);
                lista.removeAll();
                text.setText("Id   Nume  Prenume  Data nasterii");
                ArrayList<Pupil> pupils = Console.sortAge(servicePupils);
                for (Pupil pupil : pupils)
                    lista.add((pupil.toString()));
                lista.setVisible(true);
            }
        });

        eleviOrdonatiDupaMedie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);
                lista.removeAll();
                text.setText("Media  Id   Nume  Prenume  Data nasterii");
                ArrayList<Pupil> pupils = Console.sortPupilsByGrades(serviceGrades, servicePupils);
                for (Pupil pupil : pupils)
                    lista.add(df.format(serviceGrades.getGeneralGrade(pupil.getId())) + "     " + pupil.toString());
                lista.setVisible(true);
            }
        });
    }
}
