package ru.mail.krivonos.al;

import java.util.List;

public interface FileRepository {

    List<String> readFile(String fileName);
}
