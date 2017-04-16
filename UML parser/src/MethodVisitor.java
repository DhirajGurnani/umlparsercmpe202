import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;


/**
     * Simple visitor implementation for visiting MethodDeclaration nodes.
     */
    class MethodVisitor extends VoidVisitorAdapter {
    	@Override
        public void visit(MethodDeclaration n, Object obj) {
            /* here you can access the attributes of the method.
             this method will be called for all methods in this 
             CompilationUnit, including inner class methods */
/*            System.out.println(n.getName());
           System.out.println(n.getModifiers());
            System.out.println(n.getType());
            System.out.println(n.getParameters());
 */            //super.visit(n, arg);
        }
    }