import java.io.File;
import java.util.ArrayList;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;


public class GettingClassNames {

	public static ArrayList listClasses(File projectDir) {
        ArrayList Class_Names = new ArrayList();

        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
        	
          //  System.out.println(path);
           // System.out.println(Strings.repeat("=", path.length()));
            //try {
                try {
					new VoidVisitorAdapter<Object>() {
					    @Override
					    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
					        super.visit(n, arg);
					        //System.out.println(" * " + n.getName());
					        Class_Names.add(n.getName());
//					        System.out.println(" * get members" + n.getMembers());
					    }
					}.visit(JavaParser.parse(file), null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
             //   System.out.println(); // empty line
            //} catch (ParseException | IOException e) {
                new RuntimeException();
            
        }).explore(projectDir);
        //ArrayList a[] = {"asd"};
        return Class_Names;
    }
}
