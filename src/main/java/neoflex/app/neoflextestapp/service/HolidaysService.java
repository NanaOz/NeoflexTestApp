package neoflex.app.neoflextestapp.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class HolidaysService {
    private Set<LocalDate> holidays = new HashSet<>();

    /**
     * Конструктор, инициализирующий набор праздничных дней.
     * Праздничные дни для 2024 и 2025 годов.
     */
    public HolidaysService() {
        holidays.add(LocalDate.parse("2024-01-01"));
        holidays.add(LocalDate.parse("2024-01-02"));
        holidays.add(LocalDate.parse("2024-01-03"));
        holidays.add(LocalDate.parse("2024-01-04"));
        holidays.add(LocalDate.parse("2024-01-05"));
        holidays.add(LocalDate.parse("2024-01-08"));
        holidays.add(LocalDate.parse("2024-02-23"));
        holidays.add(LocalDate.parse("2024-03-08"));
        holidays.add(LocalDate.parse("2024-04-29"));
        holidays.add(LocalDate.parse("2024-04-30"));
        holidays.add(LocalDate.parse("2024-05-01"));
        holidays.add(LocalDate.parse("2024-05-09"));
        holidays.add(LocalDate.parse("2024-05-10"));
        holidays.add(LocalDate.parse("2024-06-12"));
        holidays.add(LocalDate.parse("2024-11-04"));
        holidays.add(LocalDate.parse("2024-12-30"));
        holidays.add(LocalDate.parse("2024-12-31"));
        holidays.add(LocalDate.parse("2025-01-01"));
        holidays.add(LocalDate.parse("2025-01-02"));
        holidays.add(LocalDate.parse("2025-01-03"));
        holidays.add(LocalDate.parse("2025-01-06"));
        holidays.add(LocalDate.parse("2025-01-07"));
        holidays.add(LocalDate.parse("2025-01-08"));
        holidays.add(LocalDate.parse("2025-05-01"));
        holidays.add(LocalDate.parse("2025-05-02"));
        holidays.add(LocalDate.parse("2025-05-08"));
        holidays.add(LocalDate.parse("2025-05-09"));
        holidays.add(LocalDate.parse("2025-06-12"));
        holidays.add(LocalDate.parse("2025-06-13"));
        holidays.add(LocalDate.parse("2025-11-03"));
        holidays.add(LocalDate.parse("2025-11-04"));
        holidays.add(LocalDate.parse("2025-12-31"));
    }

    /**
     * Проверяет, является ли указанная дата праздничным днем.
     *
     * @param date Дата, которую необходимо проверить
     * @return true, если дата является праздничным днем; false в противном случае
     */
    public boolean isHoliday(LocalDate date) {
        return holidays.contains(date);
    }
}
