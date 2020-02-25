import java.util.Scanner;

public class Drivers {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        System.out.print("Enter a number to select browser\n");
        System.out.println("Enter 1 for Chrome and 2 for Firefox");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        if (osName.equalsIgnoreCase("Mac OS X")) {
            switch (a) {
                case 1:
                    Chrome.run();
                    break;
                case 2:
                    Firefox.run();
                    break;
                default:
                    Safari.run();
            }
        } else {
            switch (a) {
                case 1:
                    Chrome.Winrun();
                    break;
                case 2:
                    Firefox.Winrun();
                    break;
                default:
                    Chrome.run();
            }
        }
    }
}