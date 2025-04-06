package neoflex.app.neoflextestapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class VacationCalculatorServiceTest {
    private VacationCalculatorService vacationCalculatorService;

    @BeforeEach
    public void setUp() {
        HolidaysService holidaysService = new HolidaysService();
        vacationCalculatorService = new VacationCalculatorService(holidaysService);
    }


    @Test
    public void testCalculateBasic() {
        double averageSalary = 3000.0;
        int vacationDays = 10;

        double expectedVacationPay = (averageSalary / 29.3) * vacationDays;
        double actualVacationPay = vacationCalculatorService.calculateBasic(averageSalary, vacationDays);

        Assertions.assertEquals(expectedVacationPay, actualVacationPay, 0.01);
    }

    @Test
    public void testCalculateWithHolidays() {
        double averageSalary = 3000.0;
        int vacationDays = 10;
        String startDate = "2024-04-28";

        double expectedVacationPay = (averageSalary / 29.3) * 4;
        double actualVacationPay = vacationCalculatorService.calculateWithHolidays(averageSalary, vacationDays, startDate);

        Assertions.assertEquals(expectedVacationPay, actualVacationPay, 0.01);
    }

}
