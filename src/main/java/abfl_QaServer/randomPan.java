package abfl_QaServer;

import java.util.Random;

public class randomPan {
    public static void main(String[] args) {
        String panNumber = generateRandomPAN();
        System.out.println("Random PAN Number: " + panNumber);
    }

    public static String generateRandomPAN() {
        Random rand = new Random();

        // Generate five uppercase alphabets
        StringBuilder alphaBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            char randomChar = (char) (rand.nextInt(26) + 'A');
            alphaBuilder.append(randomChar);
        }

        // Generate four random digits
        int randomNumber = rand.nextInt(10000);
        String randomDigits = String.format("%04d", randomNumber);

        // Generate one uppercase alphabet
        char randomChar = (char) (rand.nextInt(26) + 'A');

        // Combine all parts to form the PAN number
        String panNumber = alphaBuilder.toString() + randomDigits + randomChar;

        return panNumber;
        
        
        
    }
}




//-------------------------------------------------------------------------

//
//package abfl_QaServer;
//
//import java.util.Random;
//
//public class randomPan {
//    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            String panNumber = generateRandomPAN();
//            System.out.println(panNumber);
//        }
//    }
//
//    public static String generateRandomPAN() {
//        Random rand = new Random();
//
//        // Generate five uppercase alphabets
//        StringBuilder alphaBuilder = new StringBuilder();
//        for (int i = 0; i < 5; i++) {
//            char randomChar = (char) (rand.nextInt(26) + 'A');
//            alphaBuilder.append(randomChar);
//        }
//
//        // Generate four random digits
//        int randomNumber = rand.nextInt(10000);
//        String randomDigits = String.format("%04d", randomNumber);
//
//        // Generate one uppercase alphabet
//        char randomChar = (char) (rand.nextInt(26) + 'A');
//
//        // Combine all parts to form the PAN number
//        String panNumber = alphaBuilder.toString() + randomDigits + randomChar;
//
//        return panNumber;
//    }
//}




