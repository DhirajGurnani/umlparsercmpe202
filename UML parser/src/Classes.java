import java.io.File;
import java.util.ArrayList;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;


public class Classes {
	static ArrayList<String> Method_Names = new ArrayList<String>();
	static ArrayList<String> Member_Names = new ArrayList<String>();
	public static void getMethods(File projectDir){
		new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));
            try {
                new VoidVisitorAdapter<Object>() {
                    @Override
                    public void visit(MethodCallExpr n, Object arg) {
                        super.visit(n, arg);
                        System.out.println(" [L " + n.getBegin() + "] " + n);
                    }
                }.visit(JavaParser.parse(file), null);
                System.out.println(); // empty line
            } catch (Exception e) {
                new RuntimeException(e);
            }
        }).explore(projectDir);
	        

	}
	  public static void main(String[] args) {
	        File projectDir = new File("Test Case 1");
	        getMethods(projectDir);
	    }
}
