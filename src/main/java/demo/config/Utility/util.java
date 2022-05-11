package demo.config.Utility;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class util {
    public static String getTimeStamp() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM_dd_yyyy_hh_mm_ss_a");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return dtf.format(now);
    }

    public static void createFolder(String path) {
        File file = new File(path);
        if (!file.exists()) {
            if (file.mkdir())
                System.out.println("folder created successfully !!");
            else
                System.out.println("Failed to create folder");
        }
    }
}
