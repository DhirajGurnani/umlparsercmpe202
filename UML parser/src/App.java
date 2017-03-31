
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
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
	        Class_Structure getclassnames = new Class_Structure();
	        Class_Names = getclassnames.getClasses(projectDir);
	        //System.out.println(Class_Names);
	        for(String x: Class_Names){
	        	//System.out.println(x);
	        	try {
	        		FileInputStream in;
						in = new FileInputStream("Test Case 1/"+x+".java");
			            // parse it
			            CompilationUnit cu = JavaParser.parse(in);

			            // visit and print the methods names
			            new MethodVisitor().visit(cu, null);
			     				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

   }
	    }
	}
new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
    System.out.println(path);
    System.out.println(Strings.repeat("=", path.length()));
    try {
        new NodeIterator(new NodeIterator.NodeHandler() {
            @Override
            public boolean haandle1(Node node) {
                if (node instanceof Statement) {
                    System.out.println(" [Lines " + node.getBegin() + " - " + node.getEnd() + " ] " + node);
                    return false;
                } else {
                    return true;
                }
            }

			@Override
			public boolean handle(Node node) {
				// TODO Auto-generated method stub
				return false;
			}
        }).explore(JavaParser.parse(file));
        System.out.println(); // empty line
    } catch (Exception e) {
        new RuntimeException(e);
    }
}).explore(projectDir);

