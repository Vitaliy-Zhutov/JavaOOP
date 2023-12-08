package homework5.service.init;

import homework5.controller.StudentClassController;
import homework5.controller.StudentController;
import homework5.controller.TeacherController;
import homework5.repository.StudentClassRepository;
import homework5.repository.StudentRepository;
import homework5.repository.TeacherRepository;
import homework5.service.randomizer.StudentClassGroupRandomizer;
import homework5.service.team.StudentClassService;
import homework5.service.user.StudentService;
import homework5.service.user.TeacherService;
import homework5.view.StudentClassView;
import homework5.view.StudentView;
import homework5.view.TeacherView;
import lombok.Data;
import lombok.Getter;

import java.io.IOException;

@Data
@Getter
public class Initializer {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final StudentClassRepository studentClassRepository;

    private final StudentService studentService;
    private final TeacherService teacherService;
    private final StudentClassService studentClassService;
    private final StudentClassGroupRandomizer studentClassGroupRandomizer;

    public final StudentView studentView;
    public final TeacherView teacherView;
    public final StudentClassView studentClassView;

    public Initializer() throws IOException {
        this.studentRepository = StudentRepository.getInstance();
        this.teacherRepository = TeacherRepository.getInstance();
        this.studentClassRepository = StudentClassRepository.getInstance();
        this.studentService = initStudentService();
        this.teacherService = initTeacherService();
        this.studentClassService = iniStudentClassService();
        this.studentView = initStudentView(studentService);
        this.teacherView = initTeacherView(teacherService);
        this.studentClassView = initStudentClassView(studentClassService);
        this.studentClassGroupRandomizer = new StudentClassGroupRandomizer(this.studentClassService);
    }

    private static StudentService initStudentService() throws IOException {
        return new StudentService();
    }

    private static TeacherService initTeacherService() throws IOException {
        return new TeacherService();
    }

    private static StudentClassService iniStudentClassService() {
        return new StudentClassService();
    }

    private static StudentView initStudentView(StudentService studentService) {
        StudentController studentController = new StudentController(studentService);
        return new StudentView(studentController);
    }

    private static TeacherView initTeacherView(TeacherService teacherService) {
        TeacherController teacherController = new TeacherController(teacherService);
        return new TeacherView(teacherController);
    }

    private static StudentClassView initStudentClassView(StudentClassService studentClassService) {
        StudentClassController studentClassController = new StudentClassController(studentClassService);
        return new StudentClassView(studentClassController);
    }
}
