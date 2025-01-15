import java.util.Scanner;

public class Console {
    private final Controller controller;

    public Console(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        String userChoice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Hospital!");
        do {
            System.out.println("\nChoose");
            System.out.println("0. Exit");
            System.out.println("1. Read patient");
            System.out.println("2. Create patient");
            System.out.println("3. Update patient");
            System.out.println("4. Filter patients by diagnosis");
            System.out.println("5. Filter patients by medication");
            System.out.println("6. Sort medications of a patient");
            System.out.println("7. create medication");
            System.out.println("8. read medication");
            System.out.println("9. Delete medication");
            System.out.println("Please enter your choice: ");

            userChoice = scanner.nextLine();
            switch (userChoice) {
                case "0":
                    System.out.println("Exiting the program.");
                    break;
                case "1":
                    System.out.println("Enter patient ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Patient patient = controller.patientRepo.readById(id);
                    break;
                case "2":
                    System.out.println("Enter patient ID:");
                    int patientID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter patient name:");
                    String patientName = scanner.nextLine();
                    System.out.println("Enter patient age:");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter patient diagnosis:");
                    String patientDiagnosis = scanner.nextLine();
                    Patient newPatient = new Patient(patientID, patientName, patientAge, patientDiagnosis, null);
                    controller.patientRepo.create(newPatient);
                    System.out.println("Patient created: " + newPatient);
                    break;
                case "3":
                    // Implement update patient logic
                    break;
                case "4":
                    System.out.println("Enter diagnosis to filter by:");
                    String diagnosis = scanner.nextLine();
                    controller.filterPatientByDiagnosis(diagnosis);
                    break;
                case "5":
                    System.out.println("Enter medication to filter by:");
                    String medication = scanner.nextLine();
                    controller.filterPatientByMedication(medication);
                    break;
                case "6":
                    System.out.println("Enter patient name:");
                    String patient1 = scanner.nextLine();
                    System.out.println("Enter sort order (asc/desc):");
                    String order = scanner.nextLine();
                    controller.sortMedikamentofPatient(patient1, order);
                    break;

                case "7":
                    System.out.println("Enter medication name:");
                    String medName = scanner.nextLine();
                    System.out.println("Enter medication price:");
                    int medPrice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter spital:");
                    String spital = scanner.nextLine();
                    Medikamente medikament = new Medikamente(medName, medPrice, spital);
                    controller.medsRepo.create(medikament);
                    System.out.println("Medication created: " + medikament);
                case "8":
                    System.out.println("Give Id:");
                    int id1 = scanner.nextInt();
                    scanner.nextLine();
                    Medikamente medikament2 = controller.medsRepo.readById(id1);

                case "9":
                    System.out.println("Give Id:");
                    int id2 = scanner.nextInt();
                    scanner.nextLine();
                    controller.medsRepo.delete(id2);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!userChoice.equals("0"));
    }
}