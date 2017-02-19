
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.util.*;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.GeneratedImage;
import net.sourceforge.plantuml.SourceFileReader;
import net.sourceforge.plantuml.SourceStringReader;
/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws Exception {
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream("b.java");

        // parse it
        CompilationUnit cu = JavaParser.parse(in);
        
       // CompilationUnit cu = JavaParser.parse(javaFile);
        for (TypeDeclaration typeDec : cu.getTypes()) {
            List<BodyDeclaration> members = typeDec.getMembers();
            if(members != null) {
                for (BodyDeclaration member : members) {
                //Check just members that are FieldDeclarations
                FieldDeclaration field = (FieldDeclaration) member;
                //Print the field's class typr
                System.out.println(field.getElementType());
                //Print the field's name 
                System.out.println(field.getVariables().get(0).getName());
                //Print the field's init value, if not null
                Object initValue = field.getVariables().get(0).getInitializer();
                if(initValue != null) {
                     System.out.println(field.getVariables().get(0).getInitializer().toString());
                }  
            }
        }
        }
        // visit and print the methods names
   //     new MethodVisitor().visit(cu, null);
      //  new VariableVisitor().visit(cu,null);
        System.out.println("aaya kya?");
       // StringBuilder plantUmlSource = new StringBuilder();
        class Dummy {
        	 -field1
        	 #field2
        	 ~method1()
        	 +method2()
        	}
	     //   plantUmlSource.append("@startuml\n");
	        plantUmlSource.append("testdot");
        plantUmlSource.append("class Dummy {\n");
        plantUmlSource.append("-field1\n");
        plantUmlSource.append("#field2\n");
        plantUmlSource.append("~method1()\n");
        plantUmlSource.append("+method2()\n");
        plantUmlSource.append("}\n");
	        

//        plantUmlSource.append("class Dummy { -field1  #field2  ~method1()  +method2() } \n");

        plantUmlSource.append("Class11 <|.. Class12\n");
        plantUmlSource.append("Class13 --> Class14\n");
        plantUmlSource.append("Class15 ..> Class16\n");
        plantUmlSource.append("Class17 ..|> Class18\n");
        plantUmlSource.append("Class19 <--* Class20\n");
        
        
        
        
        plantUmlSource.append("@enduml");

        SourceStringReader reader = new SourceStringReader(plantUmlSource.toString());

        FileOutputStream output = new FileOutputStream(new File("uml.png"));

        reader.generateImage(output, new FileFormatOption(FileFormat.PNG, false));
    }

    /**
     * Simple visitor implementation for visiting MethodDeclaration nodes.
     *//*
    private static class MethodVisitor extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodDeclaration n, Void arg) {
             here you can access the attributes of the method.
             this method will be called for all methods in this 
             CompilationUnit, including inner class methods 
            System.out.println(n.getName());
            VariableDeclarationExpr m;
    	    List <VariableDeclarator> myVars = m.getVariables();
            System.out.println(n.getVariables());
          //  System.out.println("something is printing");
         //   super.visit(n, arg);
        }
    }	 
    private static class VariableVisitor extends VoidVisitorAdapter<Void>{
    	@Override
    	//@Override
    	public void visit(VariableDeclarationExpr n, Void arg)
    	{      
    		System.out.println("yaha pe aaya kya?");
    	    List <VariableDeclarator> myVars = n.getVariables();
    	        for (VariableDeclarator vars: myVars){
    	            System.out.println("Variable Name: "+vars.getName());
    	            }
    	}
    	@Override
		public void visit(CompilationUnit cu, Object object) {
			// TODO Auto-generated method stub
			
		}
    	}
*/
	}

