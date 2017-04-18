import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;


public class getting_variable_information extends VoidVisitorAdapter{
	   public ArrayList<String> Variable_Names = new ArrayList<String>();
	   public String Association;
	  int index = 0;
	@Override
	public void visit(FieldDeclaration n, Object obj){
		/*System.out.println("-----------------------------------------------------");
		System.out.println(String.valueOf(n.getVariables().get(0)));
		System.out.println(n.getModifiers());
		System.out.println(n.getType());
		*/String temp = String.valueOf(n.getVariables().get(0));
		if(n.getModifiers() == 4 || n.getModifiers() == 1){
			if(n.getModifiers() == 4){
				temp = "-" + temp + " : " + n.getType();
			} else {
				temp = "+" + temp + " : " + n.getType();
			}
			
			
			Variable_Names.add(temp);
				
		}
		
		
		
	}
	
/*	public void empty_list(){
		Variable_Names.removeAll(Variable_Names);
	}
*/
}
