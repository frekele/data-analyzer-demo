package org.frekele.demo.data.analyzer.service.validation;

import org.frekele.demo.data.analyzer.enums.LayoutMatcherRegexEnum;

import java.util.regex.Matcher;

public interface LayoutValidation {

    Boolean checkLayout(LayoutMatcherRegexEnum layoutMatcherRegexEnum);

    Matcher getMatcherByLayout(LayoutMatcherRegexEnum layoutMatcherRegexEnum);

    Matcher getMatcherResult();
}
