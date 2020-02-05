package org.frekele.demo.data.analyzer.factory;

import org.frekele.demo.data.analyzer.enums.LayoutMatcherRegexEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseFactoryTest {

    public static Matcher getMatcherByLayout(String line, LayoutMatcherRegexEnum layoutMatcherRegexEnum) {
        return Pattern.compile(layoutMatcherRegexEnum.getRegex()).matcher(line);
    }
}
