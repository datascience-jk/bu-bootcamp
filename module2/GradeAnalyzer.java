import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
    
    static int skippedCount = 0;
    static int countA = 0;
    static int countB = 0;
    static int countC = 0;
    static int countD = 0;
    static int countF = 0;
    public static void main(String[] args) {
        // Step 1: read scores from file
        String filename = "scores.txt";
        ArrayList<Integer> scores = readScores(filename);
        if (scores.isEmpty()) {
            System.out.println("No valid scores found in file.");
            return;
        }
        // System.out.println(scores);


        // Step 2: calculate statistics
        // System.out.println(calculateAverage(scores));
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++; 
            } else {
                countF++;
            }
        }

        double avg = calculateAverage(scores);
        
        // Step 3: write and print report
        writeReport(scores, avg, highest, lowest, "report.txt");
        


    } 
    
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        // your code here
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            
            String line;
            
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                try {
                    scores.add(Integer.parseInt(line));
                } catch(NumberFormatException e) {
                    System.out.println("Skipping invalid score: " + line);
                    skippedCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if (scores.isEmpty()) {
            return 0.0;
        }

        else {
            double sum = 0;
            for (int score : scores)
                sum += score;
            return sum / scores.size();
        }
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        // your code here
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
        writer.write(String.format("=== Grade Analysis Report ===%n"));
        
        writer.write(String.format("Valid Scores Processed: %d%n", scores.size()));
        writer.write(String.format("Total Scores Skipped: %d%n", skippedCount));
        writer.write(String.format("%n"));
        
        writer.write(String.format("Average score: %.2f%n", avg));
        writer.write(String.format("Highest score: %d%n", high));
        writer.write(String.format("Lowest score: %d%n", low));
        writer.write(String.format("%n"));

        writer.write(String.format("Grade Distribution%n"));
        writer.write(String.format("A (90-100): %d%n", countA));
        writer.write(String.format("B (80-89): %d%n", countB));
        writer.write(String.format("C (70-79): %d%n", countC));
        writer.write(String.format("D (60-69): %d%n", countD));
        writer.write(String.format("F (0-59): %d%n", countF));



        } catch (IOException e) {
            System.out.println("Cound not write file: " + e.getMessage());
        }
        System.out.println("=== Grade Analysis Report ===");
        System.out.println(String.format("Valid Scores Processed: %d", scores.size()));
        System.out.println(String.format("Total Scores Skipped: %d", skippedCount));
        System.out.println();

        System.out.println(String.format("Average score: %.2f", avg));
        System.out.println(String.format("Highest score: %d", high));
        System.out.println(String.format("Lowest score: %d", low));
        System.out.println();

        System.out.println("Grade Distribution");
        System.out.println(String.format("A (90-100): %d", countA));
        System.out.println(String.format("B (80-89): %d", countB));
        System.out.println(String.format("C (70-79): %d", countC));
        System.out.println(String.format("D (60-69): %d", countD));
        System.out.println(String.format("F (0-59): %d", countF));
    }
} 