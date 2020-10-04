package InterfaceGrafica;

public class Jogo{

	private int placar;
	private int minTemp;
	private int maxTemp;
	private int recMin;
	private int recMax;
	
	public Jogo() {
		
	}

	public Jogo(int placar, int minTemp, int maxTemp, int recMin, int recMax) {
		this.placar = placar;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.recMin = recMin;
		this.recMax = recMax;
	}

	public int getPlacar() {
		return placar;
	}

	public void setPlacar(int placar) {
		this.placar = placar;
	}

	public int getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(int minTemp) {
		this.minTemp = minTemp;
	}

	public int getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(int maxTemp) {
		this.maxTemp = maxTemp;
	}

	public int getRecMin() {
		return recMin;
	}

	public void setRecMin(int recMin) {
		this.recMin = recMin;
	}

	public int getRecMax() {
		return recMax;
	}

	public void setRecMax(int recMax) {
		this.recMax = recMax;
	}
	
	
	
	

	
	
	//Verificar a necessidade do toString
}
