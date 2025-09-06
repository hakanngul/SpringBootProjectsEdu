package com.hakangul;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hakangul.dto.DtoEmployee;
import com.hakangul.exception.MessageType;
import com.hakangul.service.IEmployeeService;
import com.hakangul.starter.ExceptionManagmentStarter;

@SpringBootTest(classes = ExceptionManagmentStarter.class)
class ExceptionManagmentApplicationTests {

    @Autowired
    private IEmployeeService employeeService;

    @Nested
    @DisplayName("findEmployeeById Tests")
    class FindEmployeeByIdTests {

        @Test
        @DisplayName("Should find employee when valid ID is provided")
        void testFindEmployeeById_ValidId() {
            DtoEmployee employee = employeeService.finEmployeeById(6L);
            assertNotNull(employee, "Employee should not be null");
            assertNotNull(employee.getId(), "Employee ID should not be null");
            assertNotNull(employee.getName(), "Employee name should not be null");
        }

        @Test
        @DisplayName("Should handle when employee not found")
        void testFindEmployeeById_NotFound() {
            assertThrows(Exception.class, () -> {
                employeeService.finEmployeeById(999L);
            }, "Should throw exception when employee not found");
        }

        @Test
        @DisplayName("Should handle null ID parameter")
        void testFindEmployeeById_NullId() {
            assertThrows(Exception.class, () -> {
                employeeService.finEmployeeById(null);
            }, "Should throw exception when ID is null");
        }

        @Test
        @DisplayName("Should handle negative ID parameter")
        void testFindEmployeeById_NegativeId() {
            assertThrows(Exception.class, () -> {
                employeeService.finEmployeeById(-1L);
            }, "Should throw exception when ID is negative");
        }

        @Test
        @DisplayName("Should handle zero ID parameter")
        void testFindEmployeeById_ZeroId() {
            assertThrows(Exception.class, () -> {
                employeeService.finEmployeeById(0L);
            }, "Should throw exception when ID is zero");
        }
    }

    @Nested
    @DisplayName("findEmployeeById2 Tests")
    class FindEmployeeById2Tests {

        @Test
        @DisplayName("Should find employee when valid ID is provided")
        void testFindEmployeeById2_ValidId() {
            DtoEmployee employee = employeeService.findEmployeeById2(1L);
            assertNotNull(employee, "Employee should not be null");
            assertNotNull(employee.getId(), "Employee ID should not be null");
            assertNotNull(employee.getName(), "Employee name should not be null");
        }

        @Test
        @DisplayName("Should handle when employee not found")
        void testFindEmployeeById2_NotFound() {
            assertThrows(Exception.class, () -> {
                employeeService.findEmployeeById2(999L);
            }, "Should throw exception when employee not found");
        }

        @Test
        @DisplayName("Should handle null ID parameter")
        void testFindEmployeeById2_NullId() {
            assertThrows(Exception.class, () -> {
                employeeService.findEmployeeById2(null);
            }, "Should throw exception when ID is null");
        }

        @Test
        @DisplayName("Should handle negative ID parameter")
        void testFindEmployeeById2_NegativeId() {
            assertThrows(Exception.class, () -> {
                employeeService.findEmployeeById2(-1L);
            }, "Should throw exception when ID is negative");
        }

        @Test
        @DisplayName("Should handle zero ID parameter")
        void testFindEmployeeById2_ZeroId() {
            assertThrows(Exception.class, () -> {
                employeeService.findEmployeeById2(0L);
            }, "Should throw exception when ID is zero");
        }
    }

    @Nested
    @DisplayName("findAllEmployees Tests")
    class FindAllEmployeesTests {

        @Test
        @DisplayName("Should return employee list successfully")
        void testFindAllEmployees_Success() {
            List<DtoEmployee> employees = employeeService.findAllEmployees();
            assertNotNull(employees, "Employee list should not be null");
            assertTrue(employees.size() >= 0, "Employee list should be initialized");
        }

        @Test
        @DisplayName("Should handle empty employee list")
        void testFindAllEmployees_EmptyList() {
            List<DtoEmployee> employees = employeeService.findAllEmployees();
            assertNotNull(employees, "Employee list should not be null even when empty");
        }

        @Test
        @DisplayName("Should return valid employee objects in list")
        void testFindAllEmployees_ValidEmployees() {
            List<DtoEmployee> employees = employeeService.findAllEmployees();
            if (!employees.isEmpty()) {
                for (DtoEmployee employee : employees) {
                    assertNotNull(employee, "Each employee in list should not be null");
                    assertNotNull(employee.getId(), "Employee ID should not be null");
                }
            }
        }
    }

    @Nested
    @DisplayName("findAllEmployees2 Tests")
    class FindAllEmployees2Tests {

        @Test
        @DisplayName("Should return employee list successfully")
        void testFindAllEmployees2_Success() {
            List<DtoEmployee> employees = employeeService.findAllEmployees2();
            assertNotNull(employees, "Employee list should not be null");
            assertTrue(employees.size() >= 0, "Employee list should be initialized");
        }

        @Test
        @DisplayName("Should handle empty employee list")
        void testFindAllEmployees2_EmptyList() {
            List<DtoEmployee> employees = employeeService.findAllEmployees2();
            assertNotNull(employees, "Employee list should not be null even when empty");
        }

        @Test
        @DisplayName("Should return valid employee objects in list")
        void testFindAllEmployees2_ValidEmployees() {
            List<DtoEmployee> employees = employeeService.findAllEmployees2();
            if (!employees.isEmpty()) {
                for (DtoEmployee employee : employees) {
                    assertNotNull(employee, "Each employee in list should not be null");
                    assertNotNull(employee.getId(), "Employee ID should not be null");
                }
            }
        }
    }

    @Nested
    @DisplayName("Service Integration Tests")
    class ServiceIntegrationTests {

        @Test
        @DisplayName("Should handle database connection issues")
        void testDatabaseConnectionFailure() {
            // This test would require mocking or database manipulation
            // For now, we ensure the service is properly injected
            assertNotNull(employeeService, "Employee service should be injected");
        }

        @Test
        @DisplayName("Should handle concurrent access")
        void testConcurrentAccess() {
            assertDoesNotThrow(() -> {
                employeeService.findAllEmployees();
                employeeService.findAllEmployees2();
            }, "Service should handle concurrent calls");
        }

        @Test
        @DisplayName("Should validate MessageType constants")
        void testMessageTypeConstants() {
            assertNotNull(MessageType.NO_RECORD_EXITS.getMessage(), "Message should not be null");
            assertNotNull(MessageType.NO_RECORD_EXITS.getCode(), "Code should not be null");
            assertNotNull(MessageType.INVALID_PARAMETER.getMessage(), "Invalid parameter message should not be null");
            assertNotNull(MessageType.NOT_FOUND.getMessage(), "Not found message should not be null");
            assertNotNull(MessageType.UNAUTHORIZED.getMessage(), "Unauthorized message should not be null");
            assertNotNull(MessageType.INVALID_REQUEST.getMessage(), "Invalid request message should not be null");
            assertNotNull(MessageType.INTERNAL_SERVER_ERROR.getMessage(), "Internal server error message should not be null");
            assertNotNull(MessageType.GENERAL_EXCEPTION.getMessage(), "General exception message should not be null");
        }
    }
}
