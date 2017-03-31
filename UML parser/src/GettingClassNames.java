import java.io.File;
import java.util.ArrayList;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;


public class GettingClassNames {
    static ArrayList<String> Class_Names = new ArrayList<String>();
    static ArrayList<String> Extended_Class_Names = new ArrayList<String>();
    static ArrayList<String> Child_Class_Names = new ArrayList<String>();
    static ArrayList<String> Parent_Class_Names = new ArrayList<String>();
	public static ArrayList getClasses(File projectDir) {

        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
        	
          //  System.out.println(path);
           // System.out.println(Strings.repeat("=", path.length()));
            //try {
                try {
					new VoidVisitorAdapter<Object>() {
					    @Override
					    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
					        super.visit(n, arg);
					        
					    
					        //System.out.println(" * " + n.getNameAsString());
					        //Class_Names.add(n.getName());
					        Class_Names.add(n.getNameAsString());
					        
					        //String s = (() n.getName()).getSimpleName();
					        //System.out.println(" * get members" + n.getMembers());
					    }
					}.visit(JavaParser.parse(file), null);
				} catch (Exception e) {
					e.printStackTrace();
				}
                
                new RuntimeException();
            
        }).explore(projectDir);
        
        return Class_Names;
        
        
    }
}
