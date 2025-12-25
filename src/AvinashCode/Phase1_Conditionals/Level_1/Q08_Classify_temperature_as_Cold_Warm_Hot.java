package AvinashCode.Phase1_Conditionals.Level_1;

import java.util.Scanner;

public class Q08_Classify_temperature_as_Cold_Warm_Hot {

    // =========================================================================
    // QUESTION 8: Classify temperature as Cold/Warm/Hot
    // =========================================================================
    /*
     * LOGIC EXPLANATION:
     * - Define temperature ranges
     * - Use if-else-if ladder to check ranges
     *
     * Common ranges (in Celsius):
     * - Cold: < 15°C
     * - Warm: 15°C to 30°C
     * - Hot: > 30°C
     */


    public static void question8() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature (in Celsius): ");
        double temp = sc.nextDouble();

        if (temp < 15) {
            System.out.println("It's COLD! 🥶");
        } else if (temp <= 30) {
            System.out.println("It's WARM! 😊");
        } else {
            System.out.println("It's HOT! 🥵");
        }
    }

    public static void main(String[] args) {
        question8();
    }

}
