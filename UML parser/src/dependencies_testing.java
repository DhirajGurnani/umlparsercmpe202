import java.util.Map.Entry;
import java.util.Vector;


public class dependencies_testing {
	public Vector<dependency_list> all_dependencies= new Vector<dependency_list>();
	public void check(){
	//System.out.println("inside");
	for(int i = 0;i<storing_all_classes.Classes.size();i++){
		if(!storing_all_classes.Classes.get(i).is_interface){
		storing_class_information temp_class = new storing_class_information();
		temp_class = storing_all_classes.Classes.get(i);
		for(int j = 0; j< temp_class.Functions .size(); j++){
			storing_function_information temp_function = new storing_function_information();
			temp_function= temp_class.Functions.get(j);
			//System.out.println("name: "+ temp_class.Name);
			//System.out.println("variable type: "+ temp_variable.type);
			for(Entry<String, String> entry: temp_function.parameters.entrySet()){
				
			for(int k =0 ; k<storing_all_classes.Classes.size();k++){
				storing_class_information temp_check_class = new storing_class_information();
				temp_check_class = storing_all_classes.Classes.get(k);
				//System.out.println("name: "+ temp_check_class.Name);
				//System.out.println("variable type: "+ temp_variable.type);	
				
				if(temp_check_class.is_interface){
				if(temp_check_class.Name.equalsIgnoreCase(entry.getValue())){
					dependency_list temp_dependency = new dependency_list();
					temp_dependency.x = temp_class.Name;
					temp_dependency.y = temp_check_class.Name;
					all_dependencies.addElement(temp_dependency);
					
					j = temp_class.Functions.size();
					//System.out.println("checking kitni baar aaya");
					//temp_variable.association = true;
					//System.out.println("name: "+ temp_check_class.Name);
					//System.out.println("variable type: "+ temp_variable.type);
					/*boolean exist = false;
						for(int l =0 ;l<all_association.size();l++){
							if(temp_check_class.Name.equals(all_association.get(l).x) && temp_class.Name.equals(all_association.get(l).y)){
								exist = true;
								all_association.get(l).ytox = "1";
							}
						}*/
						
						/*if(!exist){
							Association_list temp_association = new Association_list();
							temp_association.x = temp_class.Name;
							temp_association.y = temp_check_class.Name;
							temp_association.xtoy = "1";
							all_association.addElement(temp_association);
						}*/
						
					//System.out.println("something is working");
				}
				}/* else if (temp_variable.type.length()>12){
					//System.out.println(temp_variable.type.substring(0,10));
					if(temp_variable.type.substring(0,10).equals("Collection")){
						temp_variable.association = true;
						//System.out.println("haveli");
						String temp_type  = temp_variable.type.substring(11, temp_variable.type.length()-1);
						if(temp_check_class.Name.equalsIgnoreCase(temp_type)){
							//System.out.println("inside the day");
							boolean exist = false;
							for(int l =0 ;l<all_association.size();l++){
								if(temp_check_class.Name.equals(all_association.get(l).x) && temp_class.Name.equals(all_association.get(l).y)){
									exist = true;
									all_association.get(l).ytox = "*";
								}
							}
							
							if(!exist){
								Association_list temp_association = new Association_list();
								temp_association.x = temp_class.Name;
								temp_association.y = temp_check_class.Name;
								temp_association.xtoy = "*";
								all_association.addElement(temp_association);
							}
						}
					}
				}*/
			}
			}
			}
			
		}
	}
	}

}
