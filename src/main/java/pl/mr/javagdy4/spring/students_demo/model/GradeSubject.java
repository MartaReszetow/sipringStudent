package pl.mr.javagdy4.spring.students_demo.model;

public enum GradeSubject {
    ENGLISH("English"),
    POLISH("Polish"),
    COMPUTER_SCIENCE ("Computers and robots"),
    MATHEMATICS ("Math"),
    PE ("Wuef"),
    MUSIC_CLASS("Music");
    private final String commonName;
    GradeSubject(String commonName) {
        this.commonName = commonName;
    }
    public String getCommonName() {
        return commonName;
    }
}