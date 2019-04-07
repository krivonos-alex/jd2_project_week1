package ru.mail.krivonos.al.impl;

import ru.mail.krivonos.al.NumbersSummingService;
import ru.mail.krivonos.al.constants.ServiceConstants;
import ru.mail.krivonos.al.exceptions.IllegalStringContentException;
import ru.mail.krivonos.al.exceptions.NullArgumentException;

public class NumbersSummingServiceImpl implements NumbersSummingService {

    private static NumbersSummingService instance;

    private NumbersSummingServiceImpl() {
    }

    public static NumbersSummingService getInstance() {
        if (instance == null) {
            instance = new NumbersSummingServiceImpl();
        }
        return instance;
    }

    @Override
    public Integer add(String numbers) {
        validate(numbers);
        if (!numbers.isEmpty()) {
            String[] splittedNumbers = numbers.split(ServiceConstants.NUMBERS_STRING_SPLIT_REGEX);
            Integer result = 0;
            for (String number : splittedNumbers) {
                result += Integer.valueOf(number);
            }
            return result;
        } else {
            return 0;
        }
    }

    private void validate(String validatingString) {
        if (validatingString == null) {
            throw new NullArgumentException("No argument presented");
        }
        if (!validatingString.matches(ServiceConstants.NUMBERS_STRING_REGEX)) {
            throw new IllegalStringContentException("String should contain max 2 numbers with some separators");
        }
    }
}
