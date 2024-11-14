package sg.edu.nus.iss.vttp_day11.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.vttp_day11.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

    List<Student> students;

    public StudentController() {
        students = new ArrayList<>();
    }

    @RequestMapping(path={"", "/allStudents"}, method=RequestMethod.GET)
    public List<Student> getStudentList() throws ParseException {

        // Convert a date string to epoch (long)
        String dob = "18 Dec 1975 10:25:00.000 SGT";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS zzz");
        Date dDob = sdf.parse(dob);
        Long epochDob = dDob.getTime();

        Student s1 = new Student(1, "Damien", "John", epochDob, "damienj@nus.edu.sg", "25 HMKT 123456");
        students.add(s1);
        Student s2 = new Student(2, "Ramien", "John", epochDob, "damienj@nus.edu.sg", "25 HMKT 123456");
        students.add(s2);
        Student s3 = new Student(3, "Lamien", "John", epochDob, "damienj@nus.edu.sg", "25 HMKT 123456");
        students.add(s3);

        return students;
    }
    
}
