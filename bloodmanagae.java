import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BloodManagementSystem {
    // Donor class to hold donor details
    static class Donor {
        private String name;
        private String bloodGroup;
        private String contactNumber;
        private int age;

        public Donor(String name, String bloodGroup, String contactNumber, int age) {
            this.name = name;
            this.bloodGroup = bloodGroup;
            this.contactNumber = contactNumber;
            this.age = age;
        }

        public String getName() { return name; }
        public String getBloodGroup() { return bloodGroup; }
        public String getContactNumber() { return contactNumber; }
        public int getAge() { return age; }

        @Override
        public String toString() {
            return "Donor: " + name + ", Blood Group: " + bloodGroup + ", Contact: " + contactNumber + ", Age: " + age;
        }
    }
  
    // Blood Bank class to manage list of donors
    static class BloodBank {
        private List<Donor> donors;

        public BloodBank() {
            donors = new ArrayList<>();
        }

        public void addDonor(Donor donor) {
            donors.add(donor);
            System.out.println("Donor added: " + donor.getName());
        }

        public void viewAllDonors() {
            if (donors.isEmpty()) {
                System.out.println("No donors available.");
            } else {
                for (Donor donor : donors) {
                    System.out.println(donor);
                }
            }
        }

        public Donor findDonorByBloodGroup(String bloodGroup) {
            for (Donor donor : donors) {
                if (donor.getBloodGroup().equalsIgnoreCase(bloodGroup)) {
                    return donor;
                }
            }
            return null;
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BloodBank bloodBank = new BloodBank();

        while (true) {
            System.out.println("\nBlood Management System");
            System.out.println("1. Add Donor");
            System.out.println("2. View All Donors");
            System.out.println("3. Request Blood");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Donor Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Blood Group: ");
                    String bloodGroup = scanner.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();

                    Donor donor = new Donor(name, bloodGroup, contact, age);
                    bloodBank.addDonor(donor);
                    break;

                case 2:
                    bloodBank.viewAllDonors();
                    break;

                case 3:
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter Required Blood Group: ");
                    String reqBloodGroup = scanner.nextLine();
                    System.out.print("Enter Quantity Required: ");
                    int quantity = scanner.nextInt();

                    Donor matchedDonor = bloodBank.findDonorByBloodGroup(reqBloodGroup);

                    if (matchedDonor != null) {
                        System.out.println("Match found: " + matchedDonor);
                        System.out.println("Blood request can be fulfilled.");
                    } else {
                        System.out.println("No donor available for requested blood group.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
