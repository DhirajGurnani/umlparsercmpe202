import japa.parser.JavaParser;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.util.ArrayList;



public class Class_Structure {
	  static ArrayList<String> Class_Names = new ArrayList<String>();
	  static ArrayList<String> Method_Names = new ArrayList<String>();
	  static ArrayList<String> Attribute_Names = new ArrayList<String>();
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
						        
						    
						        System.out.println(" * " + n.getName());
						        //Class_Names.add(n.getName());
						        
						        Class_Names.add(n.getName());
						        
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
