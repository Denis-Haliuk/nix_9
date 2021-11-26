package ua.alevel.service;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;
import ua.alevel.entity.Department;
import ua.alevel.entity.Employee;
import ua.alevel.service.impl.DepartmentServiceImpl;
import ua.alevel.service.impl.EmployeeServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeServiceTest {
    private final static DepartmentService departmentService = new DepartmentServiceImpl();
    private final static EmployeeService employeeService = new EmployeeServiceImpl();
    private final static int EMPLOYEES_SIZE = 10;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < 3; i++) {
            Department department = DepartmentGenerationUtil.generateDepartment(DepartmentGenerationUtil.NAME + i);
            departmentService.create(department);
        }

        for (int i = 0; i < EMPLOYEES_SIZE; ++i) {
            Employee employee = EmployeeGenerationUtil.generateEmployee(getRandomDepartment());
            employeeService.create(employee);
        }

        Assertions.assertEquals(10, employeeService.findAll().size());
    }

    @Order(1)
    @Test
    public void shouldBeCreateEmployeeWhenNameIsEmpty() {
        System.out.println("departmets:" + departmentService.findAll());
        System.out.println("employees:" + employeeService.findAll().size());
        Employee employee = EmployeeGenerationUtil.generateEmployee(getRandomDepartment(), null);
        employeeService.create(employee);
        System.out.println("employee = " + employee);
        verifyEmployeeListWhenEmployeeListIsNotEmpty(11);
    }

    @Order(2)
    @Test
    public void shouldBeDeleteEmployee() {
        String id = getRandomIdFromEmployeeList();
        employeeService.delete(id);
        verifyEmployeeListWhenEmployeeListIsNotEmpty(10);
    }

    @Order(3)
    @Test
    public void shouldBeFindEmployeeWhenIdIsRandom() {
        Employee employee = getRandomEmployeeFromEmployeeList(getRandomIdFromEmployeeList());
        Assertions.assertNotNull(employee);
    }

    @Order(4)
    @Test
    public void shouldBeUpdateEmployee() {
        Employee employee = getRandomEmployeeFromEmployeeList(getRandomIdFromEmployeeList());
        employee.setName("updated");
        employeeService.update(employee);
        Assertions.assertEquals("updated", employee.getName());
    }

    private Employee getRandomEmployeeFromEmployeeList(String randomIdFromEmployeeList) {
        return employeeService.findById(randomIdFromEmployeeList);
    }

    private Department getRandomDepartmentFromDepartmentList(String randomIdFromDepartmentList) {
        return departmentService.findById(randomIdFromDepartmentList);
    }

    private String getRandomIdFromEmployeeList() {
        return employeeService.findAll().stream().findFirst().get().getId();
    }

    private static Department getRandomDepartment() {
        Collection<Department> departments = departmentService.findAll();
        List<Department> departmentList = departments.stream().toList();
        Random random = new Random();
        return departmentList.get(random.nextInt(departmentList.size()));
    }

    private void verifyEmployeeListWhenEmployeeListIsNotEmpty(int size) {
        Collection<Employee> employees = employeeService.findAll();
        Assertions.assertTrue(CollectionUtils.isNotEmpty(employees));
        Assertions.assertEquals(size, employeeService.findAll().size());
    }
}
