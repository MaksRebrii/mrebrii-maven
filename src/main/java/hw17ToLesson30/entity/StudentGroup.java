package hw17ToLesson30.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student_groups")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor


public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer id;

    @Column(name = "group_code")
    private String code;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "studentGroup")
    private List<Student> studentsInGroup;

    @Override
    public String toString() {
        return "StudentGroup{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
