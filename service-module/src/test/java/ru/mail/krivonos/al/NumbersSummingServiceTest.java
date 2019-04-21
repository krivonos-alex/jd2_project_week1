package ru.mail.krivonos.al;

import org.junit.Assert;
import org.junit.Test;
import ru.mail.krivonos.al.exceptions.IllegalStringContentException;
import ru.mail.krivonos.al.exceptions.NullArgumentException;
import ru.mail.krivonos.al.impl.NumbersSummingServiceImpl;

public class NumbersSummingServiceTest {

    private NumbersSummingService numbersSummingService = NumbersSummingServiceImpl.getInstance();

    @Test
    public void shouldReturnNumberFromString() {
        int result = numbersSummingService.add("1");
        Assert.assertEquals(1, result);
    }

    @Test
    public void shouldReturnSumOfNumbersFromStringWithCommaSeparator() {
        int result = numbersSummingService.add("1,2");
        Assert.assertEquals(3, result);
    }

    @Test
    public void shouldReturnSumOfNumbersFromStringWithColonSeparator() {
        int result = numbersSummingService.add("1:2");
        Assert.assertEquals(3, result);
    }

    @Test
    public void shouldReturnSumOfNumbersFromStringWithVerticalLineSeparator() {
        int result = numbersSummingService.add("1|2");
        Assert.assertEquals(3, result);
    }

    @Test
    public void shouldReturnSumOfNumbersFromStringWithLineSeparatorAsSeparator() {
        int result = numbersSummingService.add("1\n2");
        Assert.assertEquals(3, result);
    }

    @Test
    public void shouldReturnZeroForEmptyString() {
        int result = numbersSummingService.add("");
        Assert.assertEquals(0, result);
    }

    @Test(expected = IllegalStringContentException.class)
    public void shouldThrowIllegalStringContentExceptionForNonRegexMatchingString() {
        numbersSummingService.add("1, 2");
    }

    @Test(expected = NullArgumentException.class)
    public void shouldThrowNullArgumentExceptionForNullArgument() {
        numbersSummingService.add(null);
    }

}
