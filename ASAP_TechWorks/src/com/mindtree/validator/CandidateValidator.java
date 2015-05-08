/**
 * 
 */
package com.mindtree.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mindtree.model.Candidate;

/**
 * @author m1012776 Validates the Candidate
 */
public class CandidateValidator implements Validator {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		return Candidate.class.isAssignableFrom(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "req.name",
				"a name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId",
				"req.employeeId", "an identifier is required");

	}
}
