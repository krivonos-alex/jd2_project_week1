package ru.mail.krivonos.al;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mail.krivonos.al.impl.FileReadingServiceImpl;
import ru.mail.krivonos.al.impl.FileRepositoryImpl;

import java.io.File;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        String fileName = "web-module" + File.separator + "src" + File.separator + "main" + File.separator +
                "resources" + File.separator + "file.txt";
        FileRepository fileRepository = FileRepositoryImpl.getInstance();
        FileReadingService fileReadingService = new FileReadingServiceImpl(fileRepository);
        String result = fileReadingService.readFile(fileName);
        logger.info(result);
    }
}
