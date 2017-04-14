import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;

import java.io.File;
import java.util.ArrayList;

import jdk.internal.dynalink.beans.StaticClass;


public class checking {
	@SuppressWarnings("unchecked")
	public static void main(String args[]){
		StaticClass.classList = new ArrayList<ClassModel>();
		StaticClass.index=0;
		ArrayList<FieldModel> fieldList = new ArrayList<FieldModel>();
		ArrayList<MethodModel> methodList = new ArrayList<MethodModel>();
		ArrayList<ConstructorModel> constructorList = new ArrayList<ConstructorModel>();
		
		//File file = new File("./Test Case 1");
		File currentDirectory = null;
		File projectDir = new File("Test Case 1");
        
		try{
			currentDirectory = new File(args[0]);
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Enter Correct Path");
		}
		  File Class_names[] = projectDir.listFiles((File pathName) -> pathName.getName().endsWith(".java"));
	      
		
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
		
		for(; StaticClass.index < cUnit.length; StaticClass.index++){
			new ClassVisitor().visit(cUnit[StaticClass.index], null);
		//	new FieldVisitor().visit(cUnit[StaticClass.index], null);
		//	new MethodVisitor().visit(cUnit[StaticClass.index], null);
		//	new ConstructorVisitor().visit(cUnit[StaticClass.index], null);
		//	new MethodCallVisitor().visit(cUnit[StaticClass.index], null);
		}
	}
}
