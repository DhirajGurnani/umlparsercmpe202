
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
	        File projectDir = new File("Test Case 1");
	        GettingClassNames getclassnames = new GettingClassNames();
	        ArrayList a= new ArrayList();
	        a = getclassnames.listClasses(projectDir);
	        for(Object a1 : a){
	        	System.out.println(a1);
	        }
	    }
	}

