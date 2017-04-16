import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;


public class field_information_fetcher extends VoidVisitorAdapter{

	@Override
	public void visit(FieldDeclaration n, Object obj){
		System.out.println("-----------------------------------------------------");
		System.out.println(n.getVariables());
		System.out.println(n.getModifiers());
		System.out.println(n.getType());
	}

}
