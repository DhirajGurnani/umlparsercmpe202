
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;


/**
 * Hello world!
 *
 */
public class App 
{
	    public static void main(String[] args) {
	    	 ArrayList<String> Class_Names = new ArrayList<String>();

	        File projectDir = new File("Test Case 1");
	        GettingClassNames getclassnames = new GettingClassNames();
	        Class_Names = getclassnames.getClasses(projectDir);
	        System.out.println(Class_Names);
	    }
	}

