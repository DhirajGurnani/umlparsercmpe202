
import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;


import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter ;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.google.common.base.Strings;


/**
 * Hello world!
 *
 */
public class App 
{
	    public static void main(String[] args) {
	    	 ArrayList<String> Class_Names = new ArrayList<String>();
	    	//String result = "@startuml"+"Object <|-- ArrayList"+"Object : equals()"+"ArrayList : Object[] elementData"+"ArrayList : size()"+"@enduml";
	        File projectDir = new File("Test Case 1");
	        Class_Structure getclassnames = new Class_Structure();
	        File Class_names[] = projectDir.listFiles((File pathName) -> pathName.getName().endsWith(".java"));
	        //System.out.println(fileTemp[0	]);
	        //Class_Names = getclassnames.getClasses(projectDir);
	        //System.out.println(Class_Names);
	        //System.out.println(Class_Names);
	        for(String x: Class_Names){
	        	//System.out.println(x);
	        		FileInputStream in;
						try {
							in = new FileInputStream(x);

				            try {
								CompilationUnit cu = JavaParser.parse(in);
								new GettingClassNames().visit(cu,null);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			            // parse it

			            // visit and print the mesthods names
			           // new MethodVisitor().visit(cu, null);
			    

	        }
	    }
	}
