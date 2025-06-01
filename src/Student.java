package src;

/**
 * Represents a student record from the dataset.
 */
public class Student implements Comparable<Student> {
    private String studentId;
    private int age;
    private String gender;
    private double studyHoursPerDay;
    private double socialMediaHours;
    private double netflixHours;
    private boolean partTimeJob;
    private double attendancePercentage;
    private double sleepHours;
    private String dietQuality;
    private int exerciseFrequency;
    private String parentalEducationLevel;
    private String internetQuality;
    private int mentalHealthRating;
    private boolean extracurricularParticipation;
    private double examScore;

    public Student(String studentId, int age, String gender, double studyHoursPerDay, double socialMediaHours,
                   double netflixHours, boolean partTimeJob, double attendancePercentage, double sleepHours,
                   String dietQuality, int exerciseFrequency, String parentalEducationLevel, String internetQuality,
                   int mentalHealthRating, boolean extracurricularParticipation, double examScore) {
        this.studentId = studentId;
        this.age = age;
        this.gender = gender;
        this.studyHoursPerDay = studyHoursPerDay;
        this.socialMediaHours = socialMediaHours;
        this.netflixHours = netflixHours;
        this.partTimeJob = partTimeJob;
        this.attendancePercentage = attendancePercentage;
        this.sleepHours = sleepHours;
        this.dietQuality = dietQuality;
        this.exerciseFrequency = exerciseFrequency;
        this.parentalEducationLevel = parentalEducationLevel;
        this.internetQuality = internetQuality;
        this.mentalHealthRating = mentalHealthRating;
        this.extracurricularParticipation = extracurricularParticipation;
        this.examScore = examScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getStudyHoursPerDay() {
        return studyHoursPerDay;
    }

    public double getSocialMediaHours() {
        return socialMediaHours;
    }

    public double getNetflixHours() {
        return netflixHours;
    }

    public boolean isPartTimeJob() {
        return partTimeJob;
    }

    public double getAttendancePercentage() {
        return attendancePercentage;
    }

    public double getSleepHours() {
        return sleepHours;
    }

    public String getDietQuality() {
        return dietQuality;
    }

    public int getExerciseFrequency() {
        return exerciseFrequency;
    }

    public String getParentalEducationLevel() {
        return parentalEducationLevel;
    }

    public String getInternetQuality() {
        return internetQuality;
    }

    public int getMentalHealthRating() {
        return mentalHealthRating;
    }

    public boolean isExtracurricularParticipation() {
        return extracurricularParticipation;
    }

    public double getExamScore() {
        return examScore;
    }

    @Override
    public int compareTo(Student other) {
        // Comparing students by their ID
        return this.studentId.compareTo(other.studentId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", age=" + age +
                ", examScore=" + examScore +
                '}';
    }
} 