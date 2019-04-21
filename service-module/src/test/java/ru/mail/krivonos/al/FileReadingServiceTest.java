package ru.mail.krivonos.al;

import org.junit.Assert;
import org.junit.Test;
import ru.mail.krivonos.al.impl.FileReadingServiceImpl;

public class FileReadingServiceTest {

    private FileReadingService fileReadingService = FileReadingServiceImpl.getInstance();

    @Test
    public void shouldReturnEmptyStringForEmptyFile() {
        String filename = "/home/alex/Documents/IT-Academy_JD2/jd2_project_week1/service-module/src/test/resources" +
                "/empty-file-test.txt";
        String line = fileReadingService.getLine(filename);
        Assert.assertEquals("", line);
    }

    @Test
    public void shouldReturnFromFileStringWithCommaSeparator() {
        String filename = "/home/alex/Documents/IT-Academy_JD2/jd2_project_week1/service-module/src/test/resources" +
                "/with-comma-separator-test.txt";
        String line = fileReadingService.getLine(filename);
        Assert.assertEquals("2,3", line);
    }

    @Test
    public void shouldReturnFromFileStringWithVerticalLineSeparator() {
        String filename = "/home/alex/Documents/IT-Academy_JD2/jd2_project_week1/service-module/src/test/resources" +
                "/with-vertical-line-separator-test.txt";
        String line = fileReadingService.getLine(filename);
        Assert.assertEquals("2|3", line);
    }

    @Test
    public void shouldReturnFromFileStringWithColonSeparator() {
        String filename = "/home/alex/Documents/IT-Academy_JD2/jd2_project_week1/service-module/src/test/resources" +
                "/with-colon-separator-test.txt";
        String line = fileReadingService.getLine(filename);
        Assert.assertEquals("2:3", line);
    }

    @Test
    public void shouldReturnEmptyStringFromFileWithNoMatches() {
        String filename = "/home/alex/Documents/IT-Academy_JD2/jd2_project_week1/service-module/src/test/resources" +
                "/no-matches-test.txt";
        String line = fileReadingService.getLine(filename);
        Assert.assertEquals("", line);
    }
}