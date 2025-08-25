import java.util.Scanner;

// Changes from Hexidecimal to Base 64
public class BaseChanger {

        public static void main(String[] args) {

            Scanner scnr = new Scanner(System.in);
            String input = scnr.next();
            scnr.close();

            int length = input.length();


            for(int i = 0; i < (2 - (length % 2)) % 2; i++) {
                input += "0";
            }

            System.out.println(input);
            String new4 = "";
            String new64 = "";

            // Converts to base 4
            for(int i = 0; i < length; i++) {
                int placeholder4;
                if(!Character.isDigit(input.charAt(i))) {
                    placeholder4 = ((int) input.charAt(i) - 87);
                } else {
                    placeholder4 = ((int) input.charAt(i) - 48);
                }
                new4 += Integer.toString(placeholder4 / 4) + Integer.toString(placeholder4 % 4);
            }

            switch(new4.length() % 3) {
                case 1: new4 += "00"; break;
                case 2: new4 += "0"; break;
            }


            // Converts to base 64
            for(int trio = 0; trio < new4.length() / 3; trio++) {
                int placeholder64 = 0;
                for(int j = 0; j < 3; j++) {
                    placeholder64 += (int) (new4.charAt(trio * 3 + j) - 48) * Math.pow(4, 2 - j);
                }

                if(placeholder64 <= 25) {
                    new64 += (char) (placeholder64 + 65);
                } else if (placeholder64 <= 51) {
                    new64 +=  (char) (placeholder64 + 71);
                } else if (placeholder64 <= 61) {
                    new64 += new64 + (char) (placeholder64 + 22);
                } else if (placeholder64 == 62) {
                    new64 += "+";
                } else {
                    new64 += "/";
                }
            }

            System.out.println(new64);


        }
}

