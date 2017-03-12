import java.io.File;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.Node;
import com.google.common.base.Strings;


public class StatementsLinesExample {
	public static void statementsByLine(File projectDir) {
        new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
            System.out.println(path);
            System.out.println(Strings.repeat("=", path.length()));
            try {
                new NodeIterator(new NodeIterator.NodeHandler() {
                    @Override
                    public boolean haandle1(Node node) {
                        if (node instanceof Statement) {
                            System.out.println(" [Lines " + node.getBegin() + " - " + node.getEnd() + " ] " + node);
                            return false;
                        } else {
                            return true;
                        }
                    }

					@Override
					public boolean handle(Node node) {
						// TODO Auto-generated method stub
						return false;
					}
                }).explore(JavaParser.parse(file));
                System.out.println(); // empty line
            } catch (Exception e) {
                new RuntimeException(e);
            }
        }).explore(projectDir);
    }

}
