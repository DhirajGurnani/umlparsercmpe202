import java.util.List;

import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.visitor.VoidVisitorAdapter;


public class getting_constructor_information extends VoidVisitorAdapter{
	@Override
	public void visit(ConstructorDeclaration n, Object obj){
//		System.out.println(n.getName());
//		System.out.println(n.getParameters());
		storing_function_information temp_function = new storing_function_information();
		temp_function.name = n.getName();
		temp_function.modifier = "+";
		temp_function.type = "";
		List<Parameter> parameterList = n.getParameters();
    	//System.out.println("lsbgoebdoigbpoiebpigbeipb");
		if(parameterList != null){
			for(Parameter temp : parameterList){
				String paramType = String.valueOf(temp.getType());//Parameter Type
				String paramName = String.valueOf(temp.getId());//Parameter Name
				temp_function.parameters.put(paramName, paramType);
			}
		}
		
		storing_all_classes.Classes.get(storing_all_classes.Class_active).Functions.addElement(temp_function);
	}
		
		
}
