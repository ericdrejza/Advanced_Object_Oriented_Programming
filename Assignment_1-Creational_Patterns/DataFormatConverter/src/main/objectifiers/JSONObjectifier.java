package main.objectifiers;

public class JSONObjectifier extends Objectifier {
	
	public JSONObjectifier(){
		super();
		imp = null;
	}
	
	public JSONObjectifier(String imp){
		setImp(imp);
	}
	
	public void setImp(String imp) {
		if ("composite".equalsIgnoreCase(imp)) {
			this.imp = new JSONObjectifierCompositeImp();
		}
		else if ("decorator".equalsIgnoreCase(imp)) {
			this.imp = new JSONObjectifierDecoratorImp();
		}
	}
}
