import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String args[]) {
            LinearEquationRunner.start();
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter coordinate 1: ");     //user input
            String coord1 = scan.nextLine();
            System.out.println("Enter coordinate 2: ");
            String coord2 = scan.nextLine();
            int x1 = Integer.parseInt(coord1.substring(coord1.indexOf("(") + 1, coord1.indexOf(",")));     //taking x and y values out of ( , ) and setting them to int
            int y1 = Integer.parseInt(coord1.substring(coord1.indexOf(",") + 2, coord1.indexOf(")")));
            int x2 = Integer.parseInt(coord2.substring(coord2.indexOf("(") + 1, coord2.indexOf(",")));
            int y2 = Integer.parseInt(coord2.substring(coord2.indexOf(",") + 2, coord2.indexOf(")")));
            if (x1 == x2) {     //checking if x1==x2 because the line will be vertical
                System.out.print("The points are on a vertical line: x=" + x1);
            } else {        //otherwise, run program normally
                LinearEquation set = new LinearEquation(x1, y1, x2, y2);
                System.out.println(set.lineInfo());
                System.out.println("\nEnter a value for x: ");
                double xy = scan.nextDouble();
                System.out.println("\nThe point on the line is " + set.coordinateForX(xy));
            }
        }
    //rubric says there is a start method, but nowhere else in the doc says to create one. This is here just in case this is needed.
    private static void start() {
        System.out.println("Welcome to the place for all your linear equation needs");
    }
}

