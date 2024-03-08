package abfl_QaServer;

import java.util.Random;

public class randomEmail {
    public static void main(String[] args) {
        String email = generateRandomEmail();
        System.out.println("Random Email ID: " + email);
    }

    public static String generateRandomEmail() {
        Random rand = new Random();

        // Generate first 5 alphabets
        StringBuilder alphaBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            char randomChar = (char) (rand.nextInt(26) + 'a');
            alphaBuilder.append(randomChar);
        }

        // Generate 2 alphabets after the dot
        StringBuilder dotBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            char randomChar = (char) (rand.nextInt(26) + 'a');
            dotBuilder.append(randomChar);
        }

        // Generate 5 random numbers
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int randomDigit = rand.nextInt(10);
            numberBuilder.append(randomDigit);
        }

        // Combine the parts to form the email ID
        String email = alphaBuilder.toString() + "." + dotBuilder.toString() + "+"
                + numberBuilder.toString() + "@testing.cred";

        return email;
    }
}

