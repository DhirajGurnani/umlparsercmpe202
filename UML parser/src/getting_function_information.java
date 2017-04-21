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
        //if(n.getModifiers() == 1){
        //System.out.println(n.getName() +" : "+ n.getModifiers());
        	
//        	if(!getset){
        		storing_function_information temp_function = new storing_function_information();
            	temp_function.name = n.getName();            	
            	
            	if(n.getName().substring(0, 3).equalsIgnoreCase("get")||n.getName().substring(0, 3).equalsIgnoreCase("set")){
            		getset = true;
            		for(int i = 0;i<storing_all_classes.Classes.get(storing_all_classes.Class_active).Variables.size();i++){
            			storing_variable_information temp_variable = new storing_variable_information();
            			temp_variable = storing_all_classes.Classes.get(storing_all_classes.Class_active).Variables.get(i);
            			if(n.getName().substring(3, n.getName().length()).equalsIgnoreCase(temp_variable.name)){
            				//System.out.println("--------------------------------------------");
            				temp_function.is_setter_getter = true;
            				temp_variable.modifier = "+";
            			}
            		}
            	}
            	if(n.getModifiers() == 4){
    				/*if(temp.equalsIgnoreCase("message")){
    					System.out.println();
    				}*/
    				temp_function.modifier = "-";// + temp + " : " + n.getType();
    			} else if (n.getModifiers() == 1) {
    				
    				temp_function.modifier = "+" ;//+ temp + " : " + n.getType();
    			} else if ((n.getModifiers() == 2)){
    				temp_function.modifier = "#" ;
    			}else {
    				temp_function.modifier = "~";
    			}
            	
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
//        	}
        	
        //}
        
        
        
		}
}