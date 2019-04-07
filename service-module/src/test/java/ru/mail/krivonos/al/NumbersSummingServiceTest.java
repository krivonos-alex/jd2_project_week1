package ru.mail.krivonos.al;

import org.junit.Assert;
import org.junit.Test;
import ru.mail.krivonos.al.exceptions.IllegalStringContentException;
import ru.mail.krivonos.al.exceptions.NullArgumentException;
import ru.mail.krivonos.al.impl.NumbersSummingServiceImpl;

public class NumbersSummingServiceTest {

    @Test
    public void shouldReturnTheSameInstance() {
        NumbersSummingService numbersSummingServiceFirst = NumbersSummingServiceImpl.getInstance();
        NumbersSummingService numbersSummingServiceSecond = NumbersSummingServiceImpl.getInstance();
        Assert.assertSame(numbersSummingServiceFirst, numbersSummingServiceSecond);
    }

    @Test
    public void shouldReturnNumberFromString() {
        NumbersSummingService numbersSummingService = NumbersSummingServiceImpl.getInstance();
        Integer result = numbersSummingService.add("1");
        Integer expected = 1;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnSumOfNumbersFromString() {
        NumbersSummingService numbersSummingService = NumbersSummingServiceImpl.getInstance();
        Integer result = numbersSummingService.add("1,2");
        Integer expected = 3;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnZeroForEmptyString() {
        NumbersSummingService numbersSummingService = NumbersSummingServiceImpl.getInstance();
        Integer result = numbersSummingService.add("");
        Integer expected = 0;
        Assert.assertEquals(expected, result);
    }

    @Test(expected = IllegalStringContentException.class)
    public void shouldThrowIllegalStringContentExceptionForNonRegexMatchingString() {
        NumbersSummingService numbersSummingService = NumbersSummingServiceImpl.getInstance();
        numbersSummingService.add("1, 2");
    }

    @Test(expected = NullArgumentException.class)
    public void shouldThrowNullArgumentExceptionForNullArgument() {
        NumbersSummingService numbersSummingService = NumbersSummingServiceImpl.getInstance();
        numbersSummingService.add(null);
    }

}
