package ru.mail.krivonos.al.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mail.krivonos.al.FileRepository;
import ru.mail.krivonos.al.exceptions.FileNotExistException;
import ru.mail.krivonos.al.exceptions.FileRepositoryException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileRepositoryImpl implements FileRepository {

    private static FileRepository instance;

    private static final Logger logger = LogManager.getLogger(FileRepositoryImpl.class);

    private FileRepositoryImpl() {
    }

    public static FileRepository getInstance() {
        if (instance == null) {
            instance = new FileRepositoryImpl();
        }
        return instance;
    }

    @Override
    public List<String> readFile(String fileName) {
        validate(fileName);
        List<String> lines;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            lines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new FileRepositoryException();
        }
        return lines;
    }

    private void validate(String targetFileName) {
        File checkingFile = new File(targetFileName);
        if (!checkingFile.exists()) {
            throw new FileNotExistException("Target file doesn't exist");
        }
    }
}
