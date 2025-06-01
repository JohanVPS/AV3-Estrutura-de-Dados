package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for reading and parsing CSV data.
 */
public class CSVReader {
    private String filePath;

    /**
     * Creates a new CSVReader for the specified file.
     * @param filePath The path to the CSV file.
     */
    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads the CSV file and parses it into Student objects.
     * @return A list of Student objects.
     * @throws IOException If an I/O error occurs.
     */
    public List<Student> readStudents() throws IOException {
        List<Student> students = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the header line
            String line = br.readLine();
            
            while ((line = br.readLine()) != null) {
                Student student = parseStudent(line);
                if (student != null) {
                    students.add(student);
                }
            }
        }
        
        return students;
    }
    
    /**
     * Parses a CSV line into a Student object.
     * @param line The CSV line to parse.
     * @return A Student object, or null if the line couldn't be parsed.
     */
    private Student parseStudent(String line) {
        try {
            String[] values = line.split(",");
            
            if (values.length < 16) {
                System.err.println("Invalid line: " + line);
                return null;
            }
            
            String studentId = values[0];
            int age = parseInt(values[1]);
            String gender = values[2];
            double studyHoursPerDay = parseDouble(values[3]);
            double socialMediaHours = parseDouble(values[4]);
            double netflixHours = parseDouble(values[5]);
            boolean partTimeJob = parseBoolean(values[6]);
            double attendancePercentage = parseDouble(values[7]);
            double sleepHours = parseDouble(values[8]);
            String dietQuality = values[9];
            int exerciseFrequency = parseInt(values[10]);
            String parentalEducationLevel = values[11];
            String internetQuality = values[12];
            int mentalHealthRating = parseInt(values[13]);
            boolean extracurricularParticipation = parseBoolean(values[14]);
            double examScore = parseDouble(values[15]);
            
            return new Student(
                    studentId, age, gender, studyHoursPerDay, socialMediaHours,
                    netflixHours, partTimeJob, attendancePercentage, sleepHours,
                    dietQuality, exerciseFrequency, parentalEducationLevel, internetQuality,
                    mentalHealthRating, extracurricularParticipation, examScore
            );
        } catch (Exception e) {
            System.err.println("Error parsing line: " + line);
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Parses a string into an integer, handling null or empty values.
     * @param value The string to parse.
     * @return The parsed integer, or 0 if the string is null or "null".
     */
    private int parseInt(String value) {
        if (value == null || value.trim().isEmpty() || value.trim().equalsIgnoreCase("null")) {
            return 0;
        }
        return Integer.parseInt(value.trim());
    }
    
    /**
     * Parses a string into a double, handling null or empty values.
     * @param value The string to parse.
     * @return The parsed double, or 0.0 if the string is null or "null".
     */
    private double parseDouble(String value) {
        if (value == null || value.trim().isEmpty() || value.trim().equalsIgnoreCase("null")) {
            return 0.0;
        }
        return Double.parseDouble(value.trim());
    }
    
    /**
     * Parses a string into a boolean, where "Yes" is true and "No" is false.
     * @param value The string to parse.
     * @return true if the string is "Yes", false otherwise.
     */
    private boolean parseBoolean(String value) {
        return "Yes".equalsIgnoreCase(value.trim());
    }
} 