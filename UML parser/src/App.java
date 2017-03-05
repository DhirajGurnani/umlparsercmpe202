
import java.io.File;
import java.io.IOException;

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
	   public static void listClasses(File projectDir) {
	        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
	            System.out.println(path);
	            System.out.println(Strings.repeat("=", path.length()));
	            //try {
	                try {
						new VoidVisitorAdapter<Object>() {
						    @Override
						    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
						        super.visit(n, arg);
						        System.out.println(" * " + n.getName());
						        System.out.println(" * " + n.getMembers());
						    }
						}.visit(JavaParser.parse(file), null);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                System.out.println(); // empty line
	            //} catch (ParseException | IOException e) {
	                new RuntimeException();
	            
	        }).explore(projectDir);
	    }

	    public static void main(String[] args) {
	        File projectDir = new File("Test Case 1");
	        listClasses(projectDir);
	    }
	}

