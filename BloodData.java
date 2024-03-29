import java.util.Random;

// blooddata class representing blood type and rh factor
public class BloodData {
    // enum class to store blood group types
    public enum BloodGroup {
        O, A, B, AB
    }

    // fields to store blood type and rh factor
    private BloodGroup bloodType;
    private String rhFactor;

    // default constructor
    public BloodData() {
        // randomly assign a blood type
        Random random = new Random();
        BloodGroup[] bloodGroups = BloodGroup.values();
        this.bloodType = bloodGroups[random.nextInt(bloodGroups.length)];
        this.rhFactor = "+";
    }

    // overloaded constructor
    public BloodData(BloodGroup bloodType, String rhFactor) {
        // set blood type
        this.bloodType = bloodType;

        // set rh factor, throw exception if invalid
        if (rhFactor.equals("+") || rhFactor.equals("-")) {
            this.rhFactor = rhFactor;
        } else {
            throw new IllegalArgumentException("Invalid Rh factor. Must be '+' or '-'.");
        }
    }

    // getter for blood type
    public BloodGroup getBloodType() {
        return bloodType;
    }

    // setter for blood type
    public void setBloodType(BloodGroup bloodType) {
        this.bloodType = bloodType;
    }

    // getter for rh factor
    public String getRhFactor() {
        return rhFactor;
    }

    // setter for rh factor
    public void setRhFactor(String rhFactor) {
        // set rh factor, throw exception if invalid
        if (rhFactor.equals("+") || rhFactor.equals("-")) {
            this.rhFactor = rhFactor;
        } else {
            throw new IllegalArgumentException("invalid Rh factor. must be '+' or '-'.");
        }
    }
}