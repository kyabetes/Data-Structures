public class Patient {
    // fields to store patient data
    private final int idNumber;
    private final int age;
    private final BloodData bloodData;

    // default constructor
    public Patient() {
        this.idNumber = 0;
        this.age = 0;
        this.bloodData = new BloodData();
    }

    // overloaded constructor
    public Patient(int idNumber, int age, BloodData bloodData) {
        this.idNumber = idNumber;
        this.age = age;
        this.bloodData = bloodData;
    }

    // getter for id number
    public int getIdNumber() {
        return idNumber;
    }

    // getter for age
    public int getAge() {
        return age;
    }

    // getter for blood data
    public BloodData getBloodData() {
        return bloodData;
    }
}
