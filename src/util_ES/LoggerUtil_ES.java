package util_ES;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class LoggerUtil_ES {

    // اسم ملف اللوق
    private static final String LOG_FILE = "log_ES.txt";

    // فورمات التاريخ والوقت
    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Constructor private عشان ما نقدرش ندير new LoggerUtil_ES()
    private LoggerUtil_ES() { }

    // دالة عامة أساسية تكتب في الملف
    public static void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(FMT);

        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            out.printf("[%s] [%s] %s%n", timestamp, level, message);
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }

    // للمعلومات العادية
    public static void logInfo(String msg) {
        log("INFO", msg);
    }

    // للأخطاء
    public static void logError(String msg) {
        log("ERROR", msg);
    }

    // لو حبيتي دebug
    public static void logDebug(String msg) {
        log("DEBUG", msg);
    }
}
