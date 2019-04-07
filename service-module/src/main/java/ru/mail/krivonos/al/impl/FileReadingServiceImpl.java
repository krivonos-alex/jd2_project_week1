package ru.mail.krivonos.al.impl;

import ru.mail.krivonos.al.FileReadingService;
import ru.mail.krivonos.al.FileRepository;
import ru.mail.krivonos.al.constants.ServiceConstants;

import java.util.List;

public class FileReadingServiceImpl implements FileReadingService {

    private FileRepository fileRepository;

    //Public constructor with arguments for better testability
    public FileReadingServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public String getLine(String fileName) {
        List<String> lines = fileRepository.readFile(fileName);
        return lines.stream()
                .filter(line -> line.matches(ServiceConstants.NUMBERS_STRING_REGEX))
                .findAny()
                .orElse("");
    }
}
