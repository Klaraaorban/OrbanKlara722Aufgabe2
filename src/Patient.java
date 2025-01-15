import java.util.List;

public class Patient {
    int id;
    String Name;
    int age;
    String Diagnosis;
    List<Medikamente> medikamentes;

    public Patient(int id, String name, int age, String diagnosis, List<Medikamente> medikamentes) {
        this.id = id;
        Name = name;
        this.age = age;
        Diagnosis = diagnosis;
        this.medikamentes = medikamentes;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", age=" + age +
                ", Diagnosis='" + Diagnosis + '\'' +
                ", medikamentes=" + medikamentes +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return Diagnosis;
    }

    public List<Medikamente> getMedikamentes() {
        return medikamentes;
    }
}
