package ml.keith.seydina;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class DayFinderController {

    @GetMapping("/dayfinder")
    public String getDayOfWeek(@RequestParam("date") String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = dateFormat.parse(dateStr);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            String dayName = "";

            switch (dayOfWeek) {
                case Calendar.SUNDAY:
                    dayName = "Dimanche";
                    break;
                case Calendar.MONDAY:
                    dayName = "Lundi";
                    break;
                case Calendar.TUESDAY:
                    dayName = "Mardi";
                    break;
                case Calendar.WEDNESDAY:
                    dayName = "Mercredi";
                    break;
                case Calendar.THURSDAY:
                    dayName = "Jeudi";
                    break;
                case Calendar.FRIDAY:
                    dayName = "Vendredi";
                    break;
                case Calendar.SATURDAY:
                    dayName = "Samedi";
                    break;
            }

            return "Le jour de la semaine pour la date " + dateStr + " est : " + dayName;
        } catch (ParseException e) {
            return "Format de date invalide. Veuillez utiliser le format dd-MM-yyyy.";
        }
    }
}
