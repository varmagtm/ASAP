package com.mindtree.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.mindtree.model.TestCase;

public class TestCaseValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class cls) {
		return TestCase.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "testCaseDescription", "Desc",
				"a description of the test case is required");
		ValidationUtils.rejectIfEmpty(errors, "inputData", "input",
				"a description of the input data is required");
		ValidationUtils.rejectIfEmpty(errors, "expectedOutput", "output",
				"a description of the output data is required");
		ValidationUtils.rejectIfEmpty(errors, "score", "Score",
				"a score is required");
		TestCase testCase = (TestCase) object;
		double weightage = testCase.getScore();
		if (weightage <= 0.0) {
			errors.rejectValue("score", "Score", "the value specified for the score is not valid");
		}
	}
}
