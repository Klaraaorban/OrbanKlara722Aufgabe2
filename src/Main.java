import java.util.List;
import java.util.Scanner;

/**
 * The Main class is the entry point of the application.
 */
public class Main {
    public static void main(String[] args) {
        Repo<Medikamente> medikamenteRepo = new Repo<>();
        Repo<Patient> patientRepo = new Repo<>();
        Controller controller=new Controller(medikamenteRepo, patientRepo);
        Scanner scanner = new Scanner(System.in);
        Medikamente medikament1 = new Medikamente("Aspirin", 10, "CLuj");
        Medikamente medikament2 = new Medikamente("Paracetamol", 5, "Brasov");

        Patient patient1 = new Patient(1,"John Doe", 12,"Headache", List.of(medikament1, medikament2));
        Patient patient2 = new Patient(2,"Jane Doe", 15,"Fever", List.of(medikament1));
        Patient patient3 = new Patient(3,"Alice", 20,"Headache", List.of(medikament2));

        medikamenteRepo.create(medikament1);
        medikamenteRepo.create(medikament2);

        patientRepo.create(patient1);
        patientRepo.create(patient2);
        patientRepo.create(patient3);

        Console consoleView = new Console(controller);
        consoleView.start();
        scanner.close();



//        System.out.println("All patients with a certain disease:");
//        controller.filterPatientByDiagnosis("Headache");
//        System.out.println("All patients who take a certain medication:");
//        controller.filterPatientByMedication("Aspirin");
//        System.out.println("All medications for a patient sorted by name:");
//        controller.sortMedikamentofPatient("John Doe", "asc");
    }
}