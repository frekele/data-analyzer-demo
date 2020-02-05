package org.frekele.demo.data.analyzer.service;

import org.frekele.demo.data.analyzer.enums.LayoutMatcherRegexEnum;

import java.io.File;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseServiceTest {

    public static Matcher getMatcherByLayout(String line, LayoutMatcherRegexEnum layoutMatcherRegexEnum) {
        return Pattern.compile(layoutMatcherRegexEnum.getRegex()).matcher(line);
    }

    protected File getFileByName(String fileName) {
        return new File(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).getFile());
    }

}
