import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class getting_function_information  extends VoidVisitorAdapter {
	Vector<storing_function_information> Method_Names = new Vector<storing_function_information>();
	@Override
    public void visit(MethodDeclaration n, Object obj) {
        //System.out.println(n.getName());
		//System.out.println(n.getModifiers());
        //System.out.println(n.getType());
        //System.out.println(n.getParameters());
        boolean getset = false;
        if(n.getModifiers() == 1){
        	if(n.getName().substring(0, 3).equalsIgnoreCase("get")||n.getName().substring(0, 3).equalsIgnoreCase("set")){
        		getset = true;
        	}
        	if(!getset){
        		storing_function_information temp_function = new storing_function_information();
            	temp_function.name = n.getName();            	
            	temp_function.type = String.valueOf(n.getType());
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
        
        
        
		}
}