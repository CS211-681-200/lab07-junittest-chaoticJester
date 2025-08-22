package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    StudentHardCodeDatasource datasource;
    @BeforeEach
    void init() {
        datasource = new StudentHardCodeDatasource();
    }

    @Test
    @DisplayName("ทดสอบ method readData()")
    void testReadData() {
        StudentList testList = datasource.readData();
        assertEquals("First", testList.findStudentById("6710400001").getName());
        assertEquals("Second", testList.findStudentById("6710400002").getName());
        assertEquals("Third", testList.findStudentById("6710400003").getName());
        assertEquals("Fourth", testList.findStudentById("6710400004").getName());
        assertEquals(4, testList.getStudents().size());
    }

}