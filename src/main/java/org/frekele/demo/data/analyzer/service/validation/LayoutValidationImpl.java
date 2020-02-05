package org.frekele.demo.data.analyzer.service.validation;

import lombok.extern.slf4j.Slf4j;
import org.frekele.demo.data.analyzer.enums.LayoutMatcherRegexEnum;
import org.frekele.demo.data.analyzer.exception.DataAnalyzerException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class LayoutValidationImpl implements LayoutValidation {

    private Matcher matcherResult;

    private String lineProcess;

    public LayoutValidationImpl(String lineProcess) {
        this.lineProcess = lineProcess;
    }

    public Boolean checkLayout(LayoutMatcherRegexEnum layoutMatcherRegexEnum) {
        try {
            return this.getMatcherByLayout(layoutMatcherRegexEnum).find();
        } catch (Exception e) {
            throw new DataAnalyzerException("Regular expression did not match " + layoutMatcherRegexEnum.getRegex(), e);
        }
    }

    public Matcher getMatcherByLayout(LayoutMatcherRegexEnum layoutMatcherRegexEnum) {
        this.matcherResult = Pattern.compile(layoutMatcherRegexEnum.getRegex()).matcher(this.lineProcess);
        return this.matcherResult;
    }

    public Matcher getMatcherResult() {
        return this.matcherResult;
    }
}
