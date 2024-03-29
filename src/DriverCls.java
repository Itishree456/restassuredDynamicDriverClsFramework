import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import commonFunctionsPack.Utility_Common_Function;

public class DriverCls {

	public static void main(String[] args)
			throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException

	{

		ArrayList<String> testCaseRun = Utility_Common_Function.ReadDataExcel("PostRunner", "TCtoExecute");
		int Count = testCaseRun.size();
		// System.out.println(Count);
		for (int i = 1; i < Count; i++) {
			String testCaseName = testCaseRun.get(i);
			System.out.println(testCaseName);

			// Step1: Call the testCaseClass on runtime by using java.lang.reflect package
			Class<?> testClassName = Class.forName("testClassPack." + testCaseName);

			// Step2: Call the execute mtd belonging to test class captured in var
			// testClassName by using java.lang.reflect.method class
			Method executeMtd = testClassName.getDeclaredMethod("execute");

			// Step3: Set the accessibilty of method true
			executeMtd.setAccessible(true);

			// Step4: Create an instance of testClass captured in variable name 'testClassName'
			Object instanceOfTestClass = testClassName.getDeclaredConstructor().newInstance();
			
			// Step5: Execute the testclass captured in variable name testclass name
			executeMtd.invoke(instanceOfTestClass);
		}
	}

}