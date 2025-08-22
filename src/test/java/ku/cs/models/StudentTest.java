package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student;
    @BeforeEach
    void init(){
        student = new Student("6710111222", "test-san");
    }

    @Test
    @DisplayName("ทดสอบ Constructor")
    void testConstructor(){
        Student student1 = new Student("6710345678", "test-kun", 20.0);
        assertEquals("test-san", student.getName());
        assertEquals("6710111222", student.getId());
        assertEquals(0.0, student.getScore());
        assertEquals("test-kun", student1.getName());
        assertEquals("6710345678", student1.getId());
        assertEquals(20.0, student1.getScore());

    }

    @Test
    @DisplayName("เปลี่ยนชื่อเป็น test-chan")
    void testChangeName() {
        student.changeName("test-chan");
        assertEquals("test-chan", student.getName());
    }

    @Test
    @DisplayName("เพิ่มคะแนนนิสิต 40 และ 20 คะแนน")
    void testAddScore() {
        student.addScore(40);
        assertEquals(40, student.getScore());
        student.addScore(20);
        assertEquals(60, student.getScore());
    }

    @Test
    @DisplayName("เพิ่มคะแนนนิสิต 30 คะแนนและคำนวนเกรด")
    void testCalculateGrade() {
        student.addScore(30);
        assertEquals("F", student.getGrade());
    }

    @Test
    @DisplayName("ตรวจสอบว่า test-san มีไอดีคือ 6710111222 หรือไม่ และมีไอดีคือ 6710450988 หรือไม่")
    void testIsId() {
        assertEquals(true, student.isId("6710111222"));
        assertEquals(false, student.isId("6710450988"));
    }

    @Test
    @DisplayName("ตรวจสอบว่า name ของ student มี sub-string 'chan' อยุ่หรือไม่ และมี 'san' อยู่หรือไม่")
    void testIsNameContains() {
        assertEquals(false, student.isNameContains("chan"));
        assertEquals(true, student.isNameContains("san"));
    }

}