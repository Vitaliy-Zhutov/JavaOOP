package homework4;

import homework4.controller.StudentController;
import homework4.controller.TeacherController;
import homework4.repository.StudentRepository;
import homework4.repository.TeacherRepository;
import homework4.service.StudentService;
import homework4.service.TeacherService;
import homework4.view.SortType;
import homework4.view.StudentView;
import homework4.view.TeacherView;

public class Main {
    public static void main(String[] args) {
        StudentView studentView = getStudentView();
        TeacherView teacherView = getTeacherView();


        studentView.create("Ivan Morozov", 18, "02");
        studentView.create("Petr Vorobev", 19, "03");
        studentView.create("Petr Vorobev", 19, "03");
        studentView.create("Sidor Sidorov", 20, "112");
        studentView.create("Elena Ivanova", 19, "911");
        studentView.create("Anna Morozova", 17, "01");
        studentView.sendOnConsole(SortType.AGE);

        teacherView.create("Анна Иванова", 47, "11");
        teacherView.create("Марья Семенова", 32, "12");
        teacherView.create("Сергей Васильев", 29, "13");
        teacherView.create("Анна Иванова", 47, "11");
        teacherView.create("Игорь Петров", 40, "14");
        teacherView.create("Татьяна Сергеева", 33, "23");
        teacherView.sendOnConsole(SortType.ID);

        teacherView.edit("Анна Ивановнова", 47, "11");
        teacherView.sendOnConsole(SortType.ID);

        studentView.edit("Petr Vorobev", 19, "03");
        studentView.edit("Petr Vorobev", 19, "03");
        studentView.sendOnConsole(SortType.AGE);

    }

    private static StudentView getStudentView() {
        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);
        StudentController controller = new StudentController(service);
        return new StudentView(controller);
    }

    private static TeacherView getTeacherView() {
        TeacherRepository repository = new TeacherRepository();
        TeacherService service = new TeacherService(repository);
        TeacherController controller = new TeacherController(service);
        return new TeacherView(controller);
    }
}
