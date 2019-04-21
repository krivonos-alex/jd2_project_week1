package ru.mail.krivonos.al;

import org.junit.Assert;
import org.junit.Test;
import ru.mail.krivonos.al.exceptions.FileNotExistException;
import ru.mail.krivonos.al.impl.FileRepositoryImpl;

import java.util.List;

public class FileRepositoryTest {

    private FileRepository fileRepository = FileRepositoryImpl.getInstance();

    @Test
    public void shouldReturnEmptyListForEmptyFile() {
        List<String> lines = fileRepository.readFile("/home/alex/Documents/IT-Academy_JD2/jd2_project_week1/repository-module/src/test/resources/empty-file-test.txt");
        Assert.assertTrue(lines.isEmpty());
    }

    @Test
    public void shouldReturnListWithTwoStringsReadingFileWithTwoLines() {
        List<String> lines = fileRepository.readFile("/home/alex/Documents/IT-Academy_JD2/jd2_project_week1/repository-module/src/test/resources/with-two-lines-test.txt");
        System.out.println(lines);
        Assert.assertEquals(2, lines.size());
    }

    @Test(expected = FileNotExistException.class)
    public void shouldThrowFileNotExistExceptionIfFileNotExist() {
        fileRepository.readFile("not-existing-file.txt");
    }
}
