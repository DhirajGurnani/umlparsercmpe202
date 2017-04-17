
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import net.sourceforge.plantuml.SourceStringReader;

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
	        Class_Structure getclassnames = new Class_Structure();
	        MethodVisitor getting_method_information = new MethodVisitor();
	        Class_Names = getclassnames.getClasses(projectDir);
	        File fileTemp[] = projectDir.listFiles((File pathName) -> pathName.getName().endsWith(".java"));
	        
			CompilationUnit cUnit[] = new CompilationUnit[fileTemp.length];
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
			//	new ClassVisitor().visit(cUnit[in], null);
				new field_information_fetcher().visit(cUnit[in], null);
			}
			OutputStream png = null;
			try {
				png = new FileOutputStream("output.png");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			String source = "@startuml\n";
			for(String x : getclassnames.Class_Names)
			source += "class "+ x +"\n";
			source += "@enduml\n";

			SourceStringReader reader = new SourceStringReader(source);
			// Write the first image to "png"
			try {
				String desc = reader.generateImage(png);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Return a null string if no generation
	    }
	}
