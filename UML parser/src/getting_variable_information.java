import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.Vector;


public class getting_variable_information extends VoidVisitorAdapter{
	   public Vector<storing_variable_information> Variable_Names = new Vector<storing_variable_information>();
	   public String Association;
	  int index = 0;
	@Override
	public void visit(FieldDeclaration n, Object obj){
		/*System.out.println("-----------------------------------------------------");
		System.out.println(String.valueOf(n.getVariables().get(0)));
		System.out.println(n.getModifiers());
		System.out.println(n.getType());
		
		*/

		System.out.println(n.getModifiers());
		String temp = String.valueOf(n.getVariables().get(0));
		if(temp.equalsIgnoreCase("message")){
			System.out.println("benchod");
		}
		if(n.getModifiers() == 4 || n.getModifiers() == 1){
			storing_variable_information temp_variable = new storing_variable_information();
			if(n.getModifiers() == 4){
				/*if(temp.equalsIgnoreCase("message")){
					System.out.println();
				}*/
				temp_variable.modifier = "-";// + temp + " : " + n.getType();
			} else {
				
				temp_variable.modifier = "+" ;//+ temp + " : " + n.getType();
			}
			
			temp_variable.name = temp;
			temp_variable.type = String.valueOf(n.getType());
			//System.out.println(getting_Class_information.Class_Names);
//			System.out.println(storing_all_classes.Class_active + " + " + n.getVariables());
			storing_all_classes.Classes.get(storing_all_classes.Class_active).Variables.addElement(temp_variable);
				
		}
		
		
		
	}
	
/*	public void empty_list(){
		Variable_Names.removeAll(Variable_Names);
	}
*/
}
