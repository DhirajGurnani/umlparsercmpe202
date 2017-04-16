
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
	        MethodVisitor getting_method_information = new MethodVisitor();
	       // File Class_names[] = projectDir.listFiles((File pathName) -> pathName.getName().endsWith(".java"));
	        //System.out.println(fileTemp[0	]);
	        Class_Names = getclassnames.getClasses(projectDir);
	        //getting_method_information.visit(, arg);
	        File fileTemp[] = projectDir.listFiles((File pathName) -> pathName.getName().endsWith(".java"));
	        
			CompilationUnit cUnit[] = new CompilationUnit[fileTemp.length];
	        //System.out.println(Class_Names);
	        //System.out.println(Class_Names);
//	        int s = Class_Names.size();
//	        CompilationUnit cu = new CompilationUnit();
	       // for(int i = 0; i<s;i++){
	        	//System.out.println(x);
	        		//FileInputStream in;
			/*				in = new FileInputStream();
							
								CompilationUnit cunit = JavaParser.parse(in);
			*/		//			new GettingClassNames().visit(cu,null);

			            // visit and print the mesthods names
			           // new MethodVisitor().visit(cu, null);
			    

	        //}
			try{
				//parse all JAVA files
				for(int index=0; index < cUnit.length; index++){
					 cUnit[index] = JavaParser.parse(fileTemp[index]);
				}
			}catch(Exception e){
				System.out.println("Exception Occurred :: " + e.getMessage());
				e.printStackTrace();
			}
			
			for(int in = 0; in < cUnit.length; in++){
				new MethodVisitor().visit(cUnit[in], null);
				new ClassVisitor().visit(cUnit[in], null);
				new field_information_fetcher().visit(cUnit[in], null);
			}
	    }
	}
