package resourceTesting;

import java.util.Random;

public class RandomPhoneNumberGenerator {
    public static void main(String[] args) {
        String phoneNumber = generateRandomPhoneNumber();
        System.out.println("Random Phone Number: " + phoneNumber);
    }

    public static String generateRandomPhoneNumber() {
        Random rand = new Random();
        
        // Generate the first digit (7, 8, or 9)
        int firstDigit = rand.nextInt(3) + 7; // Generating numbers from 7 to 9
        
        // Generate the remaining 9 digits
        StringBuilder remainingDigits = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int digit = rand.nextInt(10); // Generating numbers from 0 to 9
            remainingDigits.append(digit);
        }
        
        // Combine the first digit and remaining digits to form the phone number
        String phoneNumber = firstDigit + remainingDigits.toString();
        
        return phoneNumber;
    }
}
