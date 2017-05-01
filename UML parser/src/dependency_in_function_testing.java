import java.util.Vector;

import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;


public class dependency_in_function_testing extends VoidVisitorAdapter{
	public Vector<dependency_list> in_function_list = new Vector<dependency_list>();
	
	public void visit(MethodDeclaration n, Object obj) {
		
		String a = String.valueOf(n.getBody());
		//System.out.println(a);
		String [] parts = a.split(" ");
		for(String x: parts){
		//System.out.println(x);
		for(int i = 0;i<storing_all_classes.Classes.size();i++){
			if(storing_all_classes.Classes.get(i).is_interface){
				
				if(x.equals(storing_all_classes.Classes.get(i).Name))
				{
					dependency_list temp = new dependency_list();
					
				temp.x = storing_all_classes.Classes.get(storing_all_classes.Class_active).Name;
				temp.y = storing_all_classes.Classes.get(i).Name;
				in_function_list.addElement(temp);
					//dependency_list temp_dependency = new dependency_list();
				//System.out.println(storing_all_classes.Classes.get(i).Name);
				}
			}
		}
	
		}
	}
	

}
