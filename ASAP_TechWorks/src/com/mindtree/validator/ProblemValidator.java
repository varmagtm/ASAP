package com.mindtree.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mindtree.model.Problem;

public class ProblemValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class cls) {
		return Problem.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "Name",
				"a name is required");
		ValidationUtils.rejectIfEmpty(errors, "description", "Description",
				"a description of the problem statement is required");
		ValidationUtils.rejectIfEmpty(errors, "input", "Input",
				"a description of the input is required");
		ValidationUtils.rejectIfEmpty(errors, "output", "Output",
				"a description of the output is required");
		ValidationUtils.rejectIfEmpty(errors, "timeLimit", "TimeLimit",
				"a time limit is required");

		int timeLimit = ((Problem) object).getTimeLimit();
		if (timeLimit < 1) {
			errors.rejectValue("timeLimit", "Invalid", "the value specified for duration is not valid");
		}
	}
}
