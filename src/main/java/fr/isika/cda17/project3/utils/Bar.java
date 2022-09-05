package fr.isika.cda17.project3.utils;

public class Bar {
	private int[] modules;
	
	public Bar(int[] modules){
		this.modules = modules;
	}
	
	public Bar(String modules){
		this.modules = new int[modules.length()];
		for (int i=0; i<modules.length(); i++){
			this.modules[i] = Integer.parseInt(String.valueOf(modules.charAt(i)));
		}
	}
	
	public int[] getModules(){
		return this.modules;
	}
	
	public void addModules(String modules){
		if (this.modules != null){
			int[] modulesTemp = new int[modules.length() + this.modules.length];
			System.arraycopy(this.modules, 0, modulesTemp, 0, this.modules.length);
			for (int i=0; i<modules.length(); i++){
				modulesTemp[i+this.modules.length] = Integer.parseInt(String.valueOf(modules.charAt(i)));
			}
			this.modules = modulesTemp;
		}
		else{
			this.modules = new int[modules.length()];
			for (int i=0; i<modules.length(); i++){
				this.modules[i] = Integer.parseInt(String.valueOf(modules.charAt(i)));
			}
		}
	}
	
	public void addModules(int[] modules){
		if (this.modules != null){
			int[] modulesTemp = new int[modules.length + this.modules.length];
			System.arraycopy(this.modules, 0, modulesTemp, 0, this.modules.length);
			System.arraycopy(modules, 0, modulesTemp, this.modules.length, modules.length);
			this.modules = modulesTemp;
		}
		else{
			this.modules = new int[modules.length];
			System.arraycopy(modules, 0, this.modules, 0, this.modules.length);
		}
	}
	
	public void setModules(int[] modules){
		this.modules = modules;
	}
	
	public int getWidth(){
		return this.modules.length;
	}
	
	public int getModule(int pos){
		return this.modules[pos];
	}
	
	public void setModule(int pos, int value){
		this.modules[pos] = value;
	}
}