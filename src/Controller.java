import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class
 */
public class Controller {
    Repo<Medikamente> medsRepo = new Repo<>();
    static Repo<Patient> patientRepo = new Repo<>();

    public Controller(Repo<Medikamente> medsRepo, Repo<Patient> patientRepo) {
        this.medsRepo = medsRepo;
        this.patientRepo = patientRepo;
    }

    /**
     * Filters patients by diagnosis
     * @param diagnosis
     */
    public static void filterPatientByDiagnosis(String diagnosis) {
        List<Patient> patients = patientRepo.getAll().stream()
                .filter(patient -> patient.getDiagnosis().equals(diagnosis))
                .collect(Collectors.toList());
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    /**
     * Filters patients by medication
     * @param medication
     */
    public static void filterPatientByMedication(String medication) {
        List<Patient> patients = patientRepo.getAll().stream()
                .filter(patient -> patient.getMedikamentes()!=null && patient.getMedikamentes().stream()
                        .anyMatch(med -> med.getName().equalsIgnoreCase(medication)))
                .collect(Collectors.toList());
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    /**
     * Sorts medications of a patient
     * @param patient
     * @param order
     */
    public static void sortMedikamentofPatient(String patient, String order){
        Patient patient1 = patientRepo.getAll().stream()
                .filter(p -> p.getName().equalsIgnoreCase(patient))
                .findFirst()
                .orElse(null);
        if (patient1 == null) {
            System.out.println("Patient not found");
        } else {
            List<Medikamente> meds = patient1.getMedikamentes();
            if (meds.isEmpty()) {
                System.out.println("No medications found for patient " + patient);
            } else {
                System.out.println("Medications for patient " + patient + ":");
                meds.forEach(System.out::println);
                if (order.equalsIgnoreCase("asc")) {
                    meds.sort((m1, m2) -> m1.getName().compareTo(m2.getName()));
                } else if (order.equalsIgnoreCase("desc")) {
                    meds.sort((m1, m2) -> m2.getName().compareTo(m1.getName()));
                }
                System.out.println("\nMedications sorted by name:");
                meds.forEach(System.out::println);
            }
        }
    }
}
