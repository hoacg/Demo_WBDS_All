import com.codegym.models.Student;
import com.codegym.repositories.StudentRepository;
import com.codegym.services.IStudentService;
import com.codegym.services.NewStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StudentServiceTest {

//    @InjectMocks
    private StudentRepository studentRepository = Mockito.mock(StudentRepository.class);

    private IStudentService studentService;

    final int MALE = 1;
    final int FEMALE = 2;
    final int OTHER = 3;

    @BeforeEach
    void prepare() {
        this.studentService = new NewStudentService(this.studentRepository);

        Student khai =  new Student(1L, "Khải", MALE, "khai@gmail.com", "", null, "");

        List<Student> studentList = Arrays.asList(
                khai,
                new Student(2L, "Tú", MALE, "khai@gmail.com", "", null, ""),
                new Student(3L, "Hoàng", MALE, "khai@gmail.com", "", null, ""),
                new Student(4L, "Dũng", MALE, "khai@gmail.com", "", null, ""),
                new Student(5L, "Hương", FEMALE, "khai@gmail.com", "", null, "")
        );

        Page<Student> studentPage = new PageImpl<>(studentList);

        Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "name"));
        // doReturn(studentPage).when(studentRepository).findAll(pageable);

        Mockito.when(studentRepository.findAll(pageable)).thenReturn(studentPage);
        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(khai));
    }

    @Test
    void test_getAllStudent_return_correctResult() {
        Page<Student> studentPage = this.studentService.getAllStudents("", 5, 0);

        // assert
        Assertions.assertNotNull(studentPage);
        Assertions.assertEquals(5, studentPage.getTotalElements());
    }

    @Test
    void get_getStudentById_return_correctResult() {
        Student student = this.studentService.getStudentById(1L);

        Assertions.assertEquals("Khải", student.getName());
        Assertions.assertEquals("khai@gmail.com", student.getEmail());
        Assertions.assertEquals(MALE, student.getGender());
    }
}
