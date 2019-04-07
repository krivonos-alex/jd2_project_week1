package ru.mail.krivonos.al;

import org.junit.Assert;
import org.junit.Test;
import ru.mail.krivonos.al.exceptions.FileNotExistException;
import ru.mail.krivonos.al.impl.FileRepositoryImpl;

import java.util.List;

public class FileRepositoryTest {

    @Test
    public void shouldReturnTheSameInstance() {
        FileRepository fileRepositoryFirst = FileRepositoryImpl.getInstance();
        FileRepository fileRepositorySecond = FileRepositoryImpl.getInstance();
        Assert.assertSame(fileRepositoryFirst, fileRepositorySecond);
    }

    @Test
    public void shouldReturnEmptyListForEmptyFile() {
        FileRepository fileRepository = FileRepositoryImpl.getInstance();
        List<String> lines = fileRepository.readFile("repository-module/src/test/resources/empty-file-test.txt");
        Assert.assertTrue(lines.isEmpty());
    }

    @Test
    public void shouldReturnListWithTwoStringsReadingFileWithTwoLines() {
        FileRepository fileRepository = FileRepositoryImpl.getInstance();
        List<String> lines = fileRepository.readFile("repository-module/src/test/resources/with-two-lines-test.txt");
        System.out.println(lines);
        Assert.assertEquals(2, lines.size());
    }

    @Test(expected = FileNotExistException.class)
    public void shouldThrowFileNotExistExceptionIfFileNotExist() {
        FileRepository fileRepository = FileRepositoryImpl.getInstance();
        fileRepository.readFile("not-existing-file.txt");
    }
}
