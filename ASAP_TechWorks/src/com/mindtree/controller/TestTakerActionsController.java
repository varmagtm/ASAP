/**
 * 
 */
package com.mindtree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author m1012776
 * 
 */
@Controller
@RequestMapping("/TestTakerHome.action")
public class TestTakerActionsController {
	@RequestMapping(method = RequestMethod.GET)
	public String initForm() {
		String target = "testTakerHome";
		return target;
	}
}
