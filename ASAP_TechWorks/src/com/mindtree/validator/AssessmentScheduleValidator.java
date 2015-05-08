package com.mindtree.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mindtree.model.AssessmentSchedule;

public class AssessmentScheduleValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		return AssessmentSchedule.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate",
				"required.startDate", "a start date is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate",
				"required.endDate", "an end date is required");

		AssessmentSchedule assessmentSchedule = (AssessmentSchedule) obj;
		if (assessmentSchedule.getStartDate() == null) {
			errors.rejectValue("startDate", "required.startDate2",
					"a start date us required");
		}

		if (assessmentSchedule.getEndDate() == null) {
			errors.rejectValue("endDate", "required.endDate2",
					"an end date is required");
		}

		if (assessmentSchedule.getStartDate() != null
				&& assessmentSchedule.getEndDate() != null) {
			if (assessmentSchedule.getStartDate().after(
					assessmentSchedule.getEndDate())) {
				errors.rejectValue("startDate", "required.startDate1",
						"the start date should be before end date");
			} else if (assessmentSchedule.getEndDate().before(
					assessmentSchedule.getStartDate())) {
				errors.rejectValue("endDate", "required.endDate1",
						"the end date should be after the start date");
			}
		}
	}
}
