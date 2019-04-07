package ru.mail.krivonos.al;

import org.junit.Assert;
import org.junit.Test;
import ru.mail.krivonos.al.impl.FileReadingServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class FileReadingServiceTest {

    @Test
    public void shouldCallRepositoryMethod() {
        FileRepositoryMock fileRepositoryMock = new FileRepositoryMock();
        FileReadingService fileReadingService = new FileReadingServiceImpl(fileRepositoryMock);
        String fileName = "filename";
        fileReadingService.getLine(fileName);
        Assert.assertSame(fileName, fileRepositoryMock.getInputFileName());
    }

    @Test
    public void shouldReturnStringFromListDuePattern() {
        FileRepositoryMock fileRepositoryMock = new FileRepositoryMock();
        List<String> lines = new ArrayList<>();
        String suitableLine = "2,3";
        lines.add(suitableLine);
        fileRepositoryMock.setLines(lines);
        FileReadingService fileReadingService = new FileReadingServiceImpl(fileRepositoryMock);
        String fileName = "filename";
        String result = fileReadingService.getLine(fileName);
        Assert.assertSame(suitableLine, result);
    }

    @Test
    public void shouldReturnEmptyStringForAllUnsuitableLines() {
        FileRepositoryMock fileRepositoryMock = new FileRepositoryMock();
        List<String> lines = new ArrayList<>();
        String unsuitableLine1 = "2, 3";
        String unsuitableLine2 = "2 2";
        lines.add(unsuitableLine1);
        lines.add(unsuitableLine2);
        fileRepositoryMock.setLines(lines);
        FileReadingService fileReadingService = new FileReadingServiceImpl(fileRepositoryMock);
        String fileName = "filename";
        String result = fileReadingService.getLine(fileName);
        Assert.assertSame("", result);
    }
}
