package neoflex.app.neoflextestapp.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class VacationCalculatorService {
    private final HolidaysService holidaysService;
    private final double AVERAGE_WORKING_DAYS_PER_MONTH = 29.3;

    public VacationCalculatorService(HolidaysService holidaysService) {
        this.holidaysService = holidaysService;
    }

    /**
     * Базовый расчет отпускных без учёта праздников
     * Расчет суммы отпускных как средняя зарплата делённая на 29.3 (среднее количество рабочих дней в месяце) умноженная на количество дней отпуска
     *
     * @param averageSalary Средняя зарплата работника
     * @param vacationDays  Количество дней отпуска
     * @return Сумма отпускных
     */
    public double calculateBasic(double averageSalary, int vacationDays) {
        return (averageSalary / AVERAGE_WORKING_DAYS_PER_MONTH) * vacationDays;
    }

    /**
     * Расчет отпускных с учётом праздников и выходных
     * Метод рассчитывает сумму отпускных, учитывая только рабочие дни в заданном периоде, исключая выходные
     * и праздничные дни. Период определяется с помощью даты начала отпуска и количества дней отпуска.
     *
     * @param averageSalary   Средняя зарплата работника
     * @param vacationDays    Количество дней отпуска
     * @param startDateString Дата начала отпуска в формате 'yyyy-MM-dd'
     * @return Сумма отпускных
     */
    public double calculateWithHolidays(double averageSalary, int vacationDays, String startDateString) {
        LocalDate startDate = LocalDate.parse(startDateString);
        LocalDate endDate = startDate.plusDays(vacationDays - 1);

        int workingDays = 0;
        for (LocalDate date = startDate; date.isBefore(endDate) || date.isEqual(endDate); date = date.plusDays(1)) {
            if (isWorkingDay(date)) {
                workingDays++;
            }
        }
        return (averageSalary / AVERAGE_WORKING_DAYS_PER_MONTH) * workingDays;
    }

    /**
     * Проверка, является ли день рабочим
     *
     * @param date Дата, которую необходимо проверить
     * @return true, если день рабочий; false в противном случае
     */
    private boolean isWorkingDay(LocalDate date) {
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return false;
        }

        return !holidaysService.isHoliday(date);
    }
}
