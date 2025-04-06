package neoflex.app.neoflextestapp.controller;

import neoflex.app.neoflextestapp.service.VacationCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeParseException;

@RestController
public class VacationCalculatorController {

    @Autowired
    private VacationCalculatorService vacationCalculatorService;

    @GetMapping("/calculate")
    public double calculateVacationPay(
            @RequestParam(name = "averageSalary") double averageSalary,
            @RequestParam(name = "vacationDays") int vacationDays,
            @RequestParam(name = "startDate", required = false) String startDate
    ) {
        if (averageSalary < 0 || vacationDays < 0) {
            throw new IllegalArgumentException("Зарплата и дни отпуска должны быть неотрицательными.");
        }

        if (startDate != null) {
            try {
                return vacationCalculatorService.calculateWithHolidays(averageSalary, vacationDays, startDate);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Неверный формат даты. Пожалуйста, используйте \"гггг-ММ-дд\".");
            }
        } else {
            return vacationCalculatorService.calculateBasic(averageSalary, vacationDays);
        }
    }
}
