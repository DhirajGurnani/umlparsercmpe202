import japa.parser.JavaParser;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class getting_Class_information  {
	  static ArrayList<String> Class_Names = new ArrayList<String>();
	  static ArrayList<String> Method_Names = new ArrayList<String>();
	  static ArrayList<String> Attribute_Names = new ArrayList<String>();
	  
		public static ArrayList getClasses(File projectDir) {
			ArrayList<String> parent_class = new ArrayList<String>();
			ArrayList<String> interfaces_names = new ArrayList<String>();
			
	        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
	        	
	          //  System.out.println(path);
	           // System.out.println(Strings.repeat("=", path.length()));
	            //try {
	                try {
						new VoidVisitorAdapter<Object>() {
						    @Override
						    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
						        super.visit(n, arg);
						        
			
						        List<ClassOrInterfaceType> interface_list = n.getImplements();
								if( interface_list != null){
									for(ClassOrInterfaceType a : interface_list){
										interfaces_names.add(a.getName());
									}
								}
								
								List<ClassOrInterfaceType> parent_list = n.getImplements();
								if( parent_list != null){
									for(ClassOrInterfaceType a : parent_list){
										parent_class.add(a.getName());
									}
								}
								
						        //System.out.println(n.getName() + " * " + n.getExtends()+" * "+n.getImplements());
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
