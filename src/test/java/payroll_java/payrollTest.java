package payroll_java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PayrollTest {

    @Test
    void testValidInput() {
        // Valid inputs
        int employeeID = 5245;
        char employmentType = 'P'; // C, P, or F
        double hoursWorked = 10.0; // Hours worked during the week
        double hourlyRate = 60.0; // Hourly rate

        assertTrue(payroll.isValidInput(employeeID, employmentType, hoursWorked, hourlyRate));
    }

    @Test
    void testInvalidInput() {
        // Invalid inputs (outside the specified ranges)
        int employeeID = 17745;
        char employmentType = 'P'; // C, P, or F
        double hoursWorked = 80.0; // Hours worked outside the valid range
        double hourlyRate = 20.0; // Hourly rate outside the valid range

        assertFalse(payroll.isValidInput(employeeID, employmentType, hoursWorked, hourlyRate));
    }

    @Test
    void testCalculateWeeklyWages() {
        // Valid inputs
        double hoursWorked = 10.0;
        double hourlyRate = 60.0;

        double expectedWeeklyWages = hoursWorked * hourlyRate;

        assertEquals(expectedWeeklyWages, payroll.calculateWeeklyWages(hoursWorked, hourlyRate));
    }

    @Test
    void testCalculateWeeklyWagesWithDifferentInputs() {
        // Test with different inputs for weekly wage calculation
        double hoursWorked = 20.0;
        double hourlyRate = 40.0;

        double expectedWeeklyWages = hoursWorked * hourlyRate;

        assertEquals(expectedWeeklyWages, payroll.calculateWeeklyWages(hoursWorked, hourlyRate));
    }

    @Test
    void testCalculateWeeklyWagesWithZeroHoursWorked() {
        // Test with zero hours worked
        double hoursWorked = 0.0;	
        double hourlyRate = 50.0;

        double expectedWeeklyWages = 0.0;

        assertEquals(expectedWeeklyWages, payroll.calculateWeeklyWages(hoursWorked, hourlyRate));
    }

    @Test
    void testValidInputWithEdgeCases() {
        assertTrue(payroll.isValidInput(1000, 'C', 5.0, 25.0)); // Minimum values
        assertTrue(payroll.isValidInput(9999, 'F', 70.0, 75.0)); // Maximum values
    }

    @Test
    void testInvalidInputWithEdgeCases() {
        assertFalse(payroll.isValidInput(999, 'C', 5.0, 25.0)); // Invalid employee ID
        assertFalse(payroll.isValidInput(10000, 'P', 71.0, 75.0)); // Invalid hours worked
        assertFalse(payroll.isValidInput(10001, 'F', 10.0, 76.0)); // Invalid hourly rate
    }
}
