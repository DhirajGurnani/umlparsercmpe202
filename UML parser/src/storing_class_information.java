import java.util.Vector;


public class storing_class_information {
	public String Name;
	public Vector<storing_variable_information> Variables = new Vector<storing_variable_information>();
	public boolean does_extend = false;
	public Vector<String> extending_class = new Vector<String>();
	public Vector<storing_function_information> Functions = new Vector<storing_function_information>();

	}
