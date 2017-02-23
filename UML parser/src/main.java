import japa.parser.ast.CompilationUnit;

import java.io.File;
import java.io.FileInputStream;

import org.antlr.v4.runtime.*;

/*import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;*/
public class main {
	public static void main(String[] args) throws Exception {
        // creates an input stream for the file to be parsed
        //FileInputStream in = new FileInputStream("b.java");
		File in = new File("Test Case 1");
		
		File[] listOfClasses = in.listFiles();
		for (int i = 0; i < listOfClasses.length; i++) {
			String ClassName = listOfClasses[i].getName();
			//String ext = fileName.substring(fileName.length() - 4);
			if(ClassName.endsWith("java")){
				System.out.println(ClassName);
			}
		}

		//File fileTemp[] = in.listFiles((File pathName) -> pathName.getName().endsWith(".java"));
		//CompilationUnit cUnit[] = new CompilationUnit[fileTemp.length];
        // parse it
        //CompilationUnit cu = JavaParser.parse(in);

        // visit and print the methods names
       // new MethodVisitor().visit(cu, null);
    }

    
}
