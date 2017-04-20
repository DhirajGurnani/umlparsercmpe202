
import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;


import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter ;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import net.sourceforge.plantuml.SourceStringReader;

import com.google.common.base.Strings;


/**
 * Hello world!
 *
 */
public class App 
{
	    public static void main(String[] args) {
	    	 ArrayList<String> Class_Names = new ArrayList<String>();
	        File projectDir = new File("Test Case 1");
	        getting_Class_information getclassnames = new getting_Class_information();
	        //MethodVisitor getting_method_information = new MethodVisitor();
	        //Class_Names = getclassnames.getClasses(projectDir);
	        File fileTemp[] = projectDir.listFiles((File pathName) -> pathName.getName().endsWith(".java"));
	        
			CompilationUnit cUnit[] = new CompilationUnit[fileTemp.length];
			try{
				//parse all JAVA files
				for(int index=0; index < cUnit.length; index++){
					 cUnit[index] = JavaParser.parse(fileTemp[index]);
				}
			}catch(Exception e){
				System.out.println("Exception Occurred :: " + e.getMessage());
				e.printStackTrace();
			}
			
			storing_all_classes temp_class = new storing_all_classes();
			temp_class.Class_active = 0;
			for(;temp_class.Class_active < cUnit.length; temp_class.Class_active++){
				new getting_Class_information().visit(cUnit[temp_class.Class_active],null);
				new getting_variable_information().visit(cUnit[temp_class.Class_active],null);
			}
			
/*			field_information_fetcher w = new field_information_fetcher();
			w.visit(cUnit[0], null);
			field_information_fetcher w_1 = new field_information_fetcher();			
			System.out.println(w.Variable_Names);
			System.out.println("------------------------------------------------");
			w.empty_list();
			
			w_1.visit(cUnit[1], null);
			field_information_fetcher w_2 = new field_information_fetcher();			
			System.out.println(w_1.Variable_Names);
			System.out.println("------------------------------------------------");			
			w_1.empty_list();
			
			w_2.visit(cUnit[2], null);
			field_information_fetcher w_3 = new field_information_fetcher();
			System.out.println(w_2.Variable_Names);
			System.out.println("------------------------------------------------");			
			w_2.empty_list();
			
			w_3.visit(cUnit[3], null);
			System.out.println(w_3.Variable_Names);			
			w_3.empty_list();
*/			
			/*getting_variable_information[] a = new getting_variable_information[cUnit.length];
			for (int i = 0;i<cUnit.length;i++){
			 a[i] = new getting_variable_information();
			}
			for (int i = 0;i<cUnit.length;i++){
				a[i].visit(cUnit[i], null);
			}*/
			/*for (int i = 0;i<cUnit.length;i++){
				System.out.println(a[i].Variable_Names);
			}*/
			
			/*for(int in = 0; in < cUnit.length; in++){
				new getting_function_information().visit(cUnit[in], null);
			//	new ClassVisitor().visit(cUnit[in], null);
				field_information_fetcher a = new field_information_fetcher();
				a.visit(cUnit[in], null);
				a.empty_list();
			}
			*/
//			for (int i = 0;i<cUnit.length;i++){
//				System.out.println(a[i].Variable_Names);
//				System.out.println("---------------------------------------------");
//			}
			
			Association_tester association = new Association_tester();
			association.check();
			//System.out.println(association.all_association);
			OutputStream png = null;
			try {
				png = new FileOutputStream("output.png");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			String source = "@startuml\n";
			source += "skinparam classAttributeIconSize 0\n";
			//int i = 0;
			for(int association_index = 0;association_index < association.all_association.size(); association_index++){
				source += association.all_association.get(association_index).x+" \""+association.all_association.get(association_index).xtoy+"\" -- \""+association.all_association.get(association_index).ytox+"\" "+association.all_association.get(association_index).y+"\n";
			}
/*			source += "a -- b \n";
			source += "b -- a \n";
*/			for(int class_index = 0; class_index< storing_all_classes.Classes.size(); class_index++){
				
				storing_class_information disp_class = new storing_class_information();
				disp_class = storing_all_classes.Classes.get(class_index);
				source += "class "+ storing_all_classes.Classes.get(class_index).Name +" {\n";
				for(int variable_index = 0; variable_index < disp_class.Variables.size(); variable_index++){
					storing_variable_information disp_variable = new storing_variable_information();
					disp_variable = disp_class.Variables.get(variable_index);
					if(!disp_variable.association){
						source += disp_variable.modifier + disp_variable.name + " : " + disp_variable.type + "\n";
					}
				}
				
				source += "} \n";
				
				System.out.println("class "+ storing_all_classes.Classes.get(class_index).Name +"\n");
			}
/*			source += "class a { \n";
			source += "int x \n";
			
			source += "} \n";
			source += "class b {\n";
			source += "int y \n";
			
			source += "} \n";
*/			
			/*for(String x : getclassnames.Class_Names){
			source += "class "+ x +"{\n";
			
			for(String y: a[i].Variable_Names)
				source +=  y +"\n";
				
			source += "}\n";
			i++;
			}*/
			
			source += "@enduml\n";

			SourceStringReader reader = new SourceStringReader(source);
			// Write the first image to "png"
			try {
				String desc = reader.generateImage(png);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Return a null string if no generation
	    }
	}
//}
