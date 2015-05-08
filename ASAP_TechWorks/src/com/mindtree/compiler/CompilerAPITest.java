package com.mindtree.compiler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.mindtree.model.CompilerResult;
import com.mindtree.model.Score;
import com.mindtree.model.Solution;
import com.mindtree.model.TestCase;

public class CompilerAPITest {
	public static CompilerResult compileCode(File sourceFile,
			List<TestCase> testCases) {
		CompilerResult compilerResult = new CompilerResult();
		Solution solution = new Solution();
		Score score = new Score();
		try {
			JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
			DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
			StandardJavaFileManager sjfm = jc.getStandardFileManager(null,
					null, null);
			PrintStream console = System.out;

			// FOR IN-MEMORY CODE
			// JavaFileObject file = new JavaSourceFromString("ClassName",
			// code);

			// File javaFile = new File(sourceFile);
			Iterable fileObjects = sjfm.getJavaFileObjects(sourceFile);

			String[] options = new String[] { "-d", "C:\\Users\\m1005676\\workspace\\ASAP_TechWorks" };

			CompilationTask task = jc.getTask(null, null, diagnostics,
					Arrays.asList(options), null, fileObjects);
			boolean success = task.call();
			if (success == false) {
				// PRINT COMPILATION ERRORS
				System.out.println("Compilation errors:\n");
				StringBuffer errorString = new StringBuffer(" ");
				for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
					System.out.println("1." + diagnostic.getCode());
					System.out.println("2." + diagnostic.getKind());
					System.out.println("3." + diagnostic.getPosition());
					System.out.println("4." + diagnostic.getStartPosition());
					System.out.println("5." + diagnostic.getEndPosition());
					System.out.println("6." + diagnostic.getSource());
					System.out.println("7." + diagnostic.getMessage(null));
					errorString.append(diagnostic.getMessage(null) + ";");
				}
				solution.setCompilerError(errorString.toString());
				solution.setComplierState("Failure");
				compilerResult.setSolution(solution);
				compilerResult.setErrorMessage(errorString.toString());
				score.setTotalScore(0);
				compilerResult.setScore(score);
				return compilerResult;
			}
			sjfm.close();

			// INPUT AND EXPECTED OUTPUT
			// String inputs[] = { "HeLlo WoRld ...", "prashant patil" };
			// String expectedOutputs[] = { "HELLO WORLD ...", "PRASHANT PATIL"
			// };

			int size = testCases.size();
			String inputs[] = new String[size];
			String expectedOutputs[] = new String[size];
			for (int i = 0; i < size; i++) {
				inputs[i] = testCases.get(i).getInputData();
				expectedOutputs[i] = testCases.get(i).getExpectedOutput();
				System.out.println("INPUT " + i + " : " + inputs[i]);
				System.out.println("OUTPUT " + i + " : " + expectedOutputs[i]);
			}
			double cScore = 0;
			System.out.println("************************test."
					+ sourceFile.getName().substring(0,
							sourceFile.getName().length() - 5));
			Class cls = Class.forName("test."
					+ sourceFile.getName().substring(0,
							sourceFile.getName().length() - 5));
			Method method = cls.getDeclaredMethod("main",
					new Class[] { String[].class });
			Object object = cls.newInstance();
			for (int i = 0; i < inputs.length; i++) {
				// TestCase testCase = new TestCase();
				InputStream inputStream = new ByteArrayInputStream(
						inputs[i].getBytes());
				System.setIn(inputStream);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				System.setOut(new PrintStream(baos));
				method.invoke(object, new Object[] { null });
				String output = baos.toString("UTF8");
				System.setOut(console);
				System.out.println("TEST CASE #" + (i + 1));
				System.out.println("\tINPUT: [" + inputs[i] + "], ");
				System.out.println("\tEXPECTED OUTPUT: [" + expectedOutputs[i]
						+ "], ");
				System.out.println("\tACTUAL OUTPUT: [" + output + "]");
				// testCase.setInputData(inputs[i]);
				// testCase.setExpectedOutput(expectedOutputs[i]);
				// testCase.setActualOutput(output);
				testCases.get(i).setInputData(inputs[i]);
				testCases.get(i).setExpectedOutput(expectedOutputs[i]);
				testCases.get(i).setActualOutput(output);
				if (output.equals(expectedOutputs[i])) {
					cScore = cScore + testCases.get(i).getScore();
					testCases.get(i).setStatus("Passed");
					System.out.println("\tRESULT: PASSED");
				} else {
					testCases.get(i).setStatus("Failed");
					System.out.println("\tRESULT: FAILED");
				}
				score.setTotalScore(cScore);
				solution.setComplierState("Success");
				compilerResult.setScore(score);
				compilerResult.setSolution(solution);
				compilerResult.setTestCases(testCases);
				System.out.println("Final Score : " + cScore);
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compilerResult;
	}
}