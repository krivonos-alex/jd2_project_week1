package ru.mail.krivonos.al;

import java.util.ArrayList;
import java.util.List;

public class FileRepositoryMock implements FileRepository {

    private String inputFileName;

    private List<String> lines = new ArrayList<>();

    @Override
    public List<String> readFile(String fileName) {
        inputFileName = fileName;
        return lines;
    }

    String getInputFileName() {
        return inputFileName;
    }

    void setLines(List<String> lines) {
        this.lines = lines;
    }
}
