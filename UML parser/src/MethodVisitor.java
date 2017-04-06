import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


/**
     * Simple visitor implementation for visiting MethodDeclaration nodes.
     */
    class MethodVisitor extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodDeclaration n, Void arg) {
            /* here you can access the attributes of the method.
             this method will be called for all methods in this 
             CompilationUnit, including inner class methods */
            System.out.println(n.getName());
           System.out.println(n.getClass());
            System.out.println(n.getType());
            System.out.println(n.getName());
             super.visit(n, arg);
        }
    }