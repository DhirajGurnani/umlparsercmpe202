import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;


public class getting_function_information  extends VoidVisitorAdapter {
	ArrayList<String> Method_Names = new ArrayList<String>();
	@Override
    public void visit(MethodDeclaration n, Object obj) {
        System.out.println(n.getName());
       System.out.println(n.getModifiers());
        System.out.println(n.getType());
        System.out.println(n.getParameters());

		
		}
}