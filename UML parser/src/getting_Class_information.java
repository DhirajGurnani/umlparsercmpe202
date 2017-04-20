
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class getting_Class_information  extends VoidVisitorAdapter {
	@Override	
	public void visit(ClassOrInterfaceDeclaration n, Object obj){
		storing_class_information New_class = new storing_class_information();
		New_class.Name = n.getName();
		storing_all_classes.Classes.addElement(New_class);
	}
	
}
/*	  public static Vector Class_Names = new Vector();
	  
		public static Vector getClasses(File projectDir) {
			Vector parent_class = new Vector();
			Vector interfaces_names = new Vector();
			
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

*/

