package hw16ToLesson27;

import java.time.Year;

public class StudentDTO {
    private String fio;
    private String group;
    private Year year;

    public StudentDTO() {
    }

    public StudentDTO(String fio, String group, Year year) {
        this.fio = fio;
        this.group = group;
        this.year = year;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "{fio='" + fio + '\'' +
                ", group='" + group + '\'' +
                ", year=" + year +
                '}';
    }
}
