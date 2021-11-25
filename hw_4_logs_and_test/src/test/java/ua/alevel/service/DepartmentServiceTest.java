package ua.alevel.service;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;
import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;
import ua.alevel.service.impl.DepartmentServiceImpl;
import ua.alevel.service.impl.EmployeeServiceImpl;

import java.util.Collection;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentServiceTest {

    private final static DepartmentService departmentService = new DepartmentServiceImpl();
    private final static EmployeeService employeeService = new EmployeeServiceImpl();
    private final static int DEPARTMENTS_SIZE = 10;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < DEPARTMENTS_SIZE; i++) {
            Department department = DepartmentGenerationUtil.generateDepartment(DepartmentGenerationUtil.NAME + i);
            departmentService.create(department);
        }
        Assertions.assertEquals(DEPARTMENTS_SIZE, departmentService.findAll().size());
    }

    @Order(1)
    @Test
    public void shouldBeCreateUserWhenNameIsEmpty() {
        Department department = new Department();
        department.setDepartmentName(null);
        departmentService.create(department);

        verifyDepartmentListWhenDepartmentListIsNotEmpty(11);
    }

    @Order(2)
    @Test
    public void shouldBeDeleteDepartment() {
        String id = getRandomIdFromDepartmentList();
        departmentService.delete(id);
        verifyDepartmentListWhenDepartmentListIsNotEmpty(10);
    }

    @Order(3)
    @Test
    public void shouldBeFindDepartmentWhenIdIsRandom() {
        Department department = getRandomDepartmentFromDepartmentList(getRandomIdFromDepartmentList());

        Assertions.assertNotNull(department);
    }

    private Department getRandomDepartmentFromDepartmentList(String randomIdFromDepartmentList) {
        return departmentService.findById(randomIdFromDepartmentList);
    }

    @Order(4)
    @Test
    public void shouldBeUpdateUser() {
        String id = getRandomIdFromDepartmentList();
        Department department = getRandomDepartmentFromDepartmentList(id);
        department.setDepartmentName("test");
        departmentService.update(department);

        department = departmentService.findById(id);

        Assertions.assertEquals("test", department.getDepartmentName());

    }

    @Order(5)
    @Test
    public void shouldBeFoundEmployeeByDepartmentId() {
        Department department = getRandomDepartmentFromDepartmentList(getRandomIdFromDepartmentList());
        System.out.println("department = " + department);
        Employee employee = new Employee();
        employee.setName("test");
        employee.setEmail("test");
        employee.setAge(123);
        employee.setDepartment(department);
        employeeService.create(employee);

        List<Employee> employeeList = departmentService.getEmployeesByDepartment(department.getId());
        Assertions.assertEquals(employeeList.get(0).getDepartment().getId(), department.getId());
    }

    private String getRandomIdFromDepartmentList() {
        return departmentService.findAll().stream().findFirst().get().getId();
    }

    private void verifyDepartmentListWhenDepartmentListIsNotEmpty(int size) {
        Collection<Department> departments = departmentService.findAll();

        Assertions.assertTrue(CollectionUtils.isNotEmpty(departments));
        Assertions.assertEquals(size, departmentService.findAll().size());
    }
}
