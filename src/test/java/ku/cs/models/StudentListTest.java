package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList studentList;
    @BeforeEach
    void init() {
        studentList = new StudentList();
    }

    @Test
    @DisplayName("ทดสอบ Constructor")
    void testConstructor(){
        studentList = new StudentList();
        assertEquals(0, studentList.getStudents().size());
    }

    @Test
    @DisplayName("เพิ่มนักเรียน 2 คนที่ไม่ซ้ำกันแต่เรียกใช้คนละ constructor และทดลองเพิ่มนักเรียน 2 คนที่ซ้ำกัน")
    void testAddStudent() {
        studentList.addNewStudent("6710xxx001", "Somchai");
        studentList.addNewStudent("6710xxx002", "Lakchat", 50);
        assertEquals("6710xxx001", studentList.getStudents().get(0).getId());
        assertEquals("Somchai", studentList.getStudents().get(0).getName());
        assertEquals("6710xxx002", studentList.getStudents().get(1).getId());
        assertEquals("Lakchat", studentList.getStudents().get(1).getName());
        assertEquals(50.0, studentList.getStudents().get(1).getScore());

        studentList.addNewStudent("6710xxx003", "Wuachok");
        studentList.addNewStudent("6710xxx003", "Wuachok");
        int count = 0;
        for(Student student : studentList.getStudents()){
            if(student.getName().equals("Wuachok")) {
                count++;
            }
        }
        assertEquals(1, count);
    }

    @Test
    @DisplayName("เพิ่มนักเรียน 3 คนแล้วค้นหานักเรียนด้วยรหัส")
    void testFindStudentById() {
        studentList.addNewStudent("6710xxx001", "Somchai");
        studentList.addNewStudent("6710xxx002", "Lakchat");
        studentList.addNewStudent("6710xxx003", "Wuachok");

        Student result = studentList.findStudentById("6710xxx001");
        assertEquals("Somchai", result.getName());
    }

    @Test
    @DisplayName("เพิ่มนักเรียน 3 ที่ชื่อคล้ายกัน 2 คนแล้วฟิลเตอร์ด้วยส่วนหนึ่งของชื่อ")
    void testFilterByName() {
        studentList.addNewStudent("6710xxx001", "Somchai");
        studentList.addNewStudent("6710xxx002", "Somchok");
        studentList.addNewStudent("6710xxx003", "Pensri");

        StudentList result = studentList.filterByName("Som");
        assertEquals(2, result.getStudents().size());
        assertEquals("Somchai", result.getStudents().get(0).getName());
        assertEquals("Somchok", result.getStudents().get(1).getName());
    }

    @Test
    @DisplayName("เพิ่มนักเรียนสามคนแล้วเพิ่มคะแนนให้คนที่ 2")
    void testGiveScoreToId() {
        studentList.addNewStudent("6710xxx001", "Somchai");
        studentList.addNewStudent("6710xxx002", "Lakchat");
        studentList.addNewStudent("6710xxx003", "Wuachok");

        assertEquals(0.0, studentList.findStudentById("6710xxx002").getScore());
        studentList.giveScoreToId("6710xxx002", 60.0);
        assertEquals(60.0, studentList.findStudentById("6710xxx002").getScore());

    }

    @Test
    @DisplayName("เพิ่มนักเรียนสามคนแล้วตรวจสอบเกรดของทั้งสามคน")
    void testViewGradeOfId() {
        studentList.addNewStudent("6710xxx001", "Somchai", 80);
        studentList.addNewStudent("6710xxx002", "Lakchat", 50);
        studentList.addNewStudent("6710xxx003", "Wuachok");
        assertEquals("A", studentList.viewGradeOfId("6710xxx001"));
        assertEquals("D", studentList.viewGradeOfId("6710xxx002"));
        assertEquals("F", studentList.viewGradeOfId("6710xxx003"));
    }
}