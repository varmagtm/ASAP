/**
 * 
 */
package com.mindtree.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mindtree.model.Solution;

/**
 * @author m1012679
 * Validates the Candidate
 */
public class SolutionValidator implements Validator {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		return Solution.class.isAssignableFrom(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sourceCode", "req.sourceCode",
				"the source code is required");
	}
}
