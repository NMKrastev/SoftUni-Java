package A4_HospitalDatabase;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.time.LocalDate;

@Entity
@Table(name = "visitations")
public class Visitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDate date;
    @Column(columnDefinition = "TEXT", length = 1000, nullable = false)
    private String comment;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Diagnose diagnose;
    @ManyToOne
    private Medicament medicament;

    public Visitation() {
    }

    public Visitation(LocalDate date, String comment, Patient patient, Diagnose diagnose, Medicament medicament) {
        this();
        this.date = date;
        this.comment = comment;
        this.patient = patient;
        this.medicament = medicament;
        this.diagnose = diagnose;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }
}
