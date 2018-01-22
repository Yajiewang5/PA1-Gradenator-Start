import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * PA1Main.java, PA1-Gradenator assignment Name: Yajie Wang Section Leader:
 * Description: this assignment calculate the CS 210 grade, read file and print
 * out detail about your grade.
 */

public class PA1Main {
    public static void main(String[] args) {
    	// TODO: Write your program.
        try {
            Scanner scan = new Scanner(new File(args[0]));
            double myScore = 0;
            double myPercentage = 0;

            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                String[] parts = str.trim().split(",");
                String percentage = parts[1];
                String average = parts[2];

                // calculate the average score of different type of grade
                String[] sub = average.trim().split("\\s+");
                double totalScore = 0;
                double averageScore = 0;
                for (int i = 0; i < sub.length; i++) {
                    totalScore += Double.valueOf(sub[i]);
                }
                averageScore += totalScore / (double) sub.length;

                // find index of %
                int index = percentage.indexOf("%");
                String getPercentage = percentage.substring(0, index);
                double printPercent = Double.valueOf(getPercentage);

                // myScore represent the grade you earn this semester
                // myPercentage represent the whole grade.
                myScore += (averageScore * Double.valueOf(getPercentage)) / 100;
                myPercentage += Double.valueOf(getPercentage);
                System.out.println(
                        parts[0] + ", " + printPercent + "%, " + averageScore);
            }
            scan.close();
            System.out.println(
                    "TOTAL = " + myScore + " % out of " + myPercentage + " %");
        } catch (FileNotFoundException e) {
            System.out.println("File is not exist");
        }
    }
}

