import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;

public class ClassVisitor extends VoidVisitorAdapter {

	
	@Override
	public void visit(ClassOrInterfaceDeclaration classDeclaration, Object obj){
		
		String name = null;
		ArrayList<String> extend = new ArrayList<String>();
		ArrayList<String> interfaces = new ArrayList<String>();
		boolean isInterface = false;
		boolean isAbstract = false;
		
		//Getting Class Name
		name = classDeclaration.getName();
		
		//Getting Extended Base Classes
		List<ClassOrInterfaceType> extended = classDeclaration.getExtends();
		if(extended != null){
			for(ClassOrInterfaceType temp : extended){
				extend.add(temp.getName());
			}
		}
		
		//Getting Implemented Case Classes
		List<ClassOrInterfaceType> iFace = classDeclaration.getImplements();
		if(iFace != null){
			for(ClassOrInterfaceType temp :iFace ){
				interfaces.add(temp.getName());
			}
		}
		
		
		//Checking if Class is Interface or not 
		isInterface = classDeclaration.isInterface();
		
		//Checking if Class is Abstract or not---No method for this
		//classDeclaration.is
		
		//Setting the Fields
		//Setting the Methods
		
		ClassModel tempClass = new ClassModel();
		tempClass.setName(name);
		tempClass.setExtend(extend);
		tempClass.setInterfaces(interfaces);
		tempClass.setInterface(isInterface);
		tempClass.setAbstract(false);
		tempClass.setFieldList(new ArrayList<FieldModel>());
		tempClass.setMethodList(new ArrayList<MethodModel>());
		tempClass.setConstructorList(new ArrayList<ConstructorModel>());
		tempClass.setMethodCall(new HashMap<String, String>());
		
		StaticClass.classList.add(tempClass);
	}

}
